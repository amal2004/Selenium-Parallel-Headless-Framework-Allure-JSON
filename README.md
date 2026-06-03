# 🚀 Java Selenium Automation Framework

<div align="center">

### Enterprise-Grade Test Automation Framework Built with Java, Selenium, TestNG & Allure

![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge\&logo=openjdk)
![Selenium](https://img.shields.io/badge/Selenium-WebDriver-43B02A?style=for-the-badge\&logo=selenium)
![TestNG](https://img.shields.io/badge/TestNG-Framework-red?style=for-the-badge)
![Allure](https://img.shields.io/badge/Allure-Reporting-blue?style=for-the-badge)
![Maven](https://img.shields.io/badge/Maven-Build-C71A36?style=for-the-badge\&logo=apachemaven)
![SLF4J](https://img.shields.io/badge/SLF4J-Logging-yellow?style=for-the-badge)

<br>

**Scalable • Maintainable • Parallel Execution • Enterprise Ready**

Built using modern automation design principles including **Page Object Model (POM)**, **ThreadLocal WebDriver**, **Data-Driven Testing**, **Allure Reporting**, and **Centralized Configuration Management**.

</div>

---

## 📖 Overview

This framework demonstrates how enterprise automation teams design and implement scalable UI automation solutions.

The framework focuses on:

* ✅ Maintainability
* ✅ Reusability
* ✅ Parallel Execution
* ✅ Clean Architecture
* ✅ Robust Logging
* ✅ Detailed Reporting
* ✅ Data-Driven Testing

---

# ✨ Key Features

<table>
<tr>
<td width="50%">

### 🏗 Framework Design

* Page Object Model (POM)
* Base Page Layer
* Base Test Layer
* Factory Pattern
* Custom Exceptions
* Utility Components

</td>

<td width="50%">

### 🌐 Cross Browser Support

* Chrome
* Firefox
* Edge
* Headless Execution
* Dynamic Browser Selection

</td>
</tr>

<tr>
<td>

### 📊 Reporting

* Allure Reports
* Step-Level Reporting
* Failure Screenshots
* Execution History
* Attachments Support

</td>

<td>

### 📝 Logging

* SLF4J
* Logback
* MDC Support
* Dynamic Log Levels
* Thread-Aware Logs

</td>
</tr>

<tr>
<td>

### ⚡ Parallel Execution

* ThreadLocal Driver
* Parallel Data Providers
* Independent Sessions
* Multi-Browser Execution

</td>

<td>

### 📂 Test Data Management

* JSON Data Sources
* Jackson Integration
* Dynamic Test Data
* Factory-Based Objects

</td>
</tr>
</table>

---

# 🏛 Framework Architecture

```text
┌──────────────────────────┐
│        Test Layer        │
│    RegistrationTest      │
└────────────┬─────────────┘
             │
             ▼
┌──────────────────────────┐
│       Page Layer         │
│      RegisterPage        │
└────────────┬─────────────┘
             │
             ▼
┌──────────────────────────┐
│       Base Layer         │
│        BasePage          │
└────────────┬─────────────┘
             │
             ▼
┌──────────────────────────┐
│      Driver Layer        │
│ DriverFactory/Manager    │
└────────────┬─────────────┘
             │
             ▼
┌──────────────────────────┐
│ Selenium WebDriver       │
└──────────────────────────┘
```

---

# 📂 Project Structure

```text
src
│
├── main
│   └── java
│       └── com.amalw
│
│           ├── base
│           ├── config
│           ├── dataproviders
│           ├── driver
│           ├── enums
│           ├── exceptions
│           ├── factory
│           ├── listeners
│           ├── logging
│           ├── model
│           ├── pages
│           ├── testdata
│           ├── utils
│           └── waits
│
└── test
    └── java
        └── tests
```

---

# 🛠 Technology Stack

| Category          | Technology         |
| ----------------- | ------------------ |
| Language          | Java 17            |
| UI Automation     | Selenium WebDriver |
| Testing Framework | TestNG             |
| Build Tool        | Maven              |
| Reporting         | Allure Reports     |
| Logging           | SLF4J + Logback    |
| JSON Parsing      | Jackson            |
| Driver Management | WebDriverManager   |
| Design Pattern    | POM + Factory      |

---

# 🔥 Framework Highlights

## Thread-Safe Driver Management

The framework uses:

```java
ThreadLocal<WebDriver>
```

Benefits:

* Parallel-safe execution
* Independent browser sessions
* Better scalability
* No driver collision issues

---

## Centralized Configuration

```properties
base.url=https://demo.nopcommerce.com
browser=chrome
headless=false
pageLoadTimeout=60
retries=0
logLevel=INFO
```

Supports:

* Property files
* System property overrides
* Environment-specific execution

---

## Data-Driven Testing

JSON-powered test execution.

```json
[
  {
    "firstName": "John",
    "lastName": "Doe",
    "gender": "MALE",
    "company": "OpenAI",
    "password": "Password123",
    "confirmPassword": "Password123"
  }
]
```

Benefits:

* Easy maintenance
* Reusable datasets
* Business-friendly format

---

# 🧪 Sample Test Flow

```java
@Test(dataProvider = "registrationData")
public void testRegistration(User user, Gender gender) {

    RegisterPage registerPage = new RegisterPage();

    registerPage.open()
                .selectGender(gender)
                .fillForm(user)
                .submit();

    Assert.assertTrue(
        registerPage.isRegistrationSuccessful()
    );
}
```

---

# 📸 Reporting & Screenshots

## Allure Report

Features:

* Test execution timeline
* Step tracking
* Failure details
* Screenshot attachments
* Historical trends

### Sample Report

```text
Test Started
  ↓
Registration Page Opened
  ↓
Form Submitted
  ↓
Validation Passed
  ↓
Test Completed
```

---

# 📷 Screenshot Capture

Automatic screenshot generation on failures.

```text
screenshots/
│
└── RegistrationTest
    └── testRegistration_20260522_103000.png
```

---

# ⚙️ Execution Commands

## Run Complete Suite

```bash
mvn clean test
```

## Run Chrome

```bash
mvn clean test -Dbrowser=chrome
```

## Run Firefox

```bash
mvn clean test -Dbrowser=firefox
```

## Run Edge

```bash
mvn clean test -Dbrowser=edge
```

## Headless Execution

```bash
mvn clean test -Dheadless=true
```

---

# 📈 Generate Allure Reports

Execute tests:

```bash
mvn clean test
```

Generate report:

```bash
allure serve allure-results
```

or

```bash
allure generate allure-results --clean
```

---

# 🎯 Why This Framework?

✔ Enterprise Architecture

✔ Thread-Safe Execution

✔ Page Object Model

✔ Data-Driven Testing

✔ Dynamic Test Data

✔ Cross Browser Support

✔ Allure Reporting

✔ Automatic Screenshots

✔ Centralized Logging

✔ Easy Maintenance

✔ Highly Scalable

✔ CI/CD Ready

---

# 🚀 Future Enhancements

* Selenium Grid Integration
* Docker Support
* Jenkins Pipeline
* GitHub Actions
* Retry Analyzer
* REST Assured Integration
* Database Validation Layer
* Multi-Environment Execution
* Cloud Execution (BrowserStack/Sauce Labs)

---

# 👨‍💻 Author

## Amal W

---

<div align="center">

## ⭐ Support the Project

If you found this framework useful, consider giving it a **Star ⭐**

It helps increase visibility and supports future enhancements.

**Happy Testing 🚀**

</div>
