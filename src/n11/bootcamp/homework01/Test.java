package n11.bootcamp.homework01;

import n11.bootcamp.homework01.log.ConsoleLogger;
import n11.bootcamp.homework01.log.ILogger;
import n11.bootcamp.homework01.payment.ApplePayPayment;
import n11.bootcamp.homework01.payment.CreditCardPayment;
import n11.bootcamp.homework01.payment.CryptoPayment;
import n11.bootcamp.homework01.payment.IPaymentMethod;
import n11.bootcamp.homework01.service.PaymentProcessor;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static  void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Altyapı Hazırlığı: Loglama ve İşlemci nesnelerinin kurulması
        ILogger logger = new ConsoleLogger();
        PaymentProcessor processor = new PaymentProcessor(logger);

        // 2. Nesne Tanımlama: Ödeme yöntemlerini nesne referansları üzerinden oluşturma
        IPaymentMethod creditCard = new CreditCardPayment();
        IPaymentMethod crypto = new CryptoPayment();
        IPaymentMethod applePay = new ApplePayPayment();

        // 3. Liste Yönetimi: Polimorfizm kullanarak tüm yöntemleri tek bir listede toplama
        List<IPaymentMethod> availableMethods = new ArrayList<>();
        availableMethods.add(creditCard);
        availableMethods.add(crypto);
        availableMethods.add(applePay);

        // 4. Dinamik Menü: Liste uzunluğuna göre otomatik seçim ekranı oluşturma
        System.out.println("=== Ödeme Altyapısı ===");
        for (int i = 0; i < availableMethods.size(); i++) {
            System.out.println((i + 1) + ". " + availableMethods.get(i).getMethodName());
        }

        int result = 0;

        // 5. Kullanıcıya Ödeme Türü Seçtirme Döngüsü: Ödeme yöntemi seçtirme ve farklı seçimler sonucu hata mesajları yazdırma
        //Doğru giriş yapılasıya kadar döngü tekrarı
        while (true) {
            try {
                System.out.print("Lütfen bir ödeme yöntemi seçiniz (1-" + availableMethods.size() + "): ");
                result = scanner.nextInt();
                //Seçilen ödeme yöntemi kontrolleri
                if (result >= 1 && result <= availableMethods.size()) {
                    break;
                } else {
                    System.out.println("Sadece listedeki rakamlardan (1-" + availableMethods.size() + ") bir seçim yapınız!\n");
                }
            } catch (InputMismatchException e) {
                // Eğer harf girilirse hata mesajı yazdırılır.
                System.out.println("Harf veya geçersiz karakter girilmemelidir ! Lütfen bir rakam giriniz.\n");
                scanner.next(); // KRİTİK: Scanner'ın içindeki o yanlış harfi (ş) çöpe atar, yoksa sonsuz döngü yapar!
            }
        }

        // 6. Tutar Girişi: Negatif değer ve tip kontrolü
        // Doğru giriş yapılasıya kadar döngü tekrarı
        double amount = 0;
        while (true) {
            try {
                System.out.print("Ödenecek tutarı giriniz (TL): ");
                amount = scanner.nextDouble();

                if (amount > 0) {
                    break;
                } else {
                    System.out.println("Geçersiz tutar! Lütfen 0'dan büyük bir bakiye giriniz.\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("Tutar kısmına sadece sayı girebilirsiniz!\n");
                scanner.next(); //Yanlış giriş temizleme
            }
        }

        // 7.  Seçilen ödeme yöntemine göre Processor üzerinden tetiklenmesi ve bilgilerin yazdırılması
        IPaymentMethod selectedMethod = availableMethods.get(result - 1);
        System.out.println("\n--- İşlem Detayları ---");
        processor.execute(selectedMethod, amount);

        scanner.close();
    }
}