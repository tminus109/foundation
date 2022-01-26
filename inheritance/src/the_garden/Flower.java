package the_garden;

public class Flower extends Plant {
    Flower(String color) {
        super(color);
        this.type = "flower";
        this.absorbance = 0.75;
        this.thirstLevel = 5;
    }
}
