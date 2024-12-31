# Automation Test Assignment - Internship

This repository contains the automation test script developed as part of an assignment for an internship application. The script automates a login flow for an Android application using Appium.

---

## Features
The script automates the following steps:
1. Launching the application.
2. Interacting with a popup to select **"Sign in with email."**
3. Filling in email and password fields.
4. Submitting the login form.
5. Verifying successful login.

---

## Prerequisites
Ensure you have the following tools and dependencies installed before running the script:

### Tools
- **Java Development Kit (JDK)**: Version 8 or above.
- **Appium Server**:
    - Install Appium Desktop or run via Node.js:
      ```bash
      npm install -g appium
      ```
- **Android SDK**: For device management and adb commands.
- **Maven**: To manage dependencies.

### Device Requirements
- **Real Android Device or Emulator**:
    - For a real device, ensure USB debugging is enabled.
    - Connect the device and retrieve its UDID using the command:
      ```bash
      adb devices
      ```

### Dependencies
- **Appium Java Client**
- **Selenium Java Bindings**

These dependencies can be managed through Maven or manually added to your project.

---

## Configuration
Update the following values in the script to match your test environment:
- **`platformVersion`**: Android version of your test device.
- **`deviceName`**: Name of your Android device.
- **`udid`**: Device ID retrieved via `adb devices`.
- **`appPackage` and `appActivity`**: Replace with your target app's package and activity details.

---
## How to Run

1. **Start the Appium server**:
   ```bash
   appium
2. **Connect your Android device or start an emulator**
3. **Compile and run the LoginTest script**:
4. ```bash
    javac LoginTest.java
    java LoginTest