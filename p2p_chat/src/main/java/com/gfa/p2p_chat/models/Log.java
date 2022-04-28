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
public class Log {
    @Id
    @GeneratedValue
    private long id;
    private LocalDateTime dateTime;
    private String logLevel;
    private String path;
    private String method;
    private String requestData;

    public Log() {
        this.dateTime = LocalDateTime.now();
    }

    public Log(String logLevel, String path, String method, String requestData) {
        this.dateTime = LocalDateTime.now();
        this.logLevel = logLevel;
        this.path = path;
        this.method = method;
        this.requestData = requestData;
    }

    @Override
    public String toString() {
        return dateTime + " " + logLevel + " Request " + path + " " + method + " " + requestData;
    }
}
