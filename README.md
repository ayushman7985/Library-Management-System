# Library Management System - Object-Oriented Programming

A comprehensive Library Management System implemented in Java demonstrating all four pillars of Object-Oriented Programming (OOP).

## 🏗️ System Architecture

### Core Classes and OOP Concepts

#### 1. **Encapsulation**
- **Book.java**: Encapsulates book properties with private fields and public methods
- **Person.java**: Abstract base class with protected fields for inheritance
- **Member.java** & **Librarian.java**: Encapsulate specific role-based data and behaviors

#### 2. **Inheritance**
- **Person.java**: Abstract base class
- **Member.java**: Extends Person (IS-A relationship)
- **Librarian.java**: Extends Person (IS-A relationship)

#### 3. **Polymorphism**
- Method overriding: `displayInfo()`, `getRole()` methods in Member and Librarian
- Method overloading: Multiple constructors and search methods
- Runtime polymorphism: Person references can hold Member or Librarian objects

#### 4. **Abstraction**
- **Person.java**: Abstract class with abstract methods
- Interface-like behavior through abstract methods
- Data hiding through private fields and controlled access

## 📁 File Structure

```
LibraryManagementSystem/
├── Book.java                    # Book entity class
├── Person.java                  # Abstract base class for all persons
├── Member.java                  # Library member class (extends Person)
├── Librarian.java              # Librarian class (extends Person)
├── LibraryDatabase.java        # Data management class
├── LibraryManagementSystem.java # Main system class
└── LibrarySystem_README.md     # This documentation
```

## 🔧 Features

### Book Management
- ✅ Add new books to the library
- ✅ Remove books from the library
- ✅ View all books (available and borrowed)
- ✅ Search books by title, author, or category
- ✅ Track book availability status

### Member Management
- ✅ Register new members (Student, Faculty, General)
- ✅ Remove members (only if no borrowed books)
- ✅ View member details and borrowing history
- ✅ Manage member fines and payments
- ✅ Different borrowing limits based on membership type

### Book Transactions
- ✅ Issue books to members
- ✅ Return books and calculate overdue fines
- ✅ Automatic due date calculation (14-day loan period)
- ✅ Fine calculation ($1 per day for overdue books)

### System Features
- ✅ Librarian authentication
- ✅ Transaction history tracking
- ✅ Library statistics and reports
- ✅ Guest access for viewing available books

## 🎯 OOP Principles Demonstrated

### 1. Encapsulation Examples
```java
// Private fields with public getter/setter methods
private String isbn;
private boolean isAvailable;

public String getIsbn() { return isbn; }
public boolean isAvailable() { return isAvailable; }
```

### 2. Inheritance Examples
```java
// Base class
public abstract class Person {
    protected String id, name, email;
}

// Derived classes
public class Member extends Person { ... }
public class Librarian extends Person { ... }
```

### 3. Polymorphism Examples
```java
// Method overriding
@Override
public String getRole() { return "MEMBER"; }

// Runtime polymorphism
Person person = new Member(...);
person.displayInfo(); // Calls Member's implementation
```

### 4. Abstraction Examples
```java
// Abstract class with abstract methods
public abstract class Person {
    public abstract String getRole();
    public abstract void displayInfo();
}
```

## 🚀 How to Run

1. **Compile all Java files:**
   ```bash
   javac *.java
   ```

2. **Run the main system:**
   ```bash
   java LibraryManagementSystem
   ```

3. **Login as Librarian:**
   - Use ID: `LIB001` (Alice Johnson) or `LIB002` (Bob Smith)

## 📊 Sample Data

### Pre-loaded Librarians
- **LIB001**: Alice Johnson (Morning shift, Administration)
- **LIB002**: Bob Smith (Evening shift, Reference)

### Pre-loaded Members
- **MEM001**: John Doe (Student - max 3 books)
- **MEM002**: Jane Smith (Faculty - max 10 books)
- **MEM003**: Mike Wilson (General - max 5 books)

### Pre-loaded Books
- Programming books by various authors
- Categories: Programming, Software Engineering, Web Development
- All books initially available for borrowing

## 🎮 System Navigation

### Main Menu Options
1. **Book Management**: Add, remove, view books
2. **Member Management**: Manage library members
3. **Issue Book**: Lend books to members
4. **Return Book**: Process book returns
5. **Search Books**: Find books by various criteria
6. **View Statistics**: Library overview and metrics
7. **Transaction History**: View system activity log

## 🔍 Advanced Features

### Smart Borrowing Rules
- **Students**: Maximum 3 books
- **Faculty**: Maximum 10 books
- **General Members**: Maximum 5 books
- No borrowing allowed with outstanding fines

### Automatic Fine Calculation
- $1 per day for overdue books
- Automatic calculation on book return
- Fine payment tracking

### Comprehensive Search
- Search by title (partial matching)
- Search by author (partial matching)
- Search by category (partial matching)
- Case-insensitive search

### Transaction Logging
- All system activities logged with timestamps
- View recent transactions or complete history
- Audit trail for library operations

## 🏆 OOP Best Practices Implemented

1. **Single Responsibility Principle**: Each class has a specific purpose
2. **Data Hiding**: Private fields with controlled access
3. **Code Reusability**: Inheritance and method overriding
4. **Maintainability**: Modular design with clear separation of concerns
5. **Extensibility**: Easy to add new member types or book categories

## 🔧 Possible Enhancements

- Database integration (currently uses in-memory storage)
- GUI interface using JavaFX or Swing
- Email notifications for due dates
- Book reservation system
- Multiple library branches support
- Advanced reporting and analytics

---

This Library Management System serves as an excellent example of Object-Oriented Programming principles in action, demonstrating how real-world systems can be modeled using OOP concepts effectively.
