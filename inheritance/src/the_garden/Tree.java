package the_garden;

public class Tree extends Plant {
    Tree(String color) {
        super(color);
        this.type = "tree";
        this.absorbance = 0.4;
        this.thirstLevel = 10;
    }
}
