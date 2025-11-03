package flowerstore.delivery;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import flowerstore.flower.Flower;
import flowerstore.flower.FlowerBucket;
import flowerstore.flower.FlowerColor;
import flowerstore.flower.FlowerPack;
import flowerstore.flower.FlowerType;
import flowerstore.flower.Item;

import java.util.List;

@RestController
@RequestMapping("/api/delivery")
public class DeliveryController {

    private static final double TEST_SEPAL_LENGTH = 10.0;
    private static final double TEST_PRICE = 70.0;
    private static final int TEST_QUANTITY = 1;

    @GetMapping
    public String deliver(
            @RequestParam String strategy,
            @RequestParam String items) {

        Flower testFlower = new Flower(TEST_SEPAL_LENGTH, FlowerColor.RED, TEST_PRICE, FlowerType.ROSE);
        FlowerPack testPack = new FlowerPack(testFlower, TEST_QUANTITY);

        FlowerBucket testBucket = new FlowerBucket();
        testBucket.add(testPack);

        List<Item> dummyItems = List.of(testBucket);

        Delivery deliveryStrategy;
        if (strategy.equalsIgnoreCase("dhl")) {
            deliveryStrategy = new DHLDeliveryStrategy();
        } else if (strategy.equalsIgnoreCase("post")) {
            deliveryStrategy = new PostDeliveryStrategy();
        } else {
            return "Error: Unknown delivery strategy.";
        }

        return deliveryStrategy.deliver(dummyItems);
    }
}