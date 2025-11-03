package flowerstore.flower;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class FlowerTest {

    @Test
    public void testFlowerGettersAndSetters() {
        Flower flower = new Flower(5.0, FlowerColor.RED, 10.0, FlowerType.ROSE);

        Assertions.assertEquals(5.0, flower.getSepalLength());
        Assertions.assertEquals(FlowerColor.RED, flower.getColor());
        Assertions.assertEquals(10.0, flower.getPrice());
        Assertions.assertEquals(FlowerType.ROSE, flower.getFlowerType());

        // mutate and assert
        flower.setPrice(12.5);
        Assertions.assertEquals(12.5, flower.getPrice());
    }
}
