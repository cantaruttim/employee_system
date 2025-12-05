package br.com.cantarutti.service;

import br.com.cantarutti.data.userDTO.UserDTO;
import br.com.cantarutti.model.user.User;
import br.com.cantarutti.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public UserDTO save(UserDTO dto) {
        User user = toEntity(dto);

        // get the pass and crypto it

        User saved = repository.save(user);
        return toDTO(saved);
    }

    public List<UserDTO> listAll() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public UserDTO findById(UUID id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return toDTO(user);
    }

    public UserDTO update(UUID id, UserDTO dto) {
        User user = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setUserName(dto.getUserName());
        user.setUserEmail(dto.getUserEmail());
        user.setUserPassword(dto.getUserPassword());
        user.setUserDateCreate(dto.getUserDateCreate());

        User updated = repository.save(user);
        return toDTO(updated);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    private User toEntity(UserDTO dto) {
        return new User(
            dto.getUserId() != null ? dto.getUserId() : UUID.randomUUID(),
            dto.getUserName(),
            dto.getUserEmail(),
            dto.getUserPassword(),
            dto.getUserDateCreate()
        );
    }

    private UserDTO toDTO(User user) {
        UserDTO dto = new UserDTO();        
        dto.setUserId(user.getUserId());
        dto.setUserName(user.getUserName());
        dto.setUserEmail(user.getUserEmail());
        dto.setUserPassword(user.getUserPassword());
        dto.setUserPerfil(user.getUserPerfil());
        dto.setUserDateCreate(user.getUserDateCreate());
        return dto;
    }
}
