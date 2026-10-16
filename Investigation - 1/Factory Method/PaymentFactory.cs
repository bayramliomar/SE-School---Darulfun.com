public interface IPayment
{
    void Pay();
}

public class CardPayment : IPayment
{
    public void Pay()
    {
        Console.WriteLine("Payment by credit card");
    }
}

public class PayPalPayment : IPayment
{
    public void Pay()
    {
        Console.WriteLine("Payment by PayPal");
    }
}

public abstract class PaymentProcessor
{
    public abstract IPayment CreatePayment();

    public void ProcessPayment()
    {
        IPayment payment = CreatePayment();
        payment.Pay();
    }
}

public class CardPaymentProcessor : PaymentProcessor
{
    public override IPayment CreatePayment()
    {
        return new CardPayment();
    }
}

public class PayPalPaymentProcessor : PaymentProcessor
{
    public override IPayment CreatePayment()
    {
        return new PayPalPayment();
    }
}