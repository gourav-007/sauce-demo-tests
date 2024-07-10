# Sauce Demo Tests

This repository contains automated tests for the Sauce Demo application the tests are written using Java language.

## Project Structure
```
  sauce-demo-tests/
  │
  ├── src/
  │   ├── main/
  │   │   ├── java/
  │   │   └── resources/
  │   └── test/
  │       ├── java/
  │       │   └── com/
  │       │       └── yourcompany/
  │       │           ├── tests/
  │       │           ├── pages/
  │       │           └── utils/
  │       └── resources/
  │
  ├── .gitignore
  ├── pom.xml
  └── README.md
```

  
- **src/main**: Contains main application files (if any).
- **src/test**: Contains test-related files including test cases, page objects, and utilities.
- **tests**: Test cases are placed here.
- **pages**: Page Object Model classes are placed here.
- **utils**: Utility classes are placed here.

## Prerequisites

- Java Development Kit (JDK) 11 or higher
- Maven, JUnit
- WebDriver binaries (e.g., ChromeDriver, GeckoDriver)

## Setup and Installation

1. **Clone the repository**

   ```bash
   git clone https://github.com/gourav-007/sauce-demo-tests.git
   cd sauce-demo-tests
   
2. **Install Dependices**
   
     ```bash
     mvn clean install
     
4. **Configure WebDriver**

- Make sure you have the appropriate WebDriver binaries in your system PATH or configure them in the project.
  
4. **Running the Tests Locally**
   
- To run the tests locally, execute the following Maven command:
  
    ```bash
     mvn clean test
    
## Reporting
  - The project uses Allure Reports for generating detailed and visual test reports.

  **Generate Allure Report**
  
  ```bash
     mvn clean test
  ```
     

  **Open Allure Report**

  ```bash
       mvn allure:serve
