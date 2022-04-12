package com.gfa.backend_api.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Until {
    private int until;

    @Override
    public String toString() {
        return "until=" + until;
    }
}
