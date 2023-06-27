import java.util.*;
class User extends Book{
    String name;
    int id;
    private int pass;
    User(String a, int b,int c){
        super();
        this.name=a;
        this.id=b;
        this.pass=c;
    }
    private boolean Verify_pass(int input){
        return input==pass;
    }
    void Verify(int input){
        if (Verify_pass(input)) System.out.println("User verified");
        else System.out.println("User access denied");
    }
    void CheckAccount(){
        System.out.println(no_borrowed_books);
        System.out.println(no_reserved_books);
        System.out.println(no_returned_books);
        System.out.println(no_lost_books_fine_amount);
    }
    void getBookInfo(){
        System.out.println(Title);
        System.out.println(Author);
        System.out.println(Publication);
        System.out.println(ISBN);
    }

}
class Librarian extends User {

    private int password;

    Librarian(String a, int b, int c, int d) {
        super(a, b, c);
        this.password = d;
    }

    private boolean Verify_l(int input) {
        return password == input;
    }

    void Verify_librarian(int input) {
        if (Verify_l(input)) System.out.println("Librarian verified");
        else return;
    }
}
class Book extends Account{
    String Title,Author,Publication;
    int ISBN;
    public Book(String a, String b, String c){
        super();
        Random ran=new Random();
        this.ISBN= (ran.nextInt())%10000;
        this.Title=a;
        this.Author=b;
        this.Publication=c;
    }

    public Book() {}
    void BookSearch(String a){
        if(a==Title) System.out.println("Book "+a+" found");
        else System.out.println("Book not found");
    }
}
class Account{
    int no_borrowed_books;
    int no_reserved_books;
    int no_returned_books;
    int no_lost_books_fine_amount;
    Account(int a, int b, int c, int d){
        super();
        this.no_borrowed_books=a;
        this.no_reserved_books=b;
        this.no_returned_books=c;
        this.no_lost_books_fine_amount=d;
    }

    public Account() {}
    void calculate_fine(){
        System.out.println("Calculating fine");
    }
}

class Library_database{
    LinkedList<String> List_of_books= new LinkedList();
    void addBook(String a){
        List_of_books.add(a);
        System.out.println("Book "+a+" added");
    }
    void deleteBook(String a){
        List_of_books.remove(a);
    }
    void Display(){
        System.out.println(List_of_books);
    }
}
class Staff extends User{
    String Dept;

    Staff(String a, int b, int c,String d) {
        super(a, b, c);
        this.Dept=d;
    }
}
class Student extends User{
    String Class;


    Student(String a, int b, int c,String d) {
        super(a, b, c);
        this.Class=d;
    }
}
public class library_management_system {
    public static void main(String[] args) {
        Account newAccount = new Account(1,2,3,4);
        Book book1= new Book("Math","RD","SN");
        Book book2= new Book("Literature","Nazrul","Ko");
        Student student1=new Student("Silo",789,1001,"MCA");
        Student student2=new Student("Loga",564,2001,"MCA");
        Staff staff1= new Staff("Jiko",473,60001,"MCA");
        Librarian librarian1=new Librarian("Milo",435,001122,334455);
        student1.no_borrowed_books=4;
        student1.CheckAccount();
        student2.Verify(2001);
        staff1.Verify(5001);
        book1.BookSearch("Math");
    }
}
