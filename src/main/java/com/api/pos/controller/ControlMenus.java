package com.api.pos.controller;


import com.api.pos.Config.response;
import com.api.pos.models.Menus;
import com.api.pos.service.ServiceMenu;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/menu")
public class ControlMenus {
    private final ServiceMenu service;

    @GetMapping
    public response<List<Menus>> getAll() {
        List<Menus> data = service.GetAll();

            return new response<>(
                    data.isEmpty() ? "data kosong" :"success",
                    data,
                    null,
                    null,
                    1
            );

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Integer id) {
        Menus data = service.GetById(id);
        if(data == null) {
            return ResponseEntity.noContent().build();
        }else {
        return ResponseEntity.ok(
                new response<>(
                "success",
                data,
                null,
                null,
                1
                )
            );
        }
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
