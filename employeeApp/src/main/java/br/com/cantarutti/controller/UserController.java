package br.com.cantarutti.controller;

import br.com.cantarutti.data.userDTO.UserDTO;
import br.com.cantarutti.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
     public ResponseEntity<List<UserDTO>> listAll() {
         return ResponseEntity.ok(service.listAll());
     }


}
