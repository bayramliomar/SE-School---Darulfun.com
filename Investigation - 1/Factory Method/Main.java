public class Main { 
    
    public static void main(String[] args) {
        
        PaymentProcessor paymentProcessor = new CardPaymentProcessor();
        paymentProcessor.createPayment();      
    }
}