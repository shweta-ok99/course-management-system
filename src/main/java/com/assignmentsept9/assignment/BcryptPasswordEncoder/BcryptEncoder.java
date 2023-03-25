package com.assignmentsept9.assignment.BcryptPasswordEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class BcryptEncoder {

    @Autowired
    static PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public BcryptEncoder(PasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public static String encodePassword(String rawPassword) {
        return bCryptPasswordEncoder.encode(rawPassword);
    }
    public static boolean matchesPassword(String rawPassword, String hashPassword) {
        return bCryptPasswordEncoder.matches(rawPassword, hashPassword);
    }

}
