//package com.ru.spbstu.service;
//
//import com.ru.spbstu.entities.User;
//import com.ru.spbstu.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class AuthService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
//
//    public Optional<User> login(String login, String rawPassword) {
//        Optional<User> userOpt = userRepository.findByLogin(login);
//        if (userOpt.isPresent() && passwordEncoder.matches(rawPassword, userOpt.get().getPassword())) {
//            return userOpt;
//        }
//        return Optional.empty();
//    }
//}
