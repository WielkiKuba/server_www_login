package com.www.serverWWW;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final JdbcUserDetailsManager jdbcUserDetailsManager;
    private final PasswordEncoder passwordEncoder;

    public UserService(JdbcUserDetailsManager jdbcUserDetailsManager, PasswordEncoder passwordEncoder) {
        this.jdbcUserDetailsManager = jdbcUserDetailsManager;
        this.passwordEncoder = passwordEncoder;
    }

    public void createUser(String username, String rawPassword) {
        String encodedPassword = passwordEncoder.encode(rawPassword);
        UserDetails userDetails = user(username,encodedPassword);
        jdbcUserDetailsManager.createUser(userDetails);
    }
    public UserDetails user(String username,String password){
        return User.withUsername(username)
                .password(password)
                .roles("USER")
                .build();
    }
}
