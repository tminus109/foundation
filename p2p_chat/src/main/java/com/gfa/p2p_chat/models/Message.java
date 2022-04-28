package com.gfa.p2p_chat.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Message {
    @Id
    @GeneratedValue
    private long id;
    private String username;
    private LocalDateTime dateTime;
    private String message;

    public Message() {
        this.dateTime = LocalDateTime.now();
    }

    public Message(String username, LocalDateTime dateTime, String message) {
        this.username = username;
        this.dateTime = LocalDateTime.now();
        this.message = message;
    }
}
