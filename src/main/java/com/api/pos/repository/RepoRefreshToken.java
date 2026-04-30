package com.api.pos.repository;

import com.api.pos.models.RefreshToken;
import com.api.pos.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepoRefreshToken extends JpaRepository<RefreshToken, Integer> {
    Optional<RefreshToken> findByToken(String token);
    void delete(User user);
}
