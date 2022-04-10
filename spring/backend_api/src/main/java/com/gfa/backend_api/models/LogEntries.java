package com.gfa.backend_api.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LogEntries {
    private List<Log> entries;
    private int entry_count;

    public LogEntries(List<Log> entries) {
        this.entries = entries;
        this.entry_count = entries.size();
    }
}
