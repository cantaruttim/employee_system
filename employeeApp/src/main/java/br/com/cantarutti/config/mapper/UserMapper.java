package br.com.cantarutti.config.mapper;

import br.com.cantarutti.data.userDTO.UserDTO;
import br.com.cantarutti.model.user.UserEmployee;

public class UserMapper {

    // ======================================================
    // DTO → Entity
    // ======================================================

    public static UserEmployee toEntity(UserDTO dto) {

        if (dto == null) return null;

        UserEmployee user = new UserEmployee();
        user.setUserNameSystem(dto.getUserNameSystem());
        user.setUserPasswordSystem(dto.getUserPasswordSystem());
        user.setUserStatus(dto.getUserStatus());
        user.setFirstLogin(dto.isFirstLogin());
        user.setEmployeeId(dto.getEmployeeId());
        return user;
    }

    // ======================================================
    // Entity → DTO
    // ======================================================
    public static UserDTO toDTO(UserEmployee user) {

        UserDTO dto = new UserDTO();
        dto.setUserNameSystem(user.getUserNameSystem());
        dto.setUserPasswordSystem(user.getUserPasswordSystem());
        dto.setUserStatus(user.getUserStatus());
        dto.setFirstLogin(user.isFirstLogin());
        dto.setEmployeeId(user.getEmployeeId());
        return dto;
    }

}
