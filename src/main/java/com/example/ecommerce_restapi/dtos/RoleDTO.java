package com.example.ecommerce_restapi.dtos;

import com.example.ecommerce_restapi.models.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class RoleDTO {
    private Long id;
    private String authority;
    public RoleDTO(Role entity){
        id = entity.getId();
        authority = entity.getAuthority();
    }
}
