package com.api.pos.controller;

import com.api.pos.models.Category;
import com.api.pos.service.ServiceCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/category")
public class ControllerCategory {
    private final ServiceCategory  service;

    @GetMapping
    public List<Category> getAll(){
        return service.getCategories();
    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable Integer id){
        return service.getById(id);
    }

    @PostMapping
    public Category create(@RequestBody Category category){
        return service.CreateCategory(category);
    }

    @PutMapping("/{id}")
    public Category update(@PathVariable Integer id, @RequestBody Category category){
        return service.UpdateCategory(id, category);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        service.Delete(id);
    }
}
