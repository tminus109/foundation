package com.gfa.backend_api.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Error {
    private String error;

    public Error(String error) {
        this.error = error;
    }
}
