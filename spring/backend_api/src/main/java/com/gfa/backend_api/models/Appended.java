package com.gfa.backend_api.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Appended {
    private String appended;

    public Appended(String appendable) {
        this.appended = appendable + "a";
    }
}
