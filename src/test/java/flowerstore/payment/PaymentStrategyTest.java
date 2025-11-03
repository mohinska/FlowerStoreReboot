package flowerstore.payment;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

public class PaymentStrategyTest {

    @Test
    public void testCreditCardPayment() {
        Payment creditCard = new CreditCardPaymentStrategy();
        double price = 100.50;

        boolean result = creditCard.pay(price);

        Assertions.assertTrue(result);
    }

    @Test
    public void testPayPalPayment() {
        Payment payPal = new PayPalPaymentStrategy();
        double price = 88.00;

        boolean result = payPal.pay(price);

        Assertions.assertTrue(result);
    }
}