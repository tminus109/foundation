package the_garden;

import java.util.ArrayList;
import java.util.List;

public class Garden {
    List<Plant> plants;

    Garden() {
        this.plants = new ArrayList<>();
    }

    void addPlant(Plant plant) {
        plants.add(plant);
    }

    int thirstyPlantCount() {
        int count = 0;
        for (Plant plant : plants) {
            if (plant.needsWater()) {
                count++;
            }
        }
        return count;
    }

    void waterPlants(int amount) {
        System.out.println("AFTER WATERING THE GARDEN:\n");
        int waterAmountForEachPlant = amount / thirstyPlantCount();
        for (Plant plant : plants) {
            if (plant.needsWater()) {
                plant.drink(waterAmountForEachPlant);
            }
            plant.stateOfPlant();
        }
    }

    void showGarden() {
        for (Plant plant : plants) {
            plant.stateOfPlant();
        }
    }
}
