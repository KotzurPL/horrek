package pl.kotzur.horrek;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Wall implements Structure {
    private List<CompositeBlock> blocks;

    @Override
    public Optional<Block> findBlockByColor(String color) {
        Optional<Block> any;
        List<Block> tmpComBlo;
        for (CompositeBlock compositeBlock : blocks) {
            tmpComBlo = compositeBlock.getBlocks();
            any = tmpComBlo.stream().filter(element -> element.getColor().equals(color)).findAny();
            if (any.isPresent()) {
                return any;
            }
        }   
        return null;
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        List<Block> ret = new ArrayList<>();
        blocks.forEach((compositeBlock) -> {
            ret.addAll(compositeBlock.getBlocks().stream().filter(element -> element.getMaterial().equals(material)).toList());
        });
        return ret;
    }

    @Override
    public int count() {
        int all = 0;
        for (CompositeBlock compositeBlock : blocks) {
            all += compositeBlock.getBlocks().size();
        }
        return all;
    }
}
