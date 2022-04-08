package com.gfa.backend_api.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Greeting {
    private String welcome_message;

    public Greeting(String name, String title) {
        this.welcome_message = "Oh, hi there " + name + ", my dear " + title + "!";
    }
}
