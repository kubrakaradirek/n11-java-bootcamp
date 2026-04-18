# 💳 Payment System (SOLID)

## 📌 Overview

This project is a **scalable payment processing system** developed for the **n11 TalentHub Backend Bootcamp**.  
The main goal of the project is to apply **SOLID principles** and create a system that is **easy to maintain, extend, and improve** without changing existing core code.

---

## 🚀 Key Features

### ✅ Strategy Pattern
Each payment method is implemented as a separate class through the `IPaymentMethod` interface.

### ✅ Centralized Logging
A dedicated `ILogger` interface is used to track and record all important system operations.

### ✅ Robust Error Handling
The application uses `try-catch` blocks and validation loops to handle:

- `InputMismatchException` (invalid character input)
- Logical errors (negative or zero amount)
- Invalid menu selections

---

## 🧠 Design Approach

# ⚙️ Open/Closed Principle (OCP)

The system is **open for extension** but **closed for modification**.  
To add a new payment method, simply create a new class and register it in the list.

```java
availableMethods.add(new ApplePayPayment());
## ⚙️ Single Responsibility Principle (SRP)

Each class has one clear responsibility:

| Class | Responsibility |
|------|----------------|
| `PaymentProcessor` | Manages payment flow, validation, logging, execution |
| `Payment Methods` | Contains transaction logic for each payment type |
| `ConsoleLogger` | Prints logs to the console |

---

## ⚙️ Dependency Inversion Principle (DIP)

`PaymentProcessor` depends on abstractions instead of concrete classes:

- `IPaymentMethod`
- `ILogger`

This allows flexible replacement of logging systems or payment providers.

---

## 🏗️ Project Structure

```bash
n11-java-bootcamp
├── src/
│   └── n11.bootcamp.homework01
│       ├── log/
│       │   ├── ConsoleLogger.java
│       │   └── ILogger.java
│       ├── payment/
│       │   ├── ApplePayPayment.java
│       │   ├── CreditCardPayment.java
│       │   ├── CryptoPayment.java
│       │   └── IPaymentMethod.java
│       ├── service/
│       │   └── PaymentProcessor.java
│       └── Test.java
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
🛠️ Technologies Used
Java
OOP
SOLID Principles
Strategy Pattern
Exception Handling
Console Application
👩🏽‍💻 Author

Kubra Karadirek
