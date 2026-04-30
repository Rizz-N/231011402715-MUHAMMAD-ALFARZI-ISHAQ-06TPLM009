package com.api.pos.service;


import com.api.pos.models.User;
import com.api.pos.repository.RepoUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceUser {
    private final RepoUser repository;
    private final PasswordEncoder passwordEncoder;

    public User create(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return repository.save(user);
    }

    public User login(String username, String password) {
        User user = repository.findByUsername(username).orElseThrow(()-> new RuntimeException("User not found"));

        if(!passwordEncoder.matches(password, user.getPassword())){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Passsword salah");
        }
        return user;
    }


 public User getById(Integer id){
        return repository.findById(id).orElseThrow(()-> new RuntimeException("user not found"));
 }
 public User update(Integer id, User user){
        User existing = getById(id);
        existing.setUsername(user.getUsername());
        existing.setPassword(user.getPassword());
        return repository.save(existing);
}

 public void delete(Integer id){repository.deleteById(id);}

}
