# 🌱 Java Basics Programs

This folder contains small, self-contained Java programs demonstrating the fundamentals of programming — from user input to time complexity.  
Each file focuses on one concept and can be compiled and run independently.

---

## 📘 Table of Contents

1. [InputOutput.java](#1-user-input--output)
2. [DataTypes.java](#2-data-types)
3. [IfElse.java](#3-if-else-statements)
4. [SwitchExample.java](#4-switch-statement)
5. [ArraysExample.java](#5-arrays)
6. [StringExample.java](#6-strings)
7. [ForLoopExample.java](#7-for-loops)
8. [WhileLoopExample.java](#8-while-loops)
9. [PassByValue.java](#9-functions-pass-by-value)
10. [PassByReference.java](#10-functions-pass-by-reference)
11. [TimeComplexityExample.java](#11-time-complexity)

---

## 1. User Input / Output

**File:** `InputOutput.java`  
**Concept:** Taking input from the user and printing output.  
**Key classes:** `Scanner`, `System.out`

Example:

```java
Scanner sc = new Scanner(System.in);
String name = sc.nextLine();
System.out.println("Hello, " + name);
```

---

## 2. Data Types

**File:** `DataTypes.java`
**Concept:** Primitive data types in Java (`int`, `double`, `char`, `boolean`).
Shows declaration, initialization, and printing.

---

## 3. If Else Statements

**File:** `IfElseExample.java`
**Concept:** Conditional branching using `if`, `else if`, and `else`.

---

## 4. Switch Statement

**File:** `SwitchExample.java`
**Concept:** Alternate to multiple `if` statements for comparing discrete values.
**Note:** Uses the classic `case` and `break` syntax (compatible with Java 8+).

---

## 5. Arrays

**File:** `ArraysExample.java`
**Concept:** Storing multiple elements of the same type and looping through them.
Access elements with `array[index]`.

---

## 6. Strings

**File:** `StringExample.java`
**Concept:** Common string operations: `length()`, `toUpperCase()`, `charAt()`.

---

## 7. For Loops

**File:** `ForLoopExample.java`
**Concept:** Running a block of code a fixed number of times using `for` loop syntax.

---

## 8. While Loops

**File:** `WhileLoopExample.java`
**Concept:** Repetition based on a condition, using `while`.

---

## 9. Functions (Pass by Value)

**File:** `PassByValue.java`
**Concept:** Demonstrates that Java passes _copies_ of primitive values to functions, not the originals.

---

## 10. Functions (Pass by Reference)

**File:** `PassByReference.java`
**Concept:** Objects are passed _by value of reference_, meaning the reference itself is copied, allowing modification of the object it points to.

---

## 11. Time Complexity

**File:** `TimeComplexityExample.java`
**Concept:** Introduces the idea of algorithmic complexity — how runtime scales with input size.
Includes examples of `O(n)` and `O(n²)` loops.

---

## How to Run

1. Open terminal in the folder.
2. Compile a file:

   ```
   javac FileName.java
   ```

3. Run it:

   ```
   java FileName
   ```

   (Replace `FileName` with the class name.)

---

## Pro Tips

- Use separate `.java` files for each class.
- File name **must** match the public class name.
- Always save before compiling. Trust me, that’s a ritual you’ll learn the hard way otherwise.

---

## Next Steps

Once comfortable with these:

- Learn about **OOP concepts** (Classes, Objects, Inheritance, Polymorphism).
- Try simple problems on loops and arrays.
- Start reading about **Collections Framework** and **Exception Handling**.

---

> “Programs must be written for people to read, and only incidentally for machines to execute.”
> — _Harold Abelson_
