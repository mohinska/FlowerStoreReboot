package flowerstore.flower;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class FlowerBucket implements Item {

    private List<FlowerPack> flowerPacks;

    public void add(final FlowerPack flowerPack) {
        if (flowerPacks == null) {
            flowerPacks = new ArrayList<>();
        }
        flowerPacks.add(flowerPack);
    }

    @Override
    public double getPrice() {
        double price = 0;
        if (flowerPacks != null) {
            for (FlowerPack flowerPack : flowerPacks) {
                price += flowerPack.getPrice();
            }
        }
        return price;
    }

    @Override
    public String getDescription() {
        if (flowerPacks == null || flowerPacks.isEmpty()) {
            return "Empty flower bucket.";
        }
        return "Flower bucket containing " + flowerPacks.size() + " flower packs.";
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        FlowerBucket that = (FlowerBucket) obj;
        return Objects.equals(flowerPacks, that.flowerPacks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flowerPacks);
    }
}
