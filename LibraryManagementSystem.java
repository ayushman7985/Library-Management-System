import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

/**
 * Main LibraryManagementSystem class
 * Demonstrates composition, polymorphism, and system integration
 */
public class LibraryManagementSystem {
    private LibraryDatabase database;
    private Scanner scanner;
    private SimpleDateFormat dateFormat;
    private String currentLibrarianId;
    
    // Constructor
    public LibraryManagementSystem() {
        this.database = new LibraryDatabase();
        this.scanner = new Scanner(System.in);
        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.currentLibrarianId = null;
        initializeSystem();
    }
    
    // Initialize system with sample data
    private void initializeSystem() {
        // Add sample librarians
        Librarian lib1 = new Librarian("LIB001", "Alice Johnson", "alice@library.com", 
                                      "555-0101", "123 Main St", "EMP001", "Administration", 
                                      "2020-01-15", 45000.0, "MORNING");
        Librarian lib2 = new Librarian("LIB002", "Bob Smith", "bob@library.com", 
                                      "555-0102", "456 Oak Ave", "EMP002", "Reference", 
                                      "2021-03-20", 42000.0, "EVENING");
        
        database.addLibrarian(lib1);
        database.addLibrarian(lib2);
        
        // Add sample members
        Member mem1 = new Member("MEM001", "John Doe", "john@email.com", "555-1001", 
                                "789 Pine St", "STUDENT", "2023-09-01");
        Member mem2 = new Member("MEM002", "Jane Smith", "jane@email.com", "555-1002", 
                                "321 Elm St", "FACULTY", "2022-08-15");
        Member mem3 = new Member("MEM003", "Mike Wilson", "mike@email.com", "555-1003", 
                                "654 Maple Ave", "GENERAL", "2023-10-10");
        
        database.addMember(mem1);
        database.addMember(mem2);
        database.addMember(mem3);
        
        // Add sample books
        Book book1 = new Book("978-0134685991", "Effective Java", "Joshua Bloch", "Programming");
        Book book2 = new Book("978-0596009205", "Head First Design Patterns", "Eric Freeman", "Programming");
        Book book3 = new Book("978-0321356680", "Effective C++", "Scott Meyers", "Programming");
        Book book4 = new Book("978-0132350884", "Clean Code", "Robert Martin", "Programming");
        Book book5 = new Book("978-0201633610", "Design Patterns", "Gang of Four", "Programming");
        Book book6 = new Book("978-0134494166", "Clean Architecture", "Robert Martin", "Software Engineering");
        Book book7 = new Book("978-1449331818", "Learning Python", "Mark Lutz", "Programming");
        Book book8 = new Book("978-0596517748", "JavaScript: The Good Parts", "Douglas Crockford", "Web Development");
        
        database.addBook(book1);
        database.addBook(book2);
        database.addBook(book3);
        database.addBook(book4);
        database.addBook(book5);
        database.addBook(book6);
        database.addBook(book7);
        database.addBook(book8);
    }
    
    // Main menu system
    public void start() {
        System.out.println("=================================");
        System.out.println("  LIBRARY MANAGEMENT SYSTEM");
        System.out.println("=================================");
        
        while (true) {
            if (currentLibrarianId == null) {
                showLoginMenu();
            } else {
                showMainMenu();
            }
        }
    }
    
    private void showLoginMenu() {
        System.out.println("\n=== LOGIN ===");
        System.out.println("1. Librarian Login");
        System.out.println("2. View Available Books (Guest)");
        System.out.println("3. Exit");
        System.out.print("Choose option: ");
        
        int choice = getIntInput();
        
        switch (choice) {
            case 1:
                librarianLogin();
                break;
            case 2:
                viewAvailableBooks();
                break;
            case 3:
                System.out.println("Thank you for using Library Management System!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option! Please try again.");
        }
    }
    
    private void librarianLogin() {
        System.out.print("Enter Librarian ID: ");
        String libId = scanner.nextLine().trim();
        
        Librarian librarian = database.getLibrarian(libId);
        if (librarian != null) {
            currentLibrarianId = libId;
            System.out.println("Welcome, " + librarian.getName() + "!");
        } else {
            System.out.println("Invalid Librarian ID!");
        }
    }
    
