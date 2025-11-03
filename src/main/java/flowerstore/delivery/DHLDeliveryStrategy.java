package flowerstore.delivery;

import java.util.List;

import flowerstore.flower.Item;

public class DHLDeliveryStrategy implements Delivery {
    @Override
    public String deliver(List<Item> items) {
        return "Delivering items by DHL. Total items: " + items.size();
    }
}