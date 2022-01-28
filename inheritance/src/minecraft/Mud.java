package minecraft;

import java.awt.*;
import java.util.Arrays;

public class Mud extends Block {
    Mud() {
        this.type = "mud";
        this.color = Color.DARK_GRAY;
        this.lightTransmission = 0;
        this.canBeCrossed = false;
        this.placeAfter = Arrays.asList("brick", "air", "lava", "door", "window", "gold");
    }
}
