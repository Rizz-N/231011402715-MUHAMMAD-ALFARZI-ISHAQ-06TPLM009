package com.api.pos.repository;

import com.api.pos.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoPayment extends JpaRepository<Payment, Integer> {
}
