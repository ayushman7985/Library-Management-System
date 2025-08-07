import java.util.ArrayList;
import java.util.List;

/**
 * Member class extending Person
 * Represents library members who can borrow books
 * Demonstrates inheritance and polymorphism
 */
public class Member extends Person {
    private String membershipType; // STUDENT, FACULTY, GENERAL
    private String membershipDate;
    private int maxBooksAllowed;
    private List<String> borrowedBooks;
    private double fineAmount;
    
    // Constructor
    public Member(String id, String name, String email, String phone, String address, 
                  String membershipType, String membershipDate) {
        super(id, name, email, phone, address);
        this.membershipType = membershipType;
        this.membershipDate = membershipDate;
        this.borrowedBooks = new ArrayList<>();
        this.fineAmount = 0.0;
        
        // Set max books based on membership type
        switch (membershipType.toUpperCase()) {
            case "STUDENT":
                this.maxBooksAllowed = 3;
                break;
            case "FACULTY":
                this.maxBooksAllowed = 10;
                break;
            case "GENERAL":
                this.maxBooksAllowed = 5;
                break;
            default:
                this.maxBooksAllowed = 2;
        }
    }
    
    // Getters
    public String getMembershipType() {
        return membershipType;
    }
    
    public String getMembershipDate() {
        return membershipDate;
    }
    
    public int getMaxBooksAllowed() {
        return maxBooksAllowed;
    }
    
    public List<String> getBorrowedBooks() {
        return new ArrayList<>(borrowedBooks);
    }
    
    public double getFineAmount() {
        return fineAmount;
    }
    
    public int getBorrowedBooksCount() {
        return borrowedBooks.size();
    }
    
    // Setters
    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }
    
    public void setFineAmount(double fineAmount) {
        this.fineAmount = fineAmount;
    }
    
    // Business methods
    public boolean canBorrowBook() {
        return borrowedBooks.size() < maxBooksAllowed && fineAmount == 0;
    }
    
    public boolean borrowBook(String isbn) {
        if (canBorrowBook()) {
            borrowedBooks.add(isbn);
            return true;
        }
        return false;
    }
    
    public boolean returnBook(String isbn) {
        return borrowedBooks.remove(isbn);
    }
    
    public void addFine(double amount) {
        this.fineAmount += amount;
    }
    
    public void payFine(double amount) {
        this.fineAmount = Math.max(0, this.fineAmount - amount);
    }
    
    // Override abstract methods from Person
    @Override
    public String getRole() {
        return "MEMBER";
    }
    
    @Override
    public void displayInfo() {
        System.out.println("=== MEMBER INFORMATION ===");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Address: " + address);
        System.out.println("Membership Type: " + membershipType);
        System.out.println("Membership Date: " + membershipDate);
        System.out.println("Books Borrowed: " + borrowedBooks.size() + "/" + maxBooksAllowed);
        System.out.println("Fine Amount: $" + fineAmount);
        if (!borrowedBooks.isEmpty()) {
            System.out.println("Borrowed Books: " + borrowedBooks);
        }
        System.out.println("========================");
    }
    
    @Override
    public String toString() {
        return "Member{" +
                "ID='" + id + '\'' +
                ", Name='" + name + '\'' +
                ", Type='" + membershipType + '\'' +
                ", Books=" + borrowedBooks.size() + "/" + maxBooksAllowed +
                ", Fine=$" + fineAmount +
                '}';
    }
}
