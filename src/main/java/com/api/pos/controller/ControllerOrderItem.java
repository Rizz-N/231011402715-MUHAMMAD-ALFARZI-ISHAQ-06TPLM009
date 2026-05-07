package com.api.pos.controller;

import com.api.pos.models.OrderItem;
import com.api.pos.service.ServiceOrderItem;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order-items")
@RequiredArgsConstructor
public class ControllerOrderItem {

    private final ServiceOrderItem service;

    @GetMapping
    public List<OrderItem> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public OrderItem getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {

        service.delete(id);

        return "Order item deleted";
    }
}