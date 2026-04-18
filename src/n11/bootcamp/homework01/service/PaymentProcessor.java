package n11.bootcamp.homework01.service;

import n11.bootcamp.homework01.log.ILogger;
import n11.bootcamp.homework01.payment.IPaymentMethod;

public class PaymentProcessor {
    private final ILogger logger;

    // Loger injection
    public PaymentProcessor(ILogger logger) {
        this.logger = logger;
    }

    //Ödeme işlemini başlatır kontrollerini gerçekleştirir ve sonuçlandırır.
    public void execute(IPaymentMethod method, double amount) {
        // Polimorfizm kullanarak seçilen yöntemin adını dinamik olarak alır ve süreci loglar
        logger.log(method.getMethodName() + " ile ödeme süreci başlatılıyor...");

        if (amount <= 0) {
            logger.log("HATA: Geçersiz bakiye girildi.0 ve 0'dan küçük bakiye girildi");
            return;
        }

        try {
            // Hangi ödeme yöntemi geldiyse onun içindeki ödeme mantığını tetikler
            method.processPayment(amount);
            logger.log("İşlem başarıyla tamamlandı.");
        } catch (Exception e) {
            logger.log("HATA: Ödeme sırasında sistemsel bir sorun oluştu.");
        }
    }
}