    private void showMainMenu() {
        System.out.println("\n=== MAIN MENU ===");
        System.out.println("1. Book Management");
        System.out.println("2. Member Management");
        System.out.println("3. Issue Book");
        System.out.println("4. Return Book");
        System.out.println("5. Search Books");
        System.out.println("6. View Statistics");
        System.out.println("7. View Transaction History");
        System.out.println("8. Logout");
        System.out.print("Choose option: ");
        
        int choice = getIntInput();
        
        switch (choice) {
            case 1:
                bookManagementMenu();
                break;
            case 2:
                memberManagementMenu();
                break;
            case 3:
                issueBook();
                break;
            case 4:
                returnBook();
                break;
            case 5:
                searchBooksMenu();
                break;
            case 6:
                database.displayStatistics();
                break;
            case 7:
                viewTransactionHistory();
                break;
            case 8:
                currentLibrarianId = null;
                System.out.println("Logged out successfully!");
                break;
            default:
                System.out.println("Invalid option! Please try again.");
        }
    }
    
    private void bookManagementMenu() {
        System.out.println("\n=== BOOK MANAGEMENT ===");
        System.out.println("1. Add Book");
        System.out.println("2. Remove Book");
        System.out.println("3. View All Books");
        System.out.println("4. View Available Books");
        System.out.println("5. View Borrowed Books");
        System.out.println("6. Back to Main Menu");
        System.out.print("Choose option: ");
        
        int choice = getIntInput();
        
        switch (choice) {
            case 1:
                addBook();
                break;
            case 2:
                removeBook();
                break;
            case 3:
                viewAllBooks();
                break;
            case 4:
                viewAvailableBooks();
                break;
            case 5:
                viewBorrowedBooks();
                break;
            case 6:
                return;
            default:
                System.out.println("Invalid option! Please try again.");
        }
    }
    
    private void memberManagementMenu() {
        System.out.println("\n=== MEMBER MANAGEMENT ===");
        System.out.println("1. Add Member");
        System.out.println("2. Remove Member");
        System.out.println("3. View All Members");
        System.out.println("4. View Member Details");
        System.out.println("5. Update Member Fine");
        System.out.println("6. Back to Main Menu");
        System.out.print("Choose option: ");
        
        int choice = getIntInput();
        
        switch (choice) {
            case 1:
                addMember();
                break;
            case 2:
                removeMember();
                break;
            case 3:
                viewAllMembers();
                break;
            case 4:
                viewMemberDetails();
                break;
            case 5:
                updateMemberFine();
                break;
            case 6:
                return;
            default:
                System.out.println("Invalid option! Please try again.");
        }
    }
    
    private void searchBooksMenu() {
        System.out.println("\n=== SEARCH BOOKS ===");
        System.out.println("1. Search by Title");
        System.out.println("2. Search by Author");
        System.out.println("3. Search by Category");
        System.out.println("4. Back to Main Menu");
        System.out.print("Choose option: ");
        
        int choice = getIntInput();
        
        switch (choice) {
            case 1:
                searchBooksByTitle();
                break;
            case 2:
                searchBooksByAuthor();
                break;
            case 3:
                searchBooksByCategory();
                break;
            case 4:
                return;
            default:
                System.out.println("Invalid option! Please try again.");
        }
    }
    
    // Book management methods
    private void addBook() {
        System.out.println("\n=== ADD BOOK ===");
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine().trim();
        
        if (database.getBook(isbn) != null) {
            System.out.println("Book with this ISBN already exists!");
            return;
        }
        
        System.out.print("Enter Title: ");
        String title = scanner.nextLine().trim();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine().trim();
        System.out.print("Enter Category: ");
        String category = scanner.nextLine().trim();
        
        Book book = new Book(isbn, title, author, category);
        if (database.addBook(book)) {
            System.out.println("Book added successfully!");
        } else {
            System.out.println("Failed to add book!");
        }
    }
    
    private void removeBook() {
        System.out.println("\n=== REMOVE BOOK ===");
        System.out.print("Enter ISBN of book to remove: ");
        String isbn = scanner.nextLine().trim();
        
        Book book = database.getBook(isbn);
        if (book == null) {
            System.out.println("Book not found!");
            return;
        }
        
        if (!book.isAvailable()) {
            System.out.println("Cannot remove book - it is currently borrowed!");
            return;
        }
        
        if (database.removeBook(isbn)) {
            System.out.println("Book removed successfully!");
        } else {
            System.out.println("Failed to remove book!");
        }
    }
    
