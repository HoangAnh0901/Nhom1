// 
package com.congnghevn.newsportal.service;

import com.congnghevn.newsportal.dto.RegisterRequest;
import com.congnghevn.newsportal.entity.User;
import com.congnghevn.newsportal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void register(RegisterRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        // Mã hóa mật khẩu trước khi lưu [cite: 21]
        user.setPassword(passwordEncoder.encode(request.getPassword())); 
        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        userRepository.save(user); // [cite: 20]
    }
}