package n11.bootcamp.homework01.payment;

public class CryptoPayment implements IPaymentMethod {
    @Override
    public String getMethodName() {
        return "Kripto Para (USDT)";
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("🔗 " + amount + " TL karşılığındaki USDT, cüzdandan başarıyla transfer edildi.");
    }
}