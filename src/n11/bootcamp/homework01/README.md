💳 Payment System (SOLID)

📌 Overview

This project is a scalable payment processing system developed for the n11 TalentHub Backend Bootcamp. The core focus is to implement SOLID principles, ensuring the system remains extendable without modifying existing code.

🚀 Key Features

✅ Strategy Pattern: Each payment method is implemented as a separate class through the IPaymentMethod interface.

✅ Centralized Logging: Integrated ILogger interface to track and record all system processes.

✅ Robustness: Implementation of resilient validation loops using try-catch blocks to handle InputMismatchException (invalid characters) and logical errors (negative amounts).

🧠 Design Approach

⚙️ Open/Closed Principle (OCP)

The system is open for extension but closed for modification. Adding a new payment method only requires adding it to the list in Test.java without touching the core logic.

// Adding a new method is as simple as:
availableMethods.add(new ApplePayPayment());


⚙️ Single Responsibility Principle (SRP)

Every class has a unique responsibility:

PaymentProcessor: Manages the payment flow (logging, validation, and execution).

PaymentMethod Implementations: Handles specific transaction logic for each method.

ConsoleLogger: Responsible only for printing logs to the console.

⚙️ Dependency Inversion Principle (DIP)

PaymentProcessor depends on abstractions (IPaymentMethod, ILogger) rather than concrete implementations, allowing for easy swapping of logging or payment components.

🏗️ Project Structure

n11-java-bootcamp
├── .idea/
├── src/
│   └── n11.bootcamp.homework01
│               ├── log/
│               │   ├── ConsoleLogger.java
│               │   └── ILogger.java
│               ├── payment/
│               │   ├── ApplePayPayment.java
│               │   ├── CreditCardPayment.java
│               │   ├── CryptoPayment.java
│               │   └── IPaymentMethod.java
│               ├── service/
│               │   └── PaymentProcessor.java
│               └── Test.java
├── n11-talenthub-backend-bootcamp-homework-01.iml
└── README.md


▶️ Example Output

✅ Successful Transaction

=== Payment Infrastructure ===
1. Credit Card
2. Crypto (USDT)
3. Apple Pay

Please select a payment method (1-3): 1
Enter payment amount (TL): 100

--- Transaction Details ---
[SYSTEM LOG] : Starting payment process with Credit Card...
💳 Transaction of 100.0 TL completed successfully via Credit Card.
[SYSTEM LOG] : Transaction completed successfully.


❌ Error Handling Scenarios

Please select a payment method (1-3): 4
❌ Error: Please select only from the numbers (1-3) provided in the list!

Enter payment amount (TL): -100
❌ Invalid amount! Please enter a balance greater than 0.

Enter payment amount (TL): abc
❌ Error: You can only enter numeric values for the amount!


👩🏽‍💻 Author

Kubra Karadirek