package com.api.pos.service;

import com.api.pos.models.Category;
import com.api.pos.repository.RepoCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ServiceCategory {
    private final RepoCategory repository;

    public List<Category> GetAll() {
        return repository.findAll();
    }
    public Category getById(Integer id){
        return repository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Data tidak di temukan"));
    }
    public Category create(Category category){
        return repository.save(category);
    }
    public Category update(Integer id,Category category){
        Category existing = getById(id);
        existing.setName(category.getName());
        return repository.save(existing);
    }
    public void delete(Integer id){
        repository.deleteById(id);
    }
}
