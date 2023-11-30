package com.example.ecommerce_restapi.dtos;

import com.example.ecommerce_restapi.models.Role;
import com.example.ecommerce_restapi.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Set<RoleDTO> roleDTOS = new HashSet<>();
    public UserDTO(User entity) {
        this.id = entity.getId();
        this.firstName = entity.getFirstName();
        this.lastName = entity.getLastName();
        this.email = entity.getEmail();
        entity.getRoles().forEach(x-> this.roleDTOS.add(new RoleDTO(x)));
    }

}
