package flowerstore.decorators;

import flowerstore.flower.Item;

public class RibbonDecorator extends ItemDecorator {
    private static final double RIBBON_PRICE = 40;

    public RibbonDecorator(Item item) {
        super(item);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + RIBBON_PRICE;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with Ribbon Wrap";
    }
}
