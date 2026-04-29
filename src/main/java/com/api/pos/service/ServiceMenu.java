package com.api.pos.service;

import com.api.pos.models.Menus;
import com.api.pos.repository.RepoMenus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceMenu {
    private final RepoMenus repository;

    public List<Menus> GetAll(){
        return repository.findAll();
    }
    public Menus  GetById(int id){
        return repository.findById(id).orElseThrow();
    }
    public Menus create(Menus menus){
        return repository.save(menus);
    }
    public Menus Update(Integer id, Menus menus){
        Menus Existing = GetById(id);

        Existing.setName(menus.getName());
        Existing.setPrice(menus.getPrice());
        Existing.setStock(menus.getStock());
        Existing.setCategory(menus.getCategory());

        return repository.save(Existing);
    }
    public Menus updateStock(Integer id, Integer qty){
        Menus Menu = GetById(id);
        Menu.setStock(Menu.getStock() - qty);
        return repository.save(Menu);
    }
    public void delete(Integer id){
        repository.deleteById(id);
    }
}
