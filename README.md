General Store Mobile Automation Framework 🛒📱
A mobile test automation framework built with Appium, Java, and TestNG for testing the General Store Android application. The framework follows the Page Object Model (POM) design pattern and supports Data-Driven Testing, Extent Reporting, and automatic screenshots on failure.


📁 Project Structure
GeneralStore/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── org/
│   │   │   │   ├── formPage.java           # Login/Form page object
│   │   │   │   ├── productsCatalogue.java  # Products page object
│   │   │   │   └── cartPage.java           # Cart page object
│   │   │   └── utils/
│   │   │       ├── Actions/
│   │   │       │   ├── Android_Actions.java    # Android gestures (scroll, swipe, drag)
│   │   │       │   └── Appium_Utils.java       # Appium server utilities
│   │   │       ├── MediaManager/
│   │   │       │   └── ScreenShotManager.java  # Screenshot capture
│   │   │       ├── dataReaders/
│   │   │       │   ├── JsonReader.java          # JSON test data reader
│   │   │       │   └── PropertyReader.java      # Properties file reader
│   │   │       ├── ExtentReporterNG.java        # Extent report setup
│   │   │       └── WaitManager.java             # Fluent wait manager
│   │   └── resources/
│   │       ├── General-Store.apk               # App under test
│   │       ├── data.properties                 # Configuration (IP, port)
│   │       └── test-data/
│   │           └── data.json                   # Test data
│   └── test/
│       └── java/
│           ├── baseTest.java           # Android base test setup
│           ├── baseTestIOS.java        # iOS base test setup
│           ├── MobileBaseTest.java     # Mobile browser base test
│           ├── LoginTest.java          # Login test cases
│           ├── AddToCart.java          # Add to cart test cases
│           ├── hybridTC.java           # Hybrid (native + web) test cases
│           ├── mobileBrowserTest.java  # Mobile browser test cases
│           └── Listeners/
│               └── Listeners.java      # TestNG listeners for reporting
├── reports/
│   └── index.html                      # Generated Extent report
├── screenshots/                        # Auto-captured failure screenshots
├── testng.xml                          # TestNG suite configuration
└── pom.xml                             # Maven dependencies

✨ Features

Page Object Model (POM) — clean separation of test logic and UI interactions
Data-Driven Testing — test data loaded from JSON files via JsonReader
Automatic Screenshot on Failure — captured via TestNG Listener and saved to /screenshots
Extent Reports — detailed HTML reports generated after each test run
Appium Server Auto-Start/Stop — managed programmatically via Appium_Utils
Fluent Wait Manager — smart waits with configurable timeout and polling
Gesture Support — scroll, swipe, drag & drop, long press via Android_Actions
Hybrid Testing — supports switching between native app and WebView contexts
iOS Support — base setup available via baseTestIOS
Mobile Browser Testing — Chrome browser testing on Android via mobileBrowserTest


⚙️ Prerequisites

Java JDK 23+
Node.js (latest LTS)
Appium 2.x
Android SDK & ADB
Maven 3.x
Android device with USB Debugging enabled
ChromeDriver (for hybrid/browser tests)


🚀 Setup & Installation
1. Install Appium & UiAutomator2 driver
bashnpm install -g appium
appium driver install uiautomator2
2. Connect your Android device
bash adb devices
Make sure your device appears as device (not unauthorized).
3. Configure data.properties
propertiesipAddress=127.0.0.1
port=4723
browser=chrome
4. Install Maven dependencies
bashmvn clean install

▶️ Running Tests
Run all tests via TestNG XML
bashmvn test -DsuiteXmlFile=testng.xml
Run specific test class
bashmvn test -Dtest=LoginTest
mvn test -Dtest=AddToCart
Or run directly from IntelliJ
Right-click testng.xml → Run

📊 Test Cases
ClassTestDescriptionLoginTesttc1Login with name "Amr Khaled" and male genderLoginTesttc2Login with name "A000" and male genderAddToCartAddtoCartTestAdd products to cart and verify total price matches sum of selected itemshybridTCHybridTcSwitch between native app and WebView contextmobileBrowserTestbrowserTestOpen Chrome on device and perform a Google search

🗂️ Test Data
Test data is stored in src/main/resources/test-data/data.json:
json[
  {
    "name": "Amr Khaled",
    "gender": "Male",
    "country": "Argentina"
  },
  {
    "name": "Amr Youssef",
    "gender": "Male",
    "country": "Argentina"
  }
]
Each record is automatically passed to the test via @DataProvider, so the test runs once per record.

📸 Screenshots
Failure screenshots are automatically captured by the Listeners class and saved to:
./screenshots/<testName>.jpg

📈 Test Reports
Extent HTML reports are generated after each run at:
./reports/index.html
Open in any browser to view detailed pass/fail results with timestamps and logs.

🔧 Configuration
Key capabilities set in baseTest.java:
CapabilityValuenoResettrue — don't clear app data between runsskipDeviceInitializationtrue — skip hidden API policy reset (required for Oppo devices)ignoreHiddenApiPolicyErrortrue — ignore policy errors on Android 11+dontStopAppOnResettrue — keep app running on reset

👤 Author
Amr Khaled — Mobile Automation Engineer
