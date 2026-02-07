# 🛒 Saudi Supermarket Automation Testing

🔗 **Website:** [Saudi Supermarket](https://seoudiSupermarket.com)  

---

## 📌 Project Overview
This project is a **Web Automation Testing framework** for the **Saudi Supermarket website** using:

- **Java**
- **Selenium WebDriver**
- **TestNG**
- **Maven**
- **Page Object Model (POM)**  

The framework automates **cart management, checkout flow, product selection, and location-based interactions**, ensuring the website functionalities work as expected.

---

## 🛠️ Tools & Technologies
- **Programming Language:** Java  
- **Automation Tool:** Selenium WebDriver  
- **Test Framework:** TestNG  
- **Build Tool:** Maven  
- **Design Pattern:** Page Object Model (POM)  
- **Optional:** Cucumber (Step Definitions included)  
- **IDE:** IntelliJ IDEA  

---

## 📂 Project Structure & Packages

### **BaseTest**
- [`BaseTestClass.java`](#) – Handles setup, browser initialization, and teardown.  

### **HooksPackage**
- [`HooksPackeg/`](#) – Placeholder for pre/post test hooks (currently empty).  

### **Pages**
- [`CartPage.java`](#) – Methods for managing cart items and quantities.  
- [`CheckoutPage.java`](#) – Actions for completing the checkout process.  
- [`LocationSelectionPage.java`](#) – Handles selecting delivery locations.  
- [`ProductsPage.java`](#) – Product browsing, selection, and filtering actions.  

### **Runner**
- [`Runner.java`](#) – Executes TestNG tests or Cucumber scenarios.  

### **StepDefinitions**
- [`StepDefinitions/`](#) – Contains Step Definition classes if using BDD.  

### **Tests**
- [`CartQuantityUpdateTest.java`](#) – Validates cart quantity updates and verifies totals.  

### **Configuration & Build**
- [`pom.xml`](#) – Maven dependencies and build configurations  
- [`testng.xml`](#) – TestNG Suite file  
- [`.gitignore`](#) – Files/folders ignored in GitHub  

> **Ignored folders:** `target/`, `test-output/`, `.idea/`, `*.iml`  

---

## ✅ Test Scenarios

### Cart Management
- Update item quantities in the cart
- Verify total prices update correctly
- [`CartQuantityUpdateTest.java`](#)

### Product Selection
- Browse products
- Select products by category or filters
- [`ProductsPage.java`](#)

### Location Handling
- Select delivery location
- Verify location-specific content
- [`LocationSelectionPage.java`](#)

### Checkout Flow
- Proceed to checkout
- Verify totals and payment options
- [`CheckoutPage.java`](#)

---

## 🚀 How to Run Tests

### Option 1: IntelliJ IDEA
1. Open the project in **IntelliJ IDEA**  
2. Ensure Maven dependencies are downloaded (`pom.xml` → right click → Maven → Reimport)  
3. Run tests:
   - Right-click on any **TestNG test class** → Run  
   - Or right-click on **testng.xml** → Run all tests  

### Option 2: Command Line
```bash
mvn test
