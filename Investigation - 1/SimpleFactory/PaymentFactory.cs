public interface IPayment
{
    void Pay();
}

public class CardPayment : IPayment
{
    public void Pay()
    {
        Console.WriteLine("Card payment");
    }
}

public class PayPalPayment : IPayment
{
    public void Pay()
    {
        Console.WriteLine("PayPal payment");
    }
}

public static class PaymentFactory
{
    public static IPayment Create(string type)
    {
        return type switch
        {
            "Card" => new CardPayment(),
            "PayPal" => new PayPalPayment(),
            _ => throw new ArgumentException()
        };
    }
}