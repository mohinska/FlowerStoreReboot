package flowerstore.order;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import flowerstore.delivery.Delivery;
import flowerstore.flower.Flower;
import flowerstore.flower.FlowerBucket;
import flowerstore.flower.FlowerColor;
import flowerstore.flower.FlowerPack;
import flowerstore.flower.FlowerType;
import flowerstore.payment.Payment;
import flowerstore.payment.CreditCardPaymentStrategy;

public class OrderTest {

    @Test
    public void testCalculateTotalPrice() {
        Flower flower = new Flower(3.0, FlowerColor.RED, 5.0, FlowerType.TULIP);
        FlowerPack pack = new FlowerPack(flower, 2); // 10.0
        FlowerBucket bucket = new FlowerBucket();
        bucket.add(pack);

        Order order = new Order();
        order.addItem(bucket);

        Assertions.assertEquals(10.0, order.calculateTotalPrice());
    }

    @Test
    public void testProcessOrderSuccessAndFailure() {
        Flower flower = new Flower(3.0, FlowerColor.RED, 5.0, FlowerType.TULIP);
        FlowerPack pack = new FlowerPack(flower, 1); // 5.0
        FlowerBucket bucket = new FlowerBucket();
        bucket.add(pack);

        Order order = new Order();
        order.addItem(bucket);

        // successful payment + delivery
        Payment successPayment = new CreditCardPaymentStrategy(); // returns true
        Delivery deliveryMock = items -> "Delivered via TEST: " + items.size();

        order.setPaymentStrategy(successPayment);
        order.setDeliveryStrategy(deliveryMock);

        String result = order.processOrder();
        Assertions.assertTrue(result.startsWith("Delivered via TEST"));

        // payment fails
        Payment failPayment = price -> false;
        order.setPaymentStrategy(failPayment);
        String resultFail = order.processOrder();
        Assertions.assertEquals("Payment failed.", resultFail);

        // missing strategies
        Order bad = new Order();
        bad.addItem(bucket);
        Assertions.assertEquals("Error: Payment or Delivery strategy is not set.", bad.processOrder());
    }
}
