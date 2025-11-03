package flowerstore.decorators;

import flowerstore.flower.Item;

public abstract class ItemDecorator implements Item {

    private Item item;

    public ItemDecorator(Item item) {
        this.item = item;
    }

    @Override
    public double getPrice() {
        return item.getPrice();
    }

    @Override
    public String getDescription() {
        return item.getDescription();
    }
}