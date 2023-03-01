import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Wall implements Structure {
    private List<Block> blocks;

    @Override
    public Optional<Block> findBlockByColor(String color) {
        for (Block blockFromBlocksList : blocks) {
            if (blockFromBlocksList instanceof CompositeBlock) {
                for (Block blockInsideCompositeBlock : ((CompositeBlock) blockFromBlocksList).getBlocks()) {
                    if (blockInsideCompositeBlock.getColor().equals(color)) {
                        return Optional.of(blockInsideCompositeBlock);
                    }
                }
            } else {
                if (blockFromBlocksList.getColor().equals(color)) {
                    return Optional.of(blockFromBlocksList);
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        List<Block> blocksMadeOfSelectedMaterial = new ArrayList<>();
        blocks.forEach(blockFromBlocksList -> {
            if (blockFromBlocksList instanceof CompositeBlock) {
                ((CompositeBlock) blockFromBlocksList).getBlocks().forEach(blockInsideCompositeBlock -> {
                    if (blockInsideCompositeBlock.getMaterial().equals(material)) {
                        blocksMadeOfSelectedMaterial.add(blockInsideCompositeBlock);
                    }
                });
            } else {
                if (blockFromBlocksList.getMaterial().equals(material)) {
                    blocksMadeOfSelectedMaterial.add(blockFromBlocksList);
                }
            }
        });
        return blocksMadeOfSelectedMaterial;
    }

    @Override
    public int count() {
        int blocksCount = 0;
        for (Block blockFromBlocksList : blocks) {
            if (blockFromBlocksList instanceof CompositeBlock) {
                blocksCount += ((CompositeBlock) blockFromBlocksList).getBlocks().size();
            } else {
                blocksCount++;
            }
        }
        return blocksCount;
    }
}
