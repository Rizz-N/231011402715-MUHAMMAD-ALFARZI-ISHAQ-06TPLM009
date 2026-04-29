package com.api.pos.controller;

import com.api.pos.models.Category;
import com.api.pos.service.ServiceCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/categories")
public class ControlCategory {
    private final ServiceCategory service ;

    @GetMapping
    public List<Category> getAll(){
        return service.GetAll();
    }

    @GetMapping("/{id}")
    public Category getOne(@PathVariable int id){
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Category update(@PathVariable int id, @RequestBody Category category){
        return service.update(id, category);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        service.delete(id);
    }
}
