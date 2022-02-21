package com.gfa.fox_club.services;

import com.gfa.fox_club.models.Fox;
import com.gfa.fox_club.models.Trick;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrickCenter {
    List<Trick> tricks;

    private TrickCenter() {
        this.tricks = new ArrayList<>();
        tricks.add(new Trick("bite"));
        tricks.add(new Trick("hop"));
        tricks.add(new Trick("hunt"));
        tricks.add(new Trick("run"));
        tricks.add(new Trick("sleep"));
    }

    public List<Trick> getTricks() {
        return tricks;
    }

    public void setTricks(List<Trick> tricks) {
        this.tricks = tricks;
    }

    public List<Trick> getAvailableTricks(Fox fox) {
        return tricks.stream()
                .filter(t -> !fox.doesFoxKnowTrick(t))
                .collect(Collectors.toList());
    }
}
