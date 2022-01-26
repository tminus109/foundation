package the_garden;

public class Main {
    public static void main(String[] args) {
        Garden gardenOfEden = new Garden();

        gardenOfEden.addPlant(new Tree("purple"));
        gardenOfEden.addPlant(new Tree("orange"));
        gardenOfEden.addPlant(new Flower("yellow"));
        gardenOfEden.addPlant(new Flower("blue"));

        gardenOfEden.showGarden();

        gardenOfEden.waterPlants(20);
        gardenOfEden.waterPlants(15);
    }
}
