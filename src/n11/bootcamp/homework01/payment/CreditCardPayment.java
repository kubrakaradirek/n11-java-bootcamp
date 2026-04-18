package n11.bootcamp.homework01.payment;

public class CreditCardPayment implements IPaymentMethod {
    @Override
    public String getMethodName() {
        return "Kredi Kartı";
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("💳 " + amount + " TL tutarındaki işlem Kredi Kartı pos cihazından çekildi.");
    }
}