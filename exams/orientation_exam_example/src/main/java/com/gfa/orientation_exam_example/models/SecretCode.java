package com.gfa.orientation_exam_example.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SecretCode {
    private String secretCode;

    public SecretCode() {
        this.secretCode = generateSecretCode();
    }

    public String generateSecretCode() {
        int randomNumber = 1000 + (int) (Math.random() * 10000);
        return String.valueOf(randomNumber);
    }
}
