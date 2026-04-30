package com.api.pos.controller;


import com.api.pos.Config.response;
import com.api.pos.models.Menus;
import com.api.pos.service.ServiceMenu;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/menu")
public class ControlMenus {
    private final ServiceMenu service;

    @GetMapping
    public response<List<Menus>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "6") int limit
    ) {

        Page<Menus> result = service.GetAll(page, limit);

        return new response<>(
                "success",
                result.getContent(),
                result.hasPrevious() ? page - 1 : null,
                result.hasNext() ? page + 1 : null,
                page
        );
    }

    @GetMapping("/{id}")
    public response<Menus> getOne(@PathVariable Integer id) {
        Menus data = service.GetById(id);

        return new response<>(
                "success",
                data,
                null,
                null,
                1
        );

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
