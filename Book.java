/**
 * Book class representing a book in the library
 * Demonstrates encapsulation with private fields and public methods
 */
public class Book {
    private String isbn;
    private String title;
    private String author;
    private String category;
    private boolean isAvailable;
    private String borrowedBy;
    private String borrowDate;
    private String dueDate;
    
    // Constructor
    public Book(String isbn, String title, String author, String category) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.category = category;
        this.isAvailable = true;
        this.borrowedBy = null;
        this.borrowDate = null;
        this.dueDate = null;
    }
    
    // Getters
    public String getIsbn() {
        return isbn;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public String getCategory() {
        return category;
    }
    
    public boolean isAvailable() {
        return isAvailable;
    }
    
    public String getBorrowedBy() {
        return borrowedBy;
    }
    
    public String getBorrowDate() {
        return borrowDate;
    }
    
    public String getDueDate() {
        return dueDate;
    }
    
    // Setters
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    
    // Business methods
    public boolean borrowBook(String memberName, String borrowDate, String dueDate) {
        if (isAvailable) {
            this.isAvailable = false;
            this.borrowedBy = memberName;
            this.borrowDate = borrowDate;
            this.dueDate = dueDate;
            return true;
        }
        return false;
    }
    
    public boolean returnBook() {
        if (!isAvailable) {
            this.isAvailable = true;
            this.borrowedBy = null;
            this.borrowDate = null;
            this.dueDate = null;
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "Book{" +
                "ISBN='" + isbn + '\'' +
                ", Title='" + title + '\'' +
                ", Author='" + author + '\'' +
                ", Category='" + category + '\'' +
                ", Available=" + isAvailable +
                (borrowedBy != null ? ", Borrowed by='" + borrowedBy + '\'' : "") +
                '}';
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return isbn.equals(book.isbn);
    }
    
    @Override
    public int hashCode() {
        return isbn.hashCode();
    }
}
