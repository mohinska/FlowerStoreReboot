package flowerstore.delivery;

import java.util.List;

import flowerstore.flower.Item;

public interface Delivery {
    String deliver(List<Item> items);
}