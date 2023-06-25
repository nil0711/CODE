// Create a base class for library items
class LibraryItem {
    private String title;
    private int numCopies;

    public LibraryItem(String title, int numCopies) {
        this.title = title;
        this.numCopies = numCopies;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumCopies() {
        return numCopies;
    }

    public void setNumCopies(int numCopies) {
        this.numCopies = numCopies;
    }

    public void display() {
        System.out.println("Title: " + title + "\nNumber of Copies: " + numCopies);
    }
}

// Create a subclass for books that inherits from LibraryItem
class Book extends LibraryItem {
    private String author;

    public Book(String title, int numCopies, String author) {
        super(title, numCopies);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Author: " + author);
    }
}

// Create a subclass for members
class Member {
    private String name;
    private int memberId;

    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }
}

// Create a main class to test the library management system
public class LibraryManagementSystem {
    public static void main(String[] args) {
        // Create some books
        Book book1 = new Book("The Great Gatsby", 5, "F. Scott Fitzgerald");
        Book book2 = new Book("To Kill a Mockingbird", 3, "Harper Lee");

        // Create some members
        Member member1 = new Member("Ram Nath", 1);
        Member member2 = new Member("Shyam Prasad", 2);

        // Display the initial state of the library items
        System.out.println("Initial state of library items:");
        book1.display();
        book2.display();

        // Check out a book
        book1.setNumCopies(book1.getNumCopies() - 1);
        System.out.println("\n" + member1.getName() + " has checked out " + book1.getTitle() + ". New number of copies: " + book1.getNumCopies());

        // Display the updated state of the library items
        System.out.println("\nUpdated state of library items:");
        book1.display();
        book2.display();
    }
}
