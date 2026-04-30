package com.api.pos.repository;

import com.api.pos.models.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoOrderItem extends JpaRepository<OrderItem, Long> {
}
