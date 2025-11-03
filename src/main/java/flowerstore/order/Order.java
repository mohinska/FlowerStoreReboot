package flowerstore.order;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import flowerstore.delivery.Delivery;
import flowerstore.flower.Item;
import flowerstore.payment.Payment;

public class Order {

    @Getter
    private List<Item> items = new ArrayList<>();

    @Setter
    private Payment payment;

    @Setter
    private Delivery delivery;

    public void setPaymentStrategy(Payment payment) {
        this.payment = payment;
    }

    public void setDeliveryStrategy(Delivery delivery) {
        this.delivery = delivery;
    }

    public double calculateTotalPrice() {
        double price = 0;
        for (Item item : items) {
            price += item.getPrice();
        }
        return price;
    }

    public String processOrder() {
        if (payment == null || delivery == null) {
            return "Error: Payment or Delivery strategy is not set.";
        }

        double price = calculateTotalPrice();
        if (payment.pay(price)) {
            return delivery.deliver(items);
        } else {
            return "Payment failed.";
        }
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }
}
