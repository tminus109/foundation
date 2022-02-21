package com.gfa.fox_club.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Fox {
    private String name;
    private Food food;
    private Drink drink;
    private List<Trick> tricks;
    private List<Action> actions;

    public Fox(String name) {
        this.name = name;
        this.food = new Food("no food");
        this.drink = new Drink("no drink");
        this.tricks = new ArrayList<>();
        this.actions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public List<Trick> getTricks() {
        return tricks;
    }

    public void setTricks(List<Trick> tricks) {
        this.tricks = tricks;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    @Override
    public String toString() {
        if (food.getName().equals("no food") && drink.getName().equals("no drink")) {
            return "This is " + name + ". Currently hungry and thirsty. This fox knows " + tricks.size() + " trick(s).";
        } else if (food.getName().equals("no food")) {
            return "This is " + name + ". Currently hungry but drinking " + drink + ". This fox knows " + tricks.size() + " trick(s).";
        } else if (drink.getName().equals("no drink")) {
            return "This is " + name + ". Currently living on " + food + " but thirsty. This fox knows " + tricks.size() + " trick(s).";
        } else {
            return "This is " + name + ". Currently living on " + food + " and " + drink + ". This fox knows " + tricks.size() + " trick(s).";
        }
    }

    public boolean doesFoxKnowTrick(Trick trick) {
        for (Trick value : tricks) {
            if (value.getName().equals(trick.getName())) {
                return true;
            }
        }
        return false;
    }

    public void learnNewTrick(Trick trick) {
        if (!doesFoxKnowTrick(trick)) {
            tricks.add(trick);
        }
    }

    public void addNewAction(Action action) {
        actions.add(action);
    }

    public List<Action> reverseActions() {
        List<Action> reversedActions = new ArrayList<>(actions);
        Collections.reverse(reversedActions);
        return reversedActions;
    }
}
