package com.project.devops;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SecretVerifier {

    @Value("${DB_USERNAME:NOT_FOUND}")
    private String dbUser;

    @Value("${DB_PASSWORD:NOT_FOUND}")
    private String dbPass;

    @PostConstruct
    public void checkSecrets() {
        System.out.println("🔑 DB_USERNAME = " + dbUser);
        System.out.println("🔑 DB_PASSWORD = " + dbPass);
    }
}
