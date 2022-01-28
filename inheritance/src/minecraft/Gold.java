package minecraft;

import java.awt.*;
import java.util.Arrays;

public class Gold extends Block {
    Gold(int lightTransmission) {
        this.type = "gold";
        this.color = new Color(255, 215, 0);
        this.lightTransmission = lightTransmission;
        this.placeAfter = Arrays.asList("glowstone", "glass");
    }
}
