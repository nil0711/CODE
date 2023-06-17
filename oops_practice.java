import java.util.*;
class Employee{
    int id;
    String name;
    int salary;
    public void printDetails(){
        System.out.println("My id is "+id);
        System.out.println("My name is "+name);
    }
    public  int getSalary(){
        return salary;
    }
}
public class oops_practice {
    public static void main(String[] args) {
        System.out.println("This is our custom class");
        Employee nila=new Employee();
        Employee maity=new Employee();

        nila.id = 25;
        nila.name = "Muglai Porota";
        nila.salary=420;

        maity.id=10;
        maity.name="Khasta Kochuri";
        maity.salary=420+2;


        nila.printDetails();
        nila.getSalary();
        System.out.println(nila.salary);



        maity.printDetails();
        maity.getSalary();
        System.out.println(maity.salary);

    }
}
