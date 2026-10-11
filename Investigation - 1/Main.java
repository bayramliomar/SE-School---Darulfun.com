public class Main { 
    
    public static void main(String[] args) {
        
        Payment payment = PaymentFactory.create("Card");
        payment.pay(); 
        
    }
}