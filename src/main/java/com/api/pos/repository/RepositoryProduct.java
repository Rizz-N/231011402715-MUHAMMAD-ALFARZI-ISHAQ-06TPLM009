package com.api.pos.repository;

import com.api.pos.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryProduct extends JpaRepository<Product, Integer> {
}
