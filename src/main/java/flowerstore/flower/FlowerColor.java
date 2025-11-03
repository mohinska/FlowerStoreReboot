package flowerstore.flower;

public enum FlowerColor {

    RED("#FF0000"),
    BLUE("#0000FF");

    private final String stringRepresentation;

    FlowerColor(final String hexString) {
        this.stringRepresentation = hexString;
    }

    @Override
    public String toString() {
        return stringRepresentation;
    }
}
