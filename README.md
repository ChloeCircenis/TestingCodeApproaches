# Testing Code: A Three-Pronged Comparison of Common Approaches
  Jay Michuda and Chloe Circenis 
  Object Oriented Analysis and Design
  University of Colorado, Boulder
  Professor Bill Wright
  12/6/2025
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

---

## Build & Run Instructions  

Here’s a basic guideline for building and running this project, though you may have to make light modifications according to the present set up of your preffered IDE. We recommend utilizing IntelliJ Idea as this project was developed in this IDE and it has great Git integration. 

### Clone the repo
git clone https://github.com/ChloeCircenis/TestingCodeApproaches.git

cd TestingCodeApproaches

### Build
gradle build (depending on your IDE)

### Run
Run the tests (depending on your IDE)
./gradlew test --tests "GoodTicTacToeTest"
./gradlew test --tests "BadTicTacToeTest"
./gradlew cucumber

## Running Static Tests

# About
This research project is authored by the contributors of this repository. It aims to help developers understand the strengths and tradeoffs of unit testing, BDD, and static testing in Java projects.




