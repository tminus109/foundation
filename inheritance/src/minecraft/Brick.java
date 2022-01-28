package minecraft;

import java.awt.*;
import java.util.Arrays;

public class Brick extends Block {
    Brick(Color color) {
        this.type = "brick";
        this.color = color;
        this.lightTransmission = 0;
        this.canBeCrossed = false;
        this.placeAfter = Arrays.asList("mud", "glass", "air", "door", "window");
    }

    Brick() {
        this.type = "brick";
        this.color = new Color(144, 76, 42);
        this.lightTransmission = 0;
        this.canBeCrossed = false;
        this.placeAfter = Arrays.asList("mud", "glass", "air", "door", "window");
    }
}
