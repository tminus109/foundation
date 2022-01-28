package minecraft;

import java.awt.*;
import java.util.Arrays;

public class Lava extends Block {
    Lava() {
        this.type = "lava";
        this.color = Color.YELLOW;
        this.lightTransmission = 170;
        this.placeAfter = Arrays.asList("mud", "brick", "glass", "ice", "air", "glowstone");
        this.transformMap.put("mud", new Brick());
        this.transformMap.put("ice", new Air());
    }
}
