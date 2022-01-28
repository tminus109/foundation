package minecraft;

import java.awt.*;
import java.util.Arrays;

public class Window extends Block {
    Window(int quality, String producer, Color color, int lightTransmission, boolean canBeCrossed) {
        this.type = "window";
        this.quality = quality;
        this.producer = producer;
        this.color = color;
        this.lightTransmission = lightTransmission;
        this.canBeCrossed = canBeCrossed;
        this.placeAfter = Arrays.asList("mud", "brick", "air", "door", "glowstone");
    }
}
