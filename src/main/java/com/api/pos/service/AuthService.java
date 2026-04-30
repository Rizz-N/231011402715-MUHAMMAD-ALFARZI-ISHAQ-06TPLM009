package com.api.pos.service;

import com.api.pos.models.RefreshToken;
import com.api.pos.models.User;
import com.api.pos.repository.RepoRefreshToken;
import com.api.pos.repository.RepoUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final RepoUser userRepo;
    private final RepoRefreshToken refreshRepo;
    private final PasswordEncoder encoder;
    private final JwtService jwtService;

    // LOGIN
    public Map<String, String> login(String username, String password) {

        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!encoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Password salah");
        }

        String accessToken = jwtService.generateToken(user.getUsername());

        String refreshToken = UUID.randomUUID().toString();

        RefreshToken rt = new RefreshToken();
        rt.setToken(refreshToken);
        rt.setUser(user);
        rt.setExpDate(Instant.now().plus(7, ChronoUnit.DAYS));

        refreshRepo.save(rt);

        return Map.of(
                "accessToken", accessToken,
                "refreshToken", refreshToken
        );
    }

    // REFRESH TOKEN
    public String refresh(String refreshToken) {

        RefreshToken token = refreshRepo.findByToken(refreshToken)
                .orElseThrow(() -> new RuntimeException("Invalid refresh token"));

        if (token.getExpDate().isBefore(Instant.now())) {
            throw new RuntimeException("Refresh token expired");
        }

        return jwtService.generateToken(token.getUser().getUsername());
    }

    // LOGOUT
    public void logout(String refreshToken) {
        refreshRepo.findByToken(refreshToken)
                .ifPresent(refreshRepo::delete);
    }
}