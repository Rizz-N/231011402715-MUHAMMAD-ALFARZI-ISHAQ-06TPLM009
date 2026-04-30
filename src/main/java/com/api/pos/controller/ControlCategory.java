package com.api.pos.controller;

import com.api.pos.Config.response;
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
    public response<List<Category>> getAll(){
            List<Category> data = service.GetAll();

        if (data.isEmpty()) {
            return new response<>(
                404,
              "tidak ada data",
              data,
              null,
              null,
              null
            );
        } else {

            return new response<> (
                    200,
                "success",
                data,
                null,
                null,
                1
            );
        }
    }

    @PostMapping
    public Category create(@RequestBody Category category){
        return service.create(category);
    }

    @GetMapping("/{id}")
    public response<Category> getOne(@PathVariable int id){
        Category data = service.getById(id);
        return new response<> (
                200,
                "success",
                data,
                null,
                null,
                1
        );
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
