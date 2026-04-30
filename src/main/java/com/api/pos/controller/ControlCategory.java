package com.api.pos.controller;

import com.api.pos.Config.response;
import com.api.pos.models.Category;
import com.api.pos.service.ServiceCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/categories")
public class ControlCategory {
    private final ServiceCategory service ;

    @GetMapping
    public response<List<Category>> getAll(){
            List<Category> data = service.GetAll();

            return new response<> (
                data.isEmpty()?"Data kosong":"success",
                data,
                null,
                null,
                1
            );

    }

    @PostMapping
    public Category create(@RequestBody Category category){
        return service.create(category);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Integer id){
        Category data = service.getById(id);
        if(data == null){
            return ResponseEntity.noContent().build();
        }else{

        return ResponseEntity.ok (
               new response<>(
               "successs",
                data,
                null,
                null,
                1

            )
        );
        }
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
