package com.api.pos.repository;

import com.api.pos.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepoUser extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);
}
