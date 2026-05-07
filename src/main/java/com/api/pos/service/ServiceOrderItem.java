package com.api.pos.service;

import com.api.pos.models.OrderItem;
import com.api.pos.repository.RepositoryOrderItem;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceOrderItem {

    private final RepositoryOrderItem repository;

    public List<OrderItem> getAll() {
        return repository.findAll();
    }

    public OrderItem getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Order item not found"
                        ));
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}