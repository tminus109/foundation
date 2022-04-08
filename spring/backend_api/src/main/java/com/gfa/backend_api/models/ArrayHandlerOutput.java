package com.gfa.backend_api.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
public class ArrayHandlerOutput {
    private int result;

    public ArrayHandlerOutput(ArrayHandlerInput input) {
        this.result = handleInput(input);
    }

    public int handleInput(ArrayHandlerInput input) {
        return switch (input.getWhat()) {
            case "sum" -> sumArray(input.getNumbers());
            case "multiply" -> multiplyArray(input.getNumbers());
            case "double" -> doubleArray(input.getNumbers());
            default -> 0;
        };
    }

    public int sumArray(int[] array) {
        return Arrays.stream(array).sum();
    }

    public int multiplyArray(int[] array) {
        return Arrays.stream(array).reduce(1, (a, b) -> a * b);
    }

    public int doubleArray(int[] array) {
        return Arrays.stream(array).map(a -> a * 2).sum();
    }
}
