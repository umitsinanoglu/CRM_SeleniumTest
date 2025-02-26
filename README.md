# CRM Selenium Test

This project contains automated tests for the CRM application using Selenium WebDriver, JUnit, and Cucumber. The primary purpose of this project is to serve as a seed for a Java Selenium Cucumber BDD (Behavior-Driven Development) approach, providing a structured and scalable framework for writing and executing automated tests.

## Table of Contents

- [Purpose](#purpose)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Running Tests](#running-tests)
- [Project Structure](#project-structure)
- [Configuration](#configuration)
- [Contributing](#contributing)
- [License](#license)

## Purpose

The purpose of this project is to create a seed for a Java Selenium Cucumber BDD approach. It aims to provide a structured and scalable framework for writing and executing automated tests for web applications. This project demonstrates how to integrate Selenium WebDriver with Cucumber for BDD, using JUnit for test execution and reporting.

## Prerequisites

- Java 17
- Maven
- ChromeDriver or GeckoDriver (for Firefox)

## Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/umitsinanoglu/CRM_SeleniumTest.git
    cd CRM_SeleniumTest
    ```

2. Install dependencies:
    ```sh
    mvn clean install
    ```

## Running Tests

To run the tests, use the following Maven command:
```sh
mvn test
