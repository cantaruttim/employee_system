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
import br.com.cantarutti.config.utils.PassWordUtils;

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

    // -------------------------------
    // CREATE USER FROM EMPLOYEE
    // -------------------------------
    public UserEmployee createUserFromEmployee(EmployeeDTO dto) {

        String rawPassword =
                PassWordUtils.defaultPassword(dto.getRegistrationNumber());

        UserEmployee user = new UserEmployee();
        user.setUserNameSystem(dto.getRegistrationNumber());
        user.setUserPasswordSystem(passwordEncoder.encode(rawPassword));
        user.setFirstLogin(true);
        user.setEmployeeId(dto.getId());

        return userRepo.save(user);
    }

    // -------------------------------
    // LOGIN
    // -------------------------------
    public void login(LoginRequest request) {

        UserEmployee user = userRepo
                .findByUserNameSystem(request.getUserName())
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.UNAUTHORIZED, "Invalid credentials"
                        )
                );

        boolean valid =
                passwordEncoder.matches(
                        request.getUserPassword(),
                        user.getUserPasswordSystem()
                );

        if (!valid) {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED, "Invalid credentials"
            );
        }

        if (user.isFirstLogin()) {
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN,
                    "Please change your password on first login"
            );
        }
    }

    // -------------------------------
    // CHANGE PASSWORD
    // -------------------------------
    public void changePassword(ChangePasswordRequest request) {

        UserEmployee user = userRepo
                .findByUserNameSystem(request.getUserName())
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.UNAUTHORIZED, "User not found"
                        )
                );

        boolean validOldPassword =
                passwordEncoder.matches(
                        request.getOldPassword(),
                        user.getUserPasswordSystem()
                );

        if (!validOldPassword) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Old password is incorrect"
            );
        }

        user.setUserPasswordSystem(
                passwordEncoder.encode(request.getNewPassword())
        );
        user.setFirstLogin(false);

        userRepo.save(user);
    }
}
