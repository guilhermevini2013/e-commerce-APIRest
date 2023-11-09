package com.example.ecommerce_restapi.controllers;
import com.example.ecommerce_restapi.dtos.CategoryDTO;
import com.example.ecommerce_restapi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    CategoryService service;
    @Autowired
    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<CategoryDTO>> list(@RequestParam(value = "page", defaultValue = "0") Integer pages,
                                                  @RequestParam(value = "linesPerPage", defaultValue = "15")Integer linesPerPage,
                                                  @RequestParam(value = "direction", defaultValue = "ASC") String direction,
                                                  @RequestParam(value = "orderBy", defaultValue = "id") String orderBy){
        return ResponseEntity.ok().body(service.list(PageRequest.of(pages,linesPerPage, Sort.Direction.valueOf(direction),orderBy)));
    }
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }
    @PostMapping
    public ResponseEntity<CategoryDTO> insert(@RequestBody CategoryDTO dto){
        CategoryDTO entity = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entity).toUri();
        return ResponseEntity.created(uri).body(entity);
    }
    @PutMapping(value = "{id}")
    public ResponseEntity<CategoryDTO> update(@PathVariable Long id,@RequestBody CategoryDTO dto){
        dto = service.alter(id,dto);
        return ResponseEntity.ok().body(dto);
    }
    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
