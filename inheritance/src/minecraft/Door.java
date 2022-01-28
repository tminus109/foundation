package minecraft;

import java.awt.*;
import java.util.Arrays;

public class Door extends Block {
    Door(int quality, String producer, Color color, int lightTransmission) {
        this.type = "door";
        this.quality = quality;
        this.producer = producer;
        this.color = color;
        this.lightTransmission = lightTransmission;
        this.placeAfter = Arrays.asList("mud", "brick", "air", "window");
    }
}
