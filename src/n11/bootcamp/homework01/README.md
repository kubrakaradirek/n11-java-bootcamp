# 💳 Payment System (SOLID)

## 📌 Overview

This project is a **scalable payment processing system** developed for the **n11 TalentHub Backend Bootcamp**.  The main goal of the project is to apply **SOLID principles** and create a system that is **easy to maintain, extend, and improve** without changing existing core code.

---

## 🚀 Features

* Support for Credit Card, Crypto (USDT), and Apple Pay modules
* Dynamic menu-driven terminal interaction
* Built-in protection against invalid characters and negative values
* Automated logging for every transaction step

---

## 🧠 Design Approach (SOLID)

### ⚙️ Open/Closed Principle (OCP)
The system is **open for extension** but **closed for modification**. To add a new payment method, simply create a new class and register it in the list without touching the `PaymentProcessor`.

### ⚙️ Single Responsibility Principle (SRP)
Each class has one clear responsibility:

| Class | Responsibility |
| :--- | :--- |
| **`PaymentProcessor`** | Manages payment flow, validation, and execution. |
| **`Payment Methods`** | Contains transaction logic for each payment type. |
| **`ConsoleLogger`** | Prints logs to the console. |

### ⚙️ Dependency Inversion Principle (DIP)
`PaymentProcessor` depends on abstractions (`IPaymentMethod`, `ILogger`) instead of concrete classes. This allows flexible replacement of logging systems or payment providers.

This allows flexible replacement of logging systems or payment providers.

## 🏗️ Project Structure

Below is the organized directory structure of the project:

* 📁 **n11-java-bootcamp**
  * 📁 **src**
    * 📁 **n11.bootcamp.homework01**
      * 📁 **log**
        * 📄 `ConsoleLogger.java`
        * 📄 `ILogger.java`
      * 📁 **payment**
        * 📄 `ApplePayPayment.java`
        * 📄 `CreditCardPayment.java`
        * 📄 `CryptoPayment.java`
        * 📄 `IPaymentMethod.java`
      * 📁 **service**
        * 📄 `PaymentProcessor.java`
      * 📄 `Test.java`
  * 📄 `README.md`

---

### ✅ Successful Transaction
The following sequence shows a typical successful payment flow:

> **=== Payment Infrastructure ===**
> 1. Credit Card
> 2. Crypto (USDT)
> 3. Apple Pay
>
> **Please select a payment method (1-3):** `1`  
> **Enter payment amount (TL):** `100`
>
> **---  Transaction Details ---**
>
> `[SYSTEM LOG] : Starting payment process with Credit Card...`  
> `💳 Transaction of 100.0 TL completed successfully via Credit Card.`  
> `[SYSTEM LOG] : Transaction completed successfully.`

---

### ❌ Error Handling Scenarios
* **Selection Error:** `❌ Error: Please select only from the numbers (1-3) provided in the list!`
* **Logical Error:** `❌ Invalid amount! Please enter a balance greater than 0.`
* **Type Error:** `❌ Error: You can only enter numeric values for the amount!`

---

## 🛠️ Technologies Used
* **Java**
* **SOLID Design Principles**
* **OOP Principles**
---
## 👩🏽‍💻 Author
Kubra Karadirek

*Developed for n11 TalentHub Backend Bootcamp - 2026*
