package flowerstore.decorators;

import flowerstore.flower.Item;

public class PaperDecorator extends ItemDecorator {

    private static final double PAPER_PRICE = 13;

    public PaperDecorator(Item item) {
        super(item);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + PAPER_PRICE;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with Paper Wrap";
    }
}
