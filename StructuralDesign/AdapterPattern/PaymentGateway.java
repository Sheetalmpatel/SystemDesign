//Payment Gateway Adapter: PayPal & Stripe Integration
//here you can also create Unifiedpayment adapter to use both PayPal and Stripe

public class PaymentGateway{
    public static void main(String[] args) {
        StripeAPI stripe= new StripeAPI();
        PaymentProcessor payment= new StripeAPIAdapter(stripe);
        payment.processPayment(100);

        PaymentProcessor paypalProcessor = new PayPalAdapter(new PayPalAPI());
        paypalProcessor.processPayment(200);


    }
}

 class PayPalAPI{
   public void sendPayment(double amount) {
       
       System.out.println("Sending payment of $" + amount + " via PayPal.");
   }
}

 class StripeAPI {
    public void sendPayment(double amount) { 
               System.out.println("Sending payment of $" + amount + " via Stripe.");

     }
}

interface PaymentProcessor{
    void processPayment(double amount);
}

class PayPalAdapter implements  PaymentProcessor{
    PayPalAPI paypal;
    PayPalAdapter(PayPalAPI paypal){
        this.paypal=paypal;
    }
    @Override
    public  void processPayment(double amount){
        paypal.sendPayment(amount);
    }
}
class StripeAPIAdapter implements  PaymentProcessor{
    StripeAPI stripe;
    StripeAPIAdapter(StripeAPI stripe){
        this.stripe=stripe;
    }
    @Override
    public  void processPayment(double amount){
        stripe.sendPayment(amount);
    }
}
