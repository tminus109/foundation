package minecraft;

import java.awt.*;
import java.util.Arrays;

public class Ice extends Block {
    Ice() {
        this.type = "ice";
        this.color = new Color(0, 0, 0, 0);
        this.lightTransmission = 97;
        this.canBeCrossed = false;
        this.placeAfter = Arrays.asList("mud", "brick", "glass", "lava", "air", "glowstone");
        this.transformMap.put("lava", new Glass());
    }
}
