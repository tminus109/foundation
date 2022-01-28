package minecraft;

import java.awt.*;
import java.util.Arrays;

public class Glass extends Block {
    Glass(int lightTransmission) {
        this.type = "glass";
        this.color = new Color(0, 0, 0, 0);
        this.lightTransmission = lightTransmission;
        this.canBeCrossed = false;
        this.placeAfter = Arrays.asList("mud", "brick", "ice", "air", "glowstone", "door");
    }

    public Glass() {
        this.type = "glass";
        this.color = new Color(0, 0, 0, 0);
        this.lightTransmission = 99;
        this.canBeCrossed = false;
        this.placeAfter = Arrays.asList("mud", "brick", "ice", "air", "glowstone", "door");
    }
}
