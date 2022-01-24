import java.util.List;

public class Farm {
    List<Animal> listOfAnimals;
    int limit;

    Farm(int limit) {
        this.limit = limit;
    }

    public void breed() {
        if (listOfAnimals.size() < limit) {
            listOfAnimals.add(new Animal());
        }
    }

    public void sell() {
        Animal leastHungryAnimal = listOfAnimals.get(0);
        for (int i = 0; i < listOfAnimals.size(); i++) {
            if (listOfAnimals.get(i + 1).hunger < leastHungryAnimal.hunger) {
                leastHungryAnimal = listOfAnimals.get(i + 1);
            }
        }
        listOfAnimals.remove(leastHungryAnimal);
    }
}
