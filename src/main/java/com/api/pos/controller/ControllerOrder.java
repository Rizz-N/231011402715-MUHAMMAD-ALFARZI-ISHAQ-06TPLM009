package com.api.pos.controller;

import com.api.pos.models.Order;
import com.api.pos.models.Status;
import com.api.pos.service.ServiceOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class ControllerOrder {

    private final ServiceOrder service;

    @PostMapping
    public Order create(@RequestBody Order order) {
        return service.create(order);
    }

    @GetMapping
    public List<Order> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Order getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PatchMapping("/{id}/status")
    public Order updateStatus(
            @PathVariable Integer id,
            @RequestParam Status status
    ) {
        return service.updateStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {

        service.delete(id);

        return "Order deleted";
    }
}