# Selenium Test Demo with Java and JUnit

This project demonstrates how to write automated tests using **Selenium WebDriver**, **Java**, and **JUnit 5**. The tests are written against the [Sauce Demo](https://www.saucedemo.com/) website, a demo e-commerce platform designed for testing purposes.

---

## **Why These Tests?**

The purpose of this project is to provide a practical example of how to:
1. Set up a Selenium WebDriver project using **Gradle**.
2. Write automated tests in **Java** using the **JUnit 5** testing framework.
3. Interact with web elements (e.g., login forms, buttons, dropdowns) using Selenium.
4. Perform assertions to validate test outcomes.
5. Structure tests in a maintainable and scalable way.

This project is ideal for:
- Beginners learning Selenium and Java.
- Developers looking for a reference implementation of Selenium tests.
- Teams adopting Selenium for their test automation efforts.

## **Proposed Folder Structure:**

```dtd
seleniumTestDemo
        ├── sauceDemo                 # SauceDemo test folder
        │    ├── pages                # Page Object classes
        │    │    ├── LoginPage.java
        │    │    └── InventoryPage.java
        │    ├── tests                # Test classes
        │    │    └── SauceDemoTest.java
        ├── uiTestingPlaygroundDemo   # UI Testing Playground test folder
        │    ├── pages                # Page Object classes
        │    │    ├── UITestingPage.java
        │    ├── tests                # Test classes
        │    │    └── UITestingTest.java
        ├── utils                     # Utility classes shared by both
        │    ├── BaseTest.java
        │    └── DriverManager.java
        └── README.md                 # Documentation for the project

```
---
