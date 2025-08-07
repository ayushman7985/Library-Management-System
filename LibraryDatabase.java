import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * LibraryDatabase class manages all data operations
 * Demonstrates composition and data management
 */
public class LibraryDatabase {
    private Map<String, Book> books;
    private Map<String, Member> members;
    private Map<String, Librarian> librarians;
    private List<String> transactionHistory;
    private SimpleDateFormat dateFormat;
    
    // Constructor
    public LibraryDatabase() {
        this.books = new HashMap<>();
        this.members = new HashMap<>();
        this.librarians = new HashMap<>();
        this.transactionHistory = new ArrayList<>();
        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }
    
    // Book management methods
    public boolean addBook(Book book) {
        if (book != null && !books.containsKey(book.getIsbn())) {
            books.put(book.getIsbn(), book);
            addTransaction("BOOK_ADDED: " + book.getTitle() + " (ISBN: " + book.getIsbn() + ")");
            return true;
        }
        return false;
    }
    
    public boolean removeBook(String isbn) {
        Book book = books.remove(isbn);
        if (book != null) {
            addTransaction("BOOK_REMOVED: " + book.getTitle() + " (ISBN: " + isbn + ")");
            return true;
        }
        return false;
    }
    
    public Book getBook(String isbn) {
        return books.get(isbn);
    }
    
    public List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }
    
    public List<Book> getAvailableBooks() {
        return books.values().stream()
                .filter(Book::isAvailable)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }
    
    public List<Book> searchBooksByTitle(String title) {
        return books.values().stream()
                .filter(book -> book.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }
    
    public List<Book> searchBooksByAuthor(String author) {
        return books.values().stream()
                .filter(book -> book.getAuthor().toLowerCase().contains(author.toLowerCase()))
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }
    
    public List<Book> searchBooksByCategory(String category) {
        return books.values().stream()
                .filter(book -> book.getCategory().toLowerCase().contains(category.toLowerCase()))
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }
    
    // Member management methods
    public boolean addMember(Member member) {
        if (member != null && !members.containsKey(member.getId())) {
            members.put(member.getId(), member);
            addTransaction("MEMBER_ADDED: " + member.getName() + " (ID: " + member.getId() + ")");
            return true;
        }
        return false;
    }
    
    public boolean removeMember(String memberId) {
        Member member = members.get(memberId);
        if (member != null && member.getBorrowedBooksCount() == 0) {
            members.remove(memberId);
            addTransaction("MEMBER_REMOVED: " + member.getName() + " (ID: " + memberId + ")");
            return true;
        }
        return false;
    }
    
    public Member getMember(String memberId) {
        return members.get(memberId);
    }
    
    public List<Member> getAllMembers() {
        return new ArrayList<>(members.values());
    }
    
    // Librarian management methods
    public boolean addLibrarian(Librarian librarian) {
        if (librarian != null && !librarians.containsKey(librarian.getId())) {
            librarians.put(librarian.getId(), librarian);
            addTransaction("LIBRARIAN_ADDED: " + librarian.getName() + " (ID: " + librarian.getId() + ")");
            return true;
        }
        return false;
    }
    
    public boolean removeLibrarian(String librarianId) {
        Librarian librarian = librarians.remove(librarianId);
        if (librarian != null) {
            addTransaction("LIBRARIAN_REMOVED: " + librarian.getName() + " (ID: " + librarianId + ")");
            return true;
        }
        return false;
    }
    
    public Librarian getLibrarian(String librarianId) {
        return librarians.get(librarianId);
    }
    
    public List<Librarian> getAllLibrarians() {
        return new ArrayList<>(librarians.values());
    }
    
    // Transaction management
    private void addTransaction(String transaction) {
        String timestamp = dateFormat.format(new Date());
        transactionHistory.add(timestamp + " - " + transaction);
    }
    
    public List<String> getTransactionHistory() {
        return new ArrayList<>(transactionHistory);
    }
    
    public List<String> getRecentTransactions(int count) {
        int size = transactionHistory.size();
        int start = Math.max(0, size - count);
        return transactionHistory.subList(start, size);
    }
    
    // Statistics methods
    public int getTotalBooks() {
        return books.size();
    }
    
    public int getAvailableBooksCount() {
        return (int) books.values().stream().filter(Book::isAvailable).count();
    }
    
    public int getBorrowedBooksCount() {
        return (int) books.values().stream().filter(book -> !book.isAvailable()).count();
    }
    
    public int getTotalMembers() {
        return members.size();
    }
    
    public int getTotalLibrarians() {
        return librarians.size();
    }
    
    public void displayStatistics() {
        System.out.println("=== LIBRARY STATISTICS ===");
        System.out.println("Total Books: " + getTotalBooks());
        System.out.println("Available Books: " + getAvailableBooksCount());
        System.out.println("Borrowed Books: " + getBorrowedBooksCount());
        System.out.println("Total Members: " + getTotalMembers());
        System.out.println("Total Librarians: " + getTotalLibrarians());
        System.out.println("Total Transactions: " + transactionHistory.size());
        System.out.println("=========================");
    }
}
