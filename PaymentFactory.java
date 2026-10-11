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

class PaymentFactory {
    public static Payment create(String type) {
        return switch (type) {
            case "Card" -> new CardPayment();
            case "PayPal" -> new PayPalPayment();
            default -> throw new IllegalArgumentException();
        };
    }
}