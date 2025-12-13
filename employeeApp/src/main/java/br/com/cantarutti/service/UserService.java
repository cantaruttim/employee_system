package br.com.cantarutti.service;

import br.com.cantarutti.config.mapper.UserMapper;
import br.com.cantarutti.data.auth.ChangePasswordRequest;
import br.com.cantarutti.data.auth.LoginRequest;
import br.com.cantarutti.data.employeeDTO.EmployeeDTO;
import br.com.cantarutti.data.userDTO.UserDTO;
import br.com.cantarutti.model.user.UserEmployee;
import br.com.cantarutti.repository.user.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import br.com.cantarutti.config.utils.PasswordUtils;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    public UserService(
            UserRepository userRepo,
            PasswordEncoder passwordEncoder
    ) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    // -------------------------------
    // LIST ALL
    // -------------------------------
    public List<UserDTO> listAll() {
        return userRepo.findAll()
                .stream()
                .map(UserMapper::toDTO)
                .toList();
    }

    // -------------------------------------------------------------
    // FIND BY ID
    // -------------------------------------------------------------
    public UserDTO findById(String id) {

        UserEmployee user = userRepo.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "User not found: " + id
                        )
                );

        return UserMapper.toDTO(user);
    }

    // -------------------------------------------------------------
    // UPDATE
    // -------------------------------------------------------------
    public UserDTO update(String id, UserDTO dto) {

        UserEmployee user = userRepo.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "User not found: " + id
                        )
                );

        user.setUserNameSystem(dto.getUserNameSystem());
        user.setUserPasswordSystem(dto.getUserPasswordSystem());
        user.setFirstLogin(dto.isFirstLogin());
        user.setEmployeeId(dto.getEmployeeId());

        UserEmployee updated = userRepo.save(user);
        return UserMapper.toDTO(updated);
    }


    // -------------------------------------------------------------
    // DELETE
    // -------------------------------------------------------------
    public void delete(String id) {

        if (!userRepo.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "User not found: " + id
            );
        }

        userRepo.deleteById(id);
    }


    // -------------------------------
    // CREATE USER FROM EMPLOYEE
    // -------------------------------
    public UserEmployee createUserFromEmployee(EmployeeDTO dto) {

        String rawPassword =
                PasswordUtils.defaultPassword(dto.getRegistrationNumber());

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
