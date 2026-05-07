package com.api.pos.repository;

import com.api.pos.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryOrder extends JpaRepository<Order, Integer> {
}
