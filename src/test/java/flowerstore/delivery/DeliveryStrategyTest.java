package flowerstore.delivery;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import flowerstore.flower.Item;

import java.util.ArrayList;
import java.util.List;

public class DeliveryStrategyTest {

    @Test
    public void testPostDelivery() {
        Delivery postDelivery = new PostDeliveryStrategy();
        List<Item> items = new ArrayList<>();

        String result = postDelivery.deliver(items);

        String expected = "Delivering items by Post. Total items: 0";
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testDHLDelivery() {
        Delivery dhlDelivery = new DHLDeliveryStrategy();
        List<Item> items = new ArrayList<>();

        String result = dhlDelivery.deliver(items);

        String expected = "Delivering items by DHL. Total items: 0";
        Assertions.assertEquals(expected, result);
    }
}