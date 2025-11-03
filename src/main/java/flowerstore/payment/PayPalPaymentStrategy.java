package flowerstore.payment;

public class PayPalPaymentStrategy implements Payment {
    @Override
    public boolean pay(double price) {
        // Тут мала б бути складна логіка PayPal
        System.out.println("Paying " + price + " using PayPal.");
        return true;
    }
}