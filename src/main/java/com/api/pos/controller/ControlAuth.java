package com.api.pos.controller;


import com.api.pos.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class ControlAuth {
    private final AuthService authService;
    @PostMapping("login")
    public Map<String, String> login(@RequestBody Map<String, String> req){
        return authService.login(req.get("username"), req.get("password"));
    }

    @PostMapping("/refresh")
    public  Map<String, String> refresh(@RequestBody Map<String, String> req){
        String token = authService.refresh(req.get("refreshToken"));
        return Map.of("accessToken", token);
    }

    @PostMapping("logout")
    public void  logout(@RequestBody Map<String, String> req){
        authService.logout(req.get("refreshToken"));
    }
}
