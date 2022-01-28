package minecraft;

import java.awt.*;
import java.util.Arrays;

public class Glowstone extends Block {
    Glowstone() {
        this.type = "glowstone";
        this.color = Color.WHITE;
        this.lightTransmission = 300;
        this.canBeCrossed = false;
        this.placeAfter = Arrays.asList("glass", "ice", "air", "lava");
        this.transformMap.put("glass", new Gold(160));
    }
}
