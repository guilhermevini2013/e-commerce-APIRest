package com.example.ecommerce_restapi.service;

import com.example.ecommerce_restapi.dtos.*;
import com.example.ecommerce_restapi.models.Category;
import com.example.ecommerce_restapi.models.Product;
import com.example.ecommerce_restapi.models.Role;
import com.example.ecommerce_restapi.models.User;
import com.example.ecommerce_restapi.repositories.CategoryRepository;
import com.example.ecommerce_restapi.repositories.ProductRepository;
import com.example.ecommerce_restapi.repositories.RoleRepository;
import com.example.ecommerce_restapi.repositories.UserRepository;
import com.example.ecommerce_restapi.service.exceptions.DataBaseException;
import com.example.ecommerce_restapi.service.exceptions.ResourceNotFoundException;
import com.example.ecommerce_restapi.service.interfaces.Iservice;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@Service
public class UserService implements Iservice<UserDTO,UserInsertDTO> {
    @Autowired
    private UserRepository repository;
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public UserDTO insert(UserInsertDTO userDTO) {
        User entity = new User();
        copyDTOtoEntity(userDTO, entity);

        entity = repository.save(entity);
        return new UserDTO(entity);
    }

    @Override
    public UserDTO findById(Long l) {
        User entity = repository.findById(l).orElseThrow(() -> new ResourceNotFoundException("id not found " + l));
        return new UserDTO(entity);
    }

    @Override
    public void deleteById(Long id) {
        try {
            User entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not Found " + id));
            repository.delete(entity);
        } catch (DataIntegrityViolationException ex) {
            throw new DataBaseException("Integrity Violation");
//        }
        }
    }

    @Override
    public UserDTO alter(Long id, UserDTO userDTO) {
        try {
            User entity = repository.getReferenceById(id);
            copyDTOtoEntity(userDTO, entity);
            entity = repository.save(entity);
            return new UserDTO(entity);
        } catch (EntityNotFoundException ex) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

    @Override
    public Page<UserDTO> list(PageRequest pr) {
        return repository.findAll(pr).map(x-> new UserDTO(x));
    }
    private void copyDTOtoEntity(UserDTO dto, User entity){
        entity.setEmail(dto.getEmail());
        entity.setLastName(dto.getLastName());
        entity.setFirstName(dto.getFirstName());
        entity.getRoles().clear();
        for (RoleDTO roleDTO: dto.getRoleDTOS()){
            Role role = roleRepository.getReferenceById(roleDTO.getId());
            entity.getRoles().add(role);
        }
    }
}
