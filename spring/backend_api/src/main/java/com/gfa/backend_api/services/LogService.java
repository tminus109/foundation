package com.gfa.backend_api.services;

import com.gfa.backend_api.models.Log;
import com.gfa.backend_api.repositories.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {
    private final LogRepository logRepository;

    @Autowired
    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public void newLogEntry(String endpoint, String data) {
        logRepository.save(new Log(endpoint, data));
    }

    public List<Log> getLogs() {
        return (List<Log>) logRepository.findAll();
    }
}
