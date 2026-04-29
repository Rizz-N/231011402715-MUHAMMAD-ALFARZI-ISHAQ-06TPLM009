package com.api.pos.controller;


import com.api.pos.models.Menus;
import com.api.pos.service.ServiceMenu;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/menu")
public class ControlMenus {
    private final ServiceMenu service;

    @GetMapping
    public List<Menus> getAll() {
        return service.GetAll();
    }
    @GetMapping("/{id}")
    public Menus getOne(@PathVariable Integer id) {
        return service.GetById(id);
    }
    @PostMapping
    public Menus create(@RequestBody Menus menu) {
        return service.create(menu);
    }
    @PutMapping("/{id}")
    public Menus update(@PathVariable Integer id,@RequestBody Menus menu) {
        return service.Update(id, menu);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
    @PutMapping("/{id}/stock")
    public Menus updateStock(@PathVariable Integer id,@RequestBody Integer qty) {
        return service.updateStock(id, qty);
    }
}
