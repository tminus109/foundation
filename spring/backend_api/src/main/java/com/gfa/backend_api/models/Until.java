package com.gfa.backend_api.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Until {
    private int until;

    @Override
    public String toString() {
        return "until=" + until;
    }
}
