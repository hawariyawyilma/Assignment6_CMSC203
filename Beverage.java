


/**
 * Abstract class for a beverage.
 */
public abstract class Beverage {
    private String bevName;
    private TYPE type;
    private SIZE size;
    private static final double BASE_PRICE = 2.0;
    private static final double SIZE_UPCHARGE = 1.0;

    public Beverage(String bevName, TYPE type, SIZE size) {
        this.bevName = bevName;
        this.type = type;
        this.size = size;
    }

    public String getBevName() {
        return bevName;
    }

    public TYPE getType() {
        return type;
    }

    public SIZE getSize() {
        return size;
    }

    public double getBasePrice() {
        return BASE_PRICE;
    }

    public double addSizePrice() {
        switch (size) {
            case MEDIUM:
                return BASE_PRICE + SIZE_UPCHARGE;
            case LARGE:
                return BASE_PRICE + 2 * SIZE_UPCHARGE;
            default:
                return BASE_PRICE;
        }
    }

    public abstract double calcPrice();

    @Override
    public String toString() {
        return bevName + ", " + size;
    }
}
