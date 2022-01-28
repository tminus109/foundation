package minecraft;

import java.util.ArrayList;
import java.util.List;

public class Wall {
    List<Block> blocks = new ArrayList<>();

    void placeBlock(Block block) {
        Block lastBlock = getLastBlock();
        if (lastBlock == null) {
            blocks.add(block);
        } else if (block.canPlaceAfter(lastBlock)) {
            blocks.add(block);
            if (block.transformMap.containsKey(lastBlock.type)) {
                blocks.set(blocks.size() - 2, block.transformMap.get(lastBlock.type));
                block.transformedBlocks.add(lastBlock.type);
            }
        }
    }

    void printStatus() {
        System.out.println("Light transmitted: " + calculateLightTransmission() + ".");
        System.out.println();
        for (Block block : blocks) {
            block.printStatus();
        }
    }

    int calculateLightTransmission() {
        int lightTransmission = 0;
        for (Block block : blocks) {
            lightTransmission += block.getTransmission();
        }
        return lightTransmission / blocks.size();
    }

    Block getLastBlock() {
        if (blocks.size() != 0) {
            return blocks.get(blocks.size() - 1);
        } else {
            return null;
        }
    }
}
