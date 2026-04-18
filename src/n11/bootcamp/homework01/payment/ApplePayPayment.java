package n11.bootcamp.homework01.payment;

// Sisteme yepyeni bir ödeme yöntemi daha eklendi!
public class ApplePayPayment implements IPaymentMethod {

    @Override
    public String getMethodName() {
        return "Apple Pay";
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("🍎 " + amount + " TL tutarındaki işlem Kubra cihazınız üzerinden doğrulandı ve ödendi.");
    }
}