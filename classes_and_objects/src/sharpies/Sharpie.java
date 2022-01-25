package sharpies;

public class Sharpie {
    String color;
    int width;
    int inkAmount;

    Sharpie(String color, int width) {
        this.color = color;
        this.width = width;
        this.inkAmount = 100;
    }

    void use() {
        inkAmount -= 10;
    }
}
