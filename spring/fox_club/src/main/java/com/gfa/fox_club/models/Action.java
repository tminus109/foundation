package com.gfa.fox_club.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Action {
    private final String dateTime;
    private final String action;

    public Action(String action) {
        this.dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy MMMM dd, HH:mm:ss"));
        this.action = action;
    }

    @Override
    public String toString() {
        return dateTime + action;
    }
}
