# Testing Code: A Three-Pronged Comparison of Common Approaches
 
> ### Jay Michuda & Chloe Circenis  
> **Object Oriented Analysis and Design**  
> University of Colorado Boulder  
> **Professor:** Bill Wright  
> **Date:** December 6, 2025
---
This research aims to examine the benefits of three popular testing methodologies: 
- Unit Testing / Test-Driven Development (TDD)  
- Behavior-Driven Development (BDD)  
- Static Testing  

The goal is to demonstrate how each approach works (with code examples) and highlight their respective benefits.

---
# Project File Structure
```bash
TestingCodeApproaches/
│
├── TickTackToe/                          # Java example project used to demonstrate testing approaches
│   ├── src/
│   │   ├── main/java/game/               # Application source code
│   │   │   ├── BadPlayer.java            # Poor player implementation
│   │   │   ├── BadTicTacToe.java         # Poor game implementation
│   │   │   ├── Player.java               # Good player implementation
│   │   │   └── TicTacToe.java            # Good game implementation
│   │
│   │   └── test/java/game/               # Unit tests (TDD) + BDD step definitions
│   │       ├── stepdefs/                 # Step definitions for Cucumber BDD
│   │       │   ├── BadStepDefs.java      # Poor step definitions
│   │       │   └── GoodStepDefs.java     # Proper step definitions
│   │       │
│   │       ├── BadTicTacToeTest.java     # Poor TDD unit tests
│   │       └── GoodTicTacToeTest.java    # Proper TDD unit tests
│   │
│   └── resources/
│       └── features/                     # BDD feature files (Gherkin)
│           ├── BadTicTacToe.feature      # Poor BDD feature
│           └── GoodTicTacToe.feature     # Proper BDD feature
│
├── README.md
└── build.gradle.kts
```
---

## Dependencies  

This project is written in **Java** (≈ 91.8%) with some **Gherkin** feature files for BDD. 

You'll need the following tools/libraries to build and test the project:

- A JDK (e.g. Java 8 or newer)  
- A build tool / test framework (e.g. JUnit, or whichever you configure for unit and BDD tests)  
- For BDD: a framework that supports Gherkin + Java (e.g. Cucumber-JVM)  
- Gradle  
- [SonarQube Community Edition Version 11.6.0.83783](https://www.sonarsource.com/products/sonarqube/downloads/?utm_source=google&utm_medium=cpc&utm_campaign=SQ-NA-US-West-Brand&utm_content=Brand-Server&utm_term=sonar%20qube&s_campaign=SQ-NA-US-West-Brand&s_content=153022664286&s_category=Paid&s_source=Paid%20Search&s_origin=Google&cq_src=google_ads&cq_cmp=20640594616&cq_con=153022664286&cq_term=sonar%20qube&cq_med=&cq_plac=&cq_net=g&cq_pos=&cq_plt=gp&gad_source=1&gad_campaignid=20640594616&gclid=EAIaIQobChMI7vnlmOSqkQMVyQfvAh0NAws8EAAYASABEgJsOvD_BwE)
- SonarQube for IDE version 11.6.0.83783 IntelliJ Plugin (download from marketplace)

---

## Build & Run Instructions  

Here’s a basic guideline for building and running this project, though you may have to make light modifications according to the present set up of your preffered IDE. We recommend utilizing IntelliJ Idea as this project was developed in this IDE and it has great Git integration. 

### Clone the repo
- git clone https://github.com/ChloeCircenis/TestingCodeApproaches.git

- cd TestingCodeApproaches

### Build
- gradle build (depending on your IDE)

### Run
- Run the tests (depending on your IDE)
- ./gradlew test --tests "GoodTicTacToeTest"
- ./gradlew test --tests "BadTicTacToeTest"
- ./gradlew cucumber
- - ./gradlew test


## Running Static Tests
- Install SonarQube for IDE from IntelliJ plugin marketplace
- Follow SonarQube [instructions](https://docs.sonarsource.com/sonarqube-community-build/try-out-sonarqube) for installing and launching the SonarQube server
- Configure SonarQube for IDE in [connected mode](https://docs.sonarsource.com/sonarqube-for-intellij/connect-your-ide/setup) to integrate your project and SonarQube server
    - Ensure that id("org.sonarqube") version "7.0.1.6134" is in the build.gradle.kts plugins section (or the corresponding id for gradle.build files)
- If desired to extend Java ruleset, navigate in SonarQube instance to Quality Profiles -> Java. 
    - Click the ellipses and select Extend. 
    - Provide a new name and select the desired Project.
    - Navigate back to Quality Profiles and select the ellipses for your new Quality Profile.
    - Click Activate More Rules and select your desired ruleset - this research activated all. 




