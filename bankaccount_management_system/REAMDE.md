## Java CLI Bank Account Management System

A small Java project demonstrating object‑oriented programming with a multi‑account banking system.
It manages multiple bank accounts, supports deposits and withdrawals, tracks transaction history, and persists all accounts using JSON.
The project illustrates clean class structure, OOP concepts, and practical backend logic

## Features

Create new bank accounts with owner name and account number

Select an active account from a list

Show all existing accounts

Deposit money into the selected account

Withdraw money with balance validation

Display current balance (BigDecimal with proper rounding)

View full transaction history

Save all accounts to a JSON file

Load all accounts from a JSON file

Demonstrates OOP principles: classes, objects, methods, encapsulation

Uses ArrayList to store and manage multiple Account objects

Uses Gson for JSON persistence

Uses BigDecimal for professional money handling

## Installation

Clone the repository:

```
git clone https://github.com/hssh8877/Java-practice.git
cd Java-practice/bankaccount_management_system
```
Gson Setup (required for JSON persistence)

This project uses Gson for saving and loading accounts.
1. Download Gson
```
gson-2.10.1.jar
```
Place it into a lib/ folder inside the project:
```
bankaccount_management_system/
 ├── src/
 ├── lib/
 │    └── gson-2.10.1.jar
 └── out/
```
2. Compile with Gson in the classpath
```
javac -cp lib/gson-2.10.1.jar -d out src/*.java

```
3.  Run with Gson in the classpath
``` java -cp out:lib/gson-2.10.1.jar Main
```
## Usage
Compile the Java files
```
javac -cp lib/gson-2.10.1.jar -d out src/*.java
cd out
```
Run the application
```
java -cp .:../lib/gson-2.10.1.jar Main
```

## Example usage

Create a new bank account

List all accounts

Select an account

Deposit money

Withdraw money

Show balance

View transaction history

Save all accounts to a JSON file

Load accounts back into the system
    
## Project Goals

Practice Java object‑oriented programming (OOP)

Learn class design, method creation, and multi‑object management

Implement JSON file I/O for data persistence

Work with BigDecimal for accurate financial calculations

Build a clean, structured CLI project suitable for a GitHub portfolio

Prepare the foundation for future features like transfers, PIN login, or transaction objects

