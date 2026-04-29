package com.api.pos.repository;

import com.api.pos.models.Menus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoMenus extends JpaRepository<Menus, Integer> {
}
