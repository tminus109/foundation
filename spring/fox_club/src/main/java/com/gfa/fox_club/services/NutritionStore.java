package com.gfa.fox_club.services;

import com.gfa.fox_club.models.Drink;
import com.gfa.fox_club.models.Food;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class NutritionStore {
    List<Food> foods;
    List<Drink> drinks;

    public NutritionStore() {
        this.foods = new ArrayList<>(Arrays.asList(
                new Food("no food"),
                new Food("pancake"),
                new Food("steak"),
                new Food("pasta"),
                new Food("pizza"),
                new Food("hamburger")));
        this.drinks = new ArrayList<>(Arrays.asList(
                new Drink("no drink"),
                new Drink("coca cola"),
                new Drink("sparkling water"),
                new Drink("beer"),
                new Drink("lemonade"),
                new Drink("apple juice")));
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Drink> drinks) {
        this.drinks = drinks;
    }
}
