package com.api.pos.service;

import com.api.pos.models.Category;
import com.api.pos.repository.RepositoryCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceCategory {
    private final RepositoryCategory repository;

    public Category CreateCategory(Category category) {
        return repository.save(category);
    }

    public List<Category> getCategories() {
        return repository.findAll();
    }

    public Category getById(Integer id) {
        return repository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
    }

    public Category UpdateCategory(Integer id, Category category) {
        Category Existing = getById(id);

        Existing.setName(category.getName());

        return repository.save(Existing);
    }

    public void Delete(Integer id) {
        repository.deleteById(id);
    }
}
