package minecraft;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Block {
    String type;
    int quality;
    String producer;
    Color color;
    int lightTransmission;
    boolean canBeCrossed = true;
    List<String> placeAfter = new ArrayList<>();
    Map<String, Block> transformMap = new HashMap<>();
    List<String> transformedBlocks = new ArrayList<>();

    boolean canPlaceAfter(Block block) {
        return placeAfter.contains(block.type);
    }

    int getTransmission() {
        return lightTransmission;
    }

    void printStatus() {
        System.out.println("Block of type: " + type + ".");
        System.out.println("Has light transmission: " + lightTransmission + ".");
        printCanBeCrossed();
        printTransformations();
        printProducerAndQuality();
        System.out.println();
    }

    void printCanBeCrossed() {
        String crossOrNot = "Can be crossed.";
        if (!canBeCrossed) {
            crossOrNot = "Can not be crossed.";
        }
        System.out.println(crossOrNot);
    }

    void printTransformations() {
        if (!transformMap.isEmpty()) {
            if (transformedBlocks.size() == 0) {
                System.out.println("Made no transformations.");
            } else {
                for (String transformedBlock : transformedBlocks) {
                    System.out.println("Has transformed a block of type " + transformedBlock
                            + " to " + transformMap.get(transformedBlock).type + ".");
                }
            }
        }
    }

    void printProducerAndQuality() {
        if (producer != null) {
            System.out.println("Manufactured by " + producer
                    + " on quality level " + quality + ".");
        }
    }
}
