package com.example.ecommerce_restapi.repositories;

import com.example.ecommerce_restapi.Factory;
import com.example.ecommerce_restapi.dtos.CategoryDTO;
import com.example.ecommerce_restapi.models.Category;
import com.example.ecommerce_restapi.service.CategoryService;
import com.example.ecommerce_restapi.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class CategoryServiceTests {
    @InjectMocks
    private CategoryService categoryService;
    @Mock
    private CategoryRepository categoryRepository;
    private Category category;
    private CategoryDTO categoryDTO;
    private Long idExists;
    private Long idNotExists;
    private Page<Category> catDtoPage;
    @Captor
    private ArgumentCaptor<Category> categoryCaptor;
    @BeforeEach
    void setUp() {
        categoryCaptor = ArgumentCaptor.forClass(Category.class);
        idExists =1l;
        idNotExists = 2l;
        category = Factory.createCategory();
        categoryDTO = Factory.createCategoryDTO();
        catDtoPage = new PageImpl<>(List.of(category));
        doThrow(ResourceNotFoundException.class).when(categoryRepository).findById(idNotExists);
        when(categoryRepository.findById(idExists)).thenReturn(Optional.of(category));
        when(categoryRepository.findAll((Pageable)any())).thenReturn(catDtoPage);
        doNothing().when(categoryRepository).delete(category);
        when(categoryRepository.getReferenceById(idExists)).thenReturn(category);
        when(categoryRepository.save(any())).thenReturn(category);
        doThrow(EntityNotFoundException.class).when(categoryRepository).getReferenceById(idNotExists);
    }
    @Test
    public void insertShouldSaveObjectInRepository(){
        categoryService.insert(categoryDTO);
        verify(categoryRepository,times(1)).save(category);
    }
    @Test
    public void alterShouldNotAlterAndReturnResourceNotFoundExceptionWhenIdNotExists(){
        categoryDTO.setName("Hellow Word");
        assertThrows(ResourceNotFoundException.class,()-> categoryService.alter(idNotExists,categoryDTO));
        verify(categoryRepository,times(1)).getReferenceById(idNotExists);
        verify(categoryRepository,never()).save(any());
    }
    @Test
    public void alterShouldAlterAndReturnObjectWhenIdExists(){
        categoryDTO.setName("Hellow Word");
        categoryService.alter(idExists,categoryDTO);
        verify(categoryRepository,times(1)).getReferenceById(idExists);
        verify(categoryRepository,times(1)).save(categoryCaptor.capture());
        category = categoryCaptor.getValue();
        assertEquals(category.getName(),categoryDTO.getName());
    }
    @Test
    public void findByIdShouldReturnResourceNotFoundExceptionWhenIdNotExists(){
        assertThrows(ResourceNotFoundException.class,()-> categoryService.deleteById(idNotExists));
        verify(categoryRepository,times(1)).findById(idNotExists);
    }
    @Test
    public void findByIdShouldReturnObjectWhenIdExists(){
        CategoryDTO dto = categoryService.findById(idExists);
        assertEquals(dto.getId(),category.getId());
        verify(categoryRepository,times(1)).findById(idExists);
    }
    @Test
    public void listShouldReturnList(){
        Pageable pageable = PageRequest.of(0,10);
        assertNotNull(categoryService.list((PageRequest)pageable));
        verify(categoryRepository,times(1)).findAll(pageable);
    }
    @Test
    public void deleteShouldThrowResourceNotFoundExceptionWhenIdNotExists(){
        assertThrows(ResourceNotFoundException.class,()->categoryService.deleteById(idNotExists));
        verify(categoryRepository,times(1)).findById(idNotExists);
        verify(categoryRepository,never()).delete(any());
    }
    @Test
    public void deleteShouldDoNothingWhenIdExists(){
        assertDoesNotThrow(()-> categoryService.deleteById(idExists));
        verify(categoryRepository, times(1)).findById(idExists);
        verify(categoryRepository, times(1)).delete(category);
    }
}
