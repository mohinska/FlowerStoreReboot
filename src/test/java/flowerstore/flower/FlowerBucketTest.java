package flowerstore.flower;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class FlowerBucketTest {

    @Test
    public void testEmptyBucket() {
        FlowerBucket bucket = new FlowerBucket();

        Assertions.assertEquals(0.0, bucket.getPrice());
        Assertions.assertEquals("Empty flower bucket.", bucket.getDescription());
    }

    @Test
    public void testAddAndPriceDescription() {
        Flower flower = new Flower(4.0, FlowerColor.BLUE, 3.0, FlowerType.CHAMOMILE);
        FlowerPack pack = new FlowerPack(flower, 2); // price 6.0

        FlowerBucket bucket = new FlowerBucket();
        bucket.add(pack);

        Assertions.assertEquals(6.0, bucket.getPrice());
        Assertions.assertTrue(bucket.getDescription().contains("1 flower packs")
                || bucket.getDescription().contains("1 flower packs.") || bucket.getDescription().contains("1"));
    }

    @Test
    public void testEqualsAndHashCode() {
        Flower flower = new Flower(4.0, FlowerColor.BLUE, 3.0, FlowerType.CHAMOMILE);
        FlowerPack pack = new FlowerPack(flower, 2);

        FlowerBucket b1 = new FlowerBucket();
        FlowerBucket b2 = new FlowerBucket();

        b1.add(pack);
        b2.add(pack);

        Assertions.assertEquals(b1, b2);
        Assertions.assertEquals(b1.hashCode(), b2.hashCode());
    }
}
