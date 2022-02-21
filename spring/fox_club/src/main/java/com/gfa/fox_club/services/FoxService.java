package com.gfa.fox_club.services;

import com.gfa.fox_club.models.Fox;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoxService {
    private final List<Fox> foxes;

    public FoxService() {
        this.foxes = new ArrayList<>();
    }

    public List<Fox> getFoxes() {
        return foxes;
    }

    public Fox getFoxByName(String name) {
        for (Fox fox : foxes) {
            if (fox.getName().equals(name)) {
                return fox;
            }
        }
        return null;
    }

    public void addNewFox(Fox newFox) {
        foxes.add(newFox);
    }
}
