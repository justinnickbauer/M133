package com.justinbauer.cod.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderGenerator {
    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("$2a$10$0YpExc1hls3SsXgf2mXq/eD5iLacyE378Q2kxkGfFzWfLXTvwEgsW"));
    }
}
