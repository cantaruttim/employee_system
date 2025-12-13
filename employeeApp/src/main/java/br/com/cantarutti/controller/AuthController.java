package br.com.cantarutti.controller;

import br.com.cantarutti.data.auth.ChangePasswordRequest;
import br.com.cantarutti.data.auth.LoginRequest;
import br.com.cantarutti.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        userService.login(request);

        return ResponseEntity.ok("Login successful");
    }

    @PostMapping("/change-password")
    public ResponseEntity<?> changePassword(
            @RequestBody ChangePasswordRequest request
    ) {
        userService.changePassword(request);

        return ResponseEntity.ok("Password changed successfully");
    }
}
