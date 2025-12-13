package br.com.cantarutti.service;

import br.com.cantarutti.data.auth.ChangePasswordRequest;
import br.com.cantarutti.data.auth.LoginRequest;
import br.com.cantarutti.data.employeeDTO.EmployeeDTO;
import br.com.cantarutti.model.department.EmployeeCoordination;
import br.com.cantarutti.model.user.UserEmployee;
import br.com.cantarutti.repository.user.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {

    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;
    private final EmployeeCoordination employeeCoordination;

    public UserService(
            UserRepository userRepo,
            PasswordEncoder passwordEncoder,
            EmployeeCoordination employeeCoordination
    ) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.employeeCoordination = employeeCoordination;
    }

    public UserEmployee createUserFromEmployee(EmployeeDTO dto) {

        String rawPassword =
                employeeCoordination.defaultPassword(
                        dto.getRegistrationNumber()
                );

        UserEmployee user = new UserEmployee();

        user.setUserNameSystem(dto.getRegistrationNumber());
        user.setUserPasswordSystem(passwordEncoder.encode(rawPassword));
        user.setFirstLogin(true);
        user.setEmployeeId(dto.getId());

        userRepo.save(user);

        return user;
    }

    // validate if it's a first login
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        UserEmployee user = userRepo.findById(request.getUserName())
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials")
                );

        boolean valid = passwordEncoder.matches(request.getUserPassword(), user.getUserPasswordSystem());
        if (!valid) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials");
        }

        if (user.isFirstLogin()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("Please change your password on your first login.");
        }

        return ResponseEntity.ok("Login successful");
    }


    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordRequest request) {

        UserEmployee user = userRepo.findById(request.getUserName())
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not found")
                );

        boolean validOldPassword = passwordEncoder.matches(request.getOldPassword(), user.getUserNameSystem());
        if (!validOldPassword) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Old password is incorrect");
        }

        user.setUserPasswordSystem(passwordEncoder.encode(request.getNewPassword()));
        user.setFirstLogin(false);
        userRepo.save(user);

        return ResponseEntity.ok("Password changed successfully.");
    }

}
