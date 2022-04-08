package com.gfa.backend_api.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Double {
    private int received;
    private int result;

    public Double(int received) {
        this.received = received;
        this.result = received * 2;
    }
}
