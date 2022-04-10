package com.gfa.backend_api.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
public class ArrayHandlerInput {
    private String what;
    private int[] numbers;

    @Override
    public String toString() {
        return "what=" + what + ", numbers=" + Arrays.toString(numbers);
    }
}
