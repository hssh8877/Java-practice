# Java CLI Todo App

A small Java project demonstrating object-oriented programming with a simple Todo system.  
It manages tasks with priorities and due dates, allows adding, searching, listing, marking as done, and illustrates clean class structure and OOP concepts.

## Features

- Add todos with task description, priority (1-5), and due date (`add`)
- Show all todos (`list`)
- Show only open todos (`list open`)
- Show only completed todos (`list done`)
- Search todos by keyword (`search`)
- Mark a todo as done (`done`)
- Remove a todo by index (`remove`)
- Overdue todos are automatically marked with `[!]` if due date has passed
- Demonstrates OOP principles: classes, objects, methods, encapsulation
- Uses `ArrayList` to store and manage `Todo` objects
- Saves todos to a text file for persistence

## Installation

Clone the repository:

```bash
git clone https://github.com/hssh8877/Java-practice.git
cd Java-practice/java_CLI_todo_app
```

## Usage

Compile the Java files:
```
```javac -d out Main.java Todo.java TodoList.java
cd out
```
Run the application:

```
java Main
```
Example usage:

Add a new todo

List all todos

List open or done todos

Search for a todo by keyword

Mark a todo as done

Remove a todo

Observe overdue todos marked with [!]

Project Goals

Practice Java object-oriented programming (OOP) concepts

Learn class design, method creation, and working with ArrayLists

Implement file I/O for data persistence

Work with LocalDate for due dates and overdue detection

Create a clean, structured project ready for GitHub portfolio
