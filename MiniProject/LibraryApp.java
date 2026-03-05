package MiniProject;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private int bookId;
    private String title;
    private String author;
    private boolean available = true;
    private LocalDate borrowedDate;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public LocalDate getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(LocalDate date) {
        this.borrowedDate = date;
    }

    public void displayInfo() {
        String borrowedOn = borrowedDate != null ? borrowedDate.toString() : "-";

        String dueDate = borrowedDate != null ? borrowedDate.plusDays(7).toString() : "-";

        System.out.printf("%-5d %-25s %-20s %-10s %-12s %-12s\n",
                bookId, title, author, available ? "Yes" : "No", borrowedOn, dueDate);
    }
}

abstract class Person {
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public abstract void displayInfo();
}

class Librarian extends Person {
    public Librarian(int id, String name) {
        super(id, name);
    }

    @Override
    public void displayInfo() {
        System.out.println("[Librarian] ID: " + getId() + ", Name: " + getName());
    }
}

class Student extends Person {
    private List<Book> borrowedBooks = new ArrayList<>();

    public Student(int id, String name) {
        super(id, name);
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
        book.setBorrowedDate(LocalDate.now());
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
        if (book.getBorrowedDate() != null) {
            long days = ChronoUnit.DAYS.between(book.getBorrowedDate(), LocalDate.now());
            if (days > 7) {
                long fine = (days - 7) * 10;
                System.out.println("⚠️ Late return! Fine: ₹" + fine);
            }
        }
        book.setBorrowedDate(null);
    }

    @Override
    public void displayInfo() {
        System.out.printf("\nStudent ID: %-5d Name: %-20s Borrowed Books: %-3d\n",
                getId(), getName(), borrowedBooks.size());
        if (!borrowedBooks.isEmpty()) {
            System.out.printf("%-25s %-12s %-12s %-6s\n", "Book Title", "Borrowed On", "Due Date", "Fine");
            System.out.println("--------------------------------------------------------");
            for (Book b : borrowedBooks) {
                long fine = 0;
                if (b.getBorrowedDate() != null) {
                    long days = ChronoUnit.DAYS.between(b.getBorrowedDate(), java.time.LocalDate.now());
                    if (days > 7)
                        fine = (days - 7) * 10;
                }
                System.out.printf("%-25s %-12s %-12s %-6s\n",
                        b.getTitle(),
                        b.getBorrowedDate(),
                        b.getBorrowedDate().plusDays(7),
                        fine > 0 ? "₹" + fine : "-");
            }
        }
    }
}

class Library {
    private List<Book> books = new ArrayList<>();
    private List<Student> students = new ArrayList<>();
    private List<Librarian> librarians = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("🎉 Book added: " + book.getTitle());
    }

    public void removeBook(int bookId) {
        Book book = findBook(bookId);
        if (book != null) {
            books.remove(book);
            System.out.println("❌ Book removed: " + book.getTitle());
        } else
            System.out.println("❌ Book not found!");
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("🎉 Student registered: " + student.getName());
    }

    public void addLibrarian(Librarian librarian) {
        librarians.add(librarian);
        System.out.println("🎉 Librarian added: " + librarian.getName());
    }

    public Book findBook(int bookId) {
        for (Book b : books)
            if (b.getBookId() == bookId)
                return b;
        return null;
    }

    public Student findStudent(int studentId) {
        for (Student s : students)
            if (s.getId() == studentId)
                return s;
        return null;
    }

    public void issueBook(int studentId, int bookId) {
        Student student = findStudent(studentId);
        Book book = findBook(bookId);
        if (student != null && book != null && book.isAvailable()) {
            student.borrowBook(book);
            book.setAvailable(false);
            System.out.println("✅ Book issued: " + book.getTitle() + " to " + student.getName());
        } else
            System.out.println("❌ Cannot issue book!");
    }

    public void returnBook(int studentId, int bookId) {
        Student student = findStudent(studentId);
        Book book = findBook(bookId);
        if (student != null && book != null && !book.isAvailable()) {
            student.returnBook(book);
            book.setAvailable(true);
            System.out.println("✅ Book returned: " + book.getTitle() + " by " + student.getName());
        } else
            System.out.println("❌ Cannot return book!");
    }

    public void showBooks() {
        System.out.printf("\n%-5s %-25s %-20s %-10s %-12s %-12s\n",
                "ID", "Title", "Author", "Available", "Borrowed On", "Due Date");
        System.out.println("----------------------------------------------------------------------------------");
        for (Book b : books)
            b.displayInfo();
    }

    public void showStudents() {
        for (Student s : students)
            s.displayInfo();
    }

    public void showLibrarians() {
        for (Librarian l : librarians)
            l.displayInfo();
    }
}

public class LibraryApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        library.addLibrarian(new Librarian(1, "Alice"));
        library.addLibrarian(new Librarian(2, "Bob"));
        library.addStudent(new Student(101, "Pandurang Suryawanshi"));
        library.addStudent(new Student(102, "Shivam Shinde"));
        library.addStudent(new Student(103, "Imran Sayyad"));
        library.addStudent(new Student(104, "Amar Nelwade"));
        library.addBook(new Book(201, "Java OOP", "James Gosling"));
        library.addBook(new Book(202, "Effective Java", "Joshua Bloch"));
        library.addBook(new Book(203, "Head First Java", "Kathy Sierra"));

        int choice;
        do {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Show All Books");
            System.out.println("2. Show All Students");
            System.out.println("3. Show All Librarians");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Add Book");
            System.out.println("7. Remove Book");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> library.showBooks();
                case 2 -> library.showStudents();
                case 3 -> library.showLibrarians();
                case 4 -> {
                    System.out.print("Enter Student ID: ");
                    int sid = sc.nextInt();
                    System.out.print("Enter Book ID: ");
                    int bid = sc.nextInt();
                    library.issueBook(sid, bid);
                }
                case 5 -> {
                    System.out.print("Enter Student ID: ");
                    int sid = sc.nextInt();
                    System.out.print("Enter Book ID: ");
                    int bid = sc.nextInt();
                    library.returnBook(sid, bid);
                }
                case 6 -> {
                    System.out.print("Enter Book ID: ");
                    int bid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    library.addBook(new Book(bid, title, author));
                }
                case 7 -> {
                    System.out.print("Enter Book ID to remove: ");
                    int bid = sc.nextInt();
                    library.removeBook(bid);
                }
                case 8 -> System.out.println("👋 Exiting...");
                default -> System.out.println("❌ Invalid choice!");
            }
        } while (choice != 8);

        sc.close();
    }
}
