package n11.bootcamp.homework01.payment;

public interface IPaymentMethod {
    String getMethodName(); // Console'da dinamik ödeme isim göstermek için bu metot tanımlandı.
    void processPayment(double amount); //Ödeme süreci için
}
