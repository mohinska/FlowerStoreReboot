package flowerstore.flower;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class FlowerPackTest {

    @Test
    public void testGetPrice() {
        Flower flower = new Flower(4.0, FlowerColor.BLUE, 2.5, FlowerType.TULIP);
        FlowerPack pack = new FlowerPack(flower, 3);

        Assertions.assertEquals(7.5, pack.getPrice());
    }
}
