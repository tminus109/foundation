package minecraft;

import java.awt.*;
import java.util.Arrays;

public class Air extends Block {
    Air() {
        this.type = "air";
        this.color = new Color(0, 0, 0, 0);
        this.lightTransmission = 100;
        this.placeAfter = Arrays.asList("mud", "brick", "glass", "door", "window", "gold");
    }
}
