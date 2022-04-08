package com.gfa.backend_api.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sum {
    private int result;

    public Sum(Until until) {
        this.result = countSum(until);
    }

    public int countSum(Until until) {
        int number = until.getUntil();
        int sum = 0;
        for (int i = 0; i <= number; i++) {
            sum += i;
        }
        return sum;
    }
}
