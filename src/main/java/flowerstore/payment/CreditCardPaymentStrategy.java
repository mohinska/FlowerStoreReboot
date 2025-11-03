package flowerstore.payment;

public class CreditCardPaymentStrategy implements Payment {
    @Override
    public boolean pay(double price) {
        System.out.println("Paying " + price + " using Credit Card.");
        return true;
    }
}