/**
 * Librarian class extending Person
 * Represents library staff who manage the library
 * Demonstrates inheritance and polymorphism
 */
public class Librarian extends Person {
    private String employeeId;
    private String department;
    private String joinDate;
    private double salary;
    private String shift; // MORNING, EVENING, NIGHT
    
    // Constructor
    public Librarian(String id, String name, String email, String phone, String address,
                     String employeeId, String department, String joinDate, double salary, String shift) {
        super(id, name, email, phone, address);
        this.employeeId = employeeId;
        this.department = department;
        this.joinDate = joinDate;
        this.salary = salary;
        this.shift = shift;
    }
    
    // Getters
    public String getEmployeeId() {
        return employeeId;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public String getJoinDate() {
        return joinDate;
    }
    
    public double getSalary() {
        return salary;
    }
    
    public String getShift() {
        return shift;
    }
    
    // Setters
    public void setDepartment(String department) {
        this.department = department;
    }
    
    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    public void setShift(String shift) {
        this.shift = shift;
    }
    
    // Business methods
    public boolean canIssueBook() {
        return true; // Librarians can always issue books
    }
    
    public boolean canAcceptReturn() {
        return true; // Librarians can always accept returns
    }
    
    public boolean canAddBook() {
        return true; // Librarians can add new books
    }
    
    public boolean canRemoveBook() {
        return true; // Librarians can remove books
    }
    
    // Override abstract methods from Person
    @Override
    public String getRole() {
        return "LIBRARIAN";
    }
    
    @Override
    public void displayInfo() {
        System.out.println("=== LIBRARIAN INFORMATION ===");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Address: " + address);
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Department: " + department);
        System.out.println("Join Date: " + joinDate);
        System.out.println("Salary: $" + salary);
        System.out.println("Shift: " + shift);
        System.out.println("============================");
    }
    
    @Override
    public String toString() {
        return "Librarian{" +
                "ID='" + id + '\'' +
                ", Name='" + name + '\'' +
                ", EmployeeID='" + employeeId + '\'' +
                ", Department='" + department + '\'' +
                ", Shift='" + shift + '\'' +
                '}';
    }
}
