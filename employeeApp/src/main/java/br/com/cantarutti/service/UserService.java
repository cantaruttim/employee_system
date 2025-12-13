package br.com.cantarutti.service;

import br.com.cantarutti.data.employeeDTO.EmployeeDTO;
import br.com.cantarutti.model.department.EmployeeCoordination;
import br.com.cantarutti.model.user.UserEmployee;
import br.com.cantarutti.repository.user.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;
    private final EmployeeCoordination employeeCoordination;

    public UserService(UserRepository userRepo,
                       PasswordEncoder passwordEncoder,
                       EmployeeCoordination employeeCoordination) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.employeeCoordination = employeeCoordination;
    }

    public UserEmployee createUserFromEmployee(EmployeeDTO employeeDTO) {

        String rawPassword =
                employeeCoordination.defaultPassword(
                        employeeDTO.getRegistrationNumber()
                );

        UserEmployee user = new UserEmployee();
        user.setUserNameSystem(employeeDTO.getRegistrationNumber()); // ou outro identificador
        user.setUserPasswordSystem(passwordEncoder.encode(rawPassword));
        user.setFirstLogin(true);

        userRepo.save(user);

        return user;
    }
}
