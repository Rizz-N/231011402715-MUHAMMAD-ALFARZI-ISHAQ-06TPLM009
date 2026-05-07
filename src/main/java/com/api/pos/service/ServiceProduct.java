package com.api.pos.service;

import com.api.pos.models.Category;
import com.api.pos.models.Product;
import com.api.pos.repository.RepositoryCategory;
import com.api.pos.repository.RepositoryProduct;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceProduct {
    private final RepositoryProduct repository;
    private final ServiceCategory serviceCategory;

    public Product create(Product product) {
        return repository.save(product);
    }

    public List<Product> getAll(){
        return repository.findAll();
    }

    public Product getById(Integer id) {
        return repository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
    }

    public Product update(Integer id, @NonNull Product request) {
        Product Existing = getById(id);

        Existing.setName(request.getName());
        Existing.setPrice(request.getPrice());
        Existing.setQuantity(request.getQuantity());

        Category category = serviceCategory
                .getById(request.getCategory().getId());

        Existing.setCategory(category);
        return repository.save(Existing);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
