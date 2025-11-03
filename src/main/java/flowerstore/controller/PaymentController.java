package flowerstore.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import flowerstore.payment.PayPalPaymentStrategy;
import flowerstore.payment.Payment;
import flowerstore.payment.CreditCardPaymentStrategy;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @GetMapping
    public String pay(
            @RequestParam String strategy,
            @RequestParam double price) {
        Payment paymentStrategy;
        if (strategy.equalsIgnoreCase("creditcard")) {
            paymentStrategy = new CreditCardPaymentStrategy();
        } else if (strategy.equalsIgnoreCase("paypal")) {
            paymentStrategy = new PayPalPaymentStrategy();
        } else {
            return "Error: Unknown payment strategy.";
        }

        if (paymentStrategy.pay(price)) {
            return "Payment successful using " + strategy;
        } else {
            return "Payment failed.";
        }
    }
}