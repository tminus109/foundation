package com.gfa.backend_api.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Factorial {
    private int result;

    public Factorial(Until until) {
        this.result = countFactorial(until);
    }

    public int countFactorial(Until until) {
        int number = until.getUntil();
        int factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
