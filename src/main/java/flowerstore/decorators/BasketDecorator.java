package flowerstore.decorators;

import flowerstore.flower.Item;

public class BasketDecorator extends ItemDecorator {
    private static final double BASKET_PRICE = 4;

    public BasketDecorator(Item item) {
        super(item);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + BASKET_PRICE;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with Basket Wrap";
    }
}
