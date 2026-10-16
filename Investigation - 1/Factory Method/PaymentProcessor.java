interface Payment {
    void pay();
}

class CardPayment implements Payment {
    public void pay() {
        System.out.println("Card payment");
    }
}

class PayPalPayment implements Payment {
    public void pay() {
        System.out.println("PayPal payment");
    }
}

public abstract class PaymentProcessor {
    public abstract Payment createPayment();

    public void processPayment() {
        Payment payment = createPayment();
        payment.pay();
    }
}

class CardPaymentProcessor extends PaymentProcessor {

    @Override
    public Payment createPayment() {
        return new CardPayment();
    }
   
}

class PayPalPaymentProcessor extends PaymentProcessor {

    @Override
    public Payment createPayment() {
        return new PayPalPayment();
    }
    
}