package br.com.cantarutti.controller;

import br.com.cantarutti.data.userDTO.UserDTO;
import br.com.cantarutti.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping String getMessage() {
        return "Hello to my private API Controller";
    }

    @PostMapping("/v1/users")
    public ResponseEntity<UserDTO> create(
            @RequestBody UserDTO dto
    ) {
        dto.setUserId(null); 
        UserDTO saved = service.save(dto);
        return ResponseEntity.status(201).body(saved);
    }

    @GetMapping("/v1/list_all/users")
    public ResponseEntity<List<UserDTO>> listAll() {
        List<UserDTO> list = service.listAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/v1/list/{id}/user")
    public ResponseEntity<UserDTO> getById(
            @PathVariable UUID id
    ) {
        UserDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/v1/update/{id}/user")
    public ResponseEntity<UserDTO> update(
            @PathVariable UUID id,
            @RequestBody UserDTO dto
    ) {
        UserDTO updated = service.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/v1/delete/{id}/user")
    public ResponseEntity<Void> delete(
            @PathVariable UUID id
    ) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
