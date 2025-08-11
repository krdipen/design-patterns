package com.krdipen.payment;

public class App {

    public static void main(String[] args) {
        PaymentStrategy cardPayment = new CardPayment();
        PaymentService paymentService = new PaymentService(cardPayment);
        paymentService.pay(1000);

        PaymentStrategy upiPayment = new UPIPayment();
        paymentService.setPaymentStrategy(upiPayment);
        paymentService.pay(500);
    }
}