    private void viewAllBooks() {
        System.out.println("\n=== ALL BOOKS ===");
        List<Book> books = database.getAllBooks();
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
    
    private void viewAvailableBooks() {
        System.out.println("\n=== AVAILABLE BOOKS ===");
        List<Book> books = database.getAvailableBooks();
        if (books.isEmpty()) {
            System.out.println("No available books.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
    
    private void viewBorrowedBooks() {
        System.out.println("\n=== BORROWED BOOKS ===");
        List<Book> allBooks = database.getAllBooks();
        List<Book> borrowedBooks = new ArrayList<>();
        
        for (Book book : allBooks) {
            if (!book.isAvailable()) {
                borrowedBooks.add(book);
            }
        }
        
        if (borrowedBooks.isEmpty()) {
            System.out.println("No borrowed books.");
        } else {
            for (Book book : borrowedBooks) {
                System.out.println(book);
            }
        }
    }
    
    // Member management methods
    private void addMember() {
        System.out.println("\n=== ADD MEMBER ===");
        System.out.print("Enter Member ID: ");
        String id = scanner.nextLine().trim();
        
        if (database.getMember(id) != null) {
            System.out.println("Member with this ID already exists!");
            return;
        }
        
        System.out.print("Enter Name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine().trim();
        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine().trim();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine().trim();
        System.out.print("Enter Membership Type (STUDENT/FACULTY/GENERAL): ");
        String type = scanner.nextLine().trim().toUpperCase();
        
        String membershipDate = dateFormat.format(new Date());
        
        Member member = new Member(id, name, email, phone, address, type, membershipDate);
        if (database.addMember(member)) {
            System.out.println("Member added successfully!");
        } else {
            System.out.println("Failed to add member!");
        }
    }
    
    private void removeMember() {
        System.out.println("\n=== REMOVE MEMBER ===");
        System.out.print("Enter Member ID to remove: ");
        String id = scanner.nextLine().trim();
        
        Member member = database.getMember(id);
        if (member == null) {
            System.out.println("Member not found!");
            return;
        }
        
        if (member.getBorrowedBooksCount() > 0) {
            System.out.println("Cannot remove member - they have borrowed books!");
            return;
        }
        
        if (database.removeMember(id)) {
            System.out.println("Member removed successfully!");
        } else {
            System.out.println("Failed to remove member!");
        }
    }
    
    private void viewAllMembers() {
        System.out.println("\n=== ALL MEMBERS ===");
        List<Member> members = database.getAllMembers();
        if (members.isEmpty()) {
            System.out.println("No members registered.");
        } else {
            for (Member member : members) {
                System.out.println(member);
            }
        }
    }
    
    private void viewMemberDetails() {
        System.out.println("\n=== MEMBER DETAILS ===");
        System.out.print("Enter Member ID: ");
        String id = scanner.nextLine().trim();
        
        Member member = database.getMember(id);
        if (member == null) {
            System.out.println("Member not found!");
        } else {
            member.displayInfo();
        }
    }
    
    private void updateMemberFine() {
        System.out.println("\n=== UPDATE MEMBER FINE ===");
        System.out.print("Enter Member ID: ");
        String id = scanner.nextLine().trim();
        
        Member member = database.getMember(id);
        if (member == null) {
            System.out.println("Member not found!");
            return;
        }
        
        System.out.println("Current fine: $" + member.getFineAmount());
        System.out.println("1. Add Fine");
        System.out.println("2. Pay Fine");
        System.out.print("Choose option: ");
        
        int choice = getIntInput();
        System.out.print("Enter amount: $");
        double amount = getDoubleInput();
        
        if (choice == 1) {
            member.addFine(amount);
            System.out.println("Fine added successfully!");
        } else if (choice == 2) {
            member.payFine(amount);
            System.out.println("Fine payment recorded!");
        } else {
            System.out.println("Invalid option!");
        }
    }
    
    // Book transaction methods
    private void issueBook() {
        System.out.println("\n=== ISSUE BOOK ===");
        System.out.print("Enter Member ID: ");
        String memberId = scanner.nextLine().trim();
        
        Member member = database.getMember(memberId);
        if (member == null) {
            System.out.println("Member not found!");
            return;
        }
        
        if (!member.canBorrowBook()) {
            System.out.println("Member cannot borrow book. Reason: ");
            if (member.getBorrowedBooksCount() >= member.getMaxBooksAllowed()) {
                System.out.println("- Maximum books limit reached");
            }
            if (member.getFineAmount() > 0) {
                System.out.println("- Outstanding fine: $" + member.getFineAmount());
            }
            return;
        }
        
        System.out.print("Enter Book ISBN: ");
        String isbn = scanner.nextLine().trim();
        
        Book book = database.getBook(isbn);
        if (book == null) {
            System.out.println("Book not found!");
            return;
        }
        
        if (!book.isAvailable()) {
            System.out.println("Book is already borrowed by: " + book.getBorrowedBy());
            return;
        }
        
        String borrowDate = dateFormat.format(new Date());
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 14); // 2 weeks loan period
        String dueDate = dateFormat.format(cal.getTime());
        
        if (book.borrowBook(member.getName(), borrowDate, dueDate) && member.borrowBook(isbn)) {
            System.out.println("Book issued successfully!");
            System.out.println("Due date: " + dueDate);
        } else {
            System.out.println("Failed to issue book!");
        }
    }
    
    private void returnBook() {
        System.out.println("\n=== RETURN BOOK ===");
        System.out.print("Enter Book ISBN: ");
        String isbn = scanner.nextLine().trim();
        
        Book book = database.getBook(isbn);
        if (book == null) {
            System.out.println("Book not found!");
            return;
        }
        
        if (book.isAvailable()) {
            System.out.println("Book is not currently borrowed!");
            return;
        }
        
        String borrowerName = book.getBorrowedBy();
        Member member = null;
        
        // Find the member who borrowed this book
        for (Member m : database.getAllMembers()) {
            if (m.getName().equals(borrowerName)) {
                member = m;
                break;
            }
        }
        
        if (member == null) {
            System.out.println("Borrower not found!");
            return;
        }
        
        // Check for overdue fine
        try {
            Date dueDate = dateFormat.parse(book.getDueDate());
            Date today = new Date();
            if (today.after(dueDate)) {
                long diffInMillies = today.getTime() - dueDate.getTime();
                long diffInDays = diffInMillies / (1000 * 60 * 60 * 24);
                double fine = diffInDays * 1.0; // $1 per day
                member.addFine(fine);
                System.out.println("Book is overdue by " + diffInDays + " days. Fine added: $" + fine);
            }
        } catch (Exception e) {
            System.out.println("Error calculating fine: " + e.getMessage());
        }
        
        if (book.returnBook() && member.returnBook(isbn)) {
            System.out.println("Book returned successfully!");
        } else {
            System.out.println("Failed to return book!");
        }
    }
    
    // Search methods
    private void searchBooksByTitle() {
        System.out.print("Enter title to search: ");
        String title = scanner.nextLine().trim();
        
        List<Book> books = database.searchBooksByTitle(title);
        displaySearchResults(books, "title '" + title + "'");
    }
    
    private void searchBooksByAuthor() {
        System.out.print("Enter author to search: ");
        String author = scanner.nextLine().trim();
        
        List<Book> books = database.searchBooksByAuthor(author);
        displaySearchResults(books, "author '" + author + "'");
    }
    
    private void searchBooksByCategory() {
        System.out.print("Enter category to search: ");
        String category = scanner.nextLine().trim();
        
        List<Book> books = database.searchBooksByCategory(category);
        displaySearchResults(books, "category '" + category + "'");
    }
    
    private void displaySearchResults(List<Book> books, String searchCriteria) {
        System.out.println("\n=== SEARCH RESULTS for " + searchCriteria + " ===");
        if (books.isEmpty()) {
            System.out.println("No books found matching the search criteria.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
    
    private void viewTransactionHistory() {
        System.out.println("\n=== TRANSACTION HISTORY ===");
        System.out.print("Enter number of recent transactions to view (0 for all): ");
        int count = getIntInput();
        
        List<String> transactions;
        if (count == 0) {
            transactions = database.getTransactionHistory();
        } else {
            transactions = database.getRecentTransactions(count);
        }
        
        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            for (String transaction : transactions) {
                System.out.println(transaction);
            }
        }
    }
    
    // Utility methods
    private int getIntInput() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    private double getDoubleInput() {
        try {
            return Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
    
    // Main method
    public static void main(String[] args) {
        LibraryManagementSystem system = new LibraryManagementSystem();
        system.start();
    }
}
