import java.util.*;
class Employeee{
    int salary;
    String name;
    public int getSalary(){
        return salary;
    }
    public String getName(){
        return name;
    }
    public String setName(String n){
       return name=n;
    }
    public void printData(){
        System.out.println("My name is "+name);
        System.out.println("My salary is "+salary);
    }
}
public class java_oops_sum_1 {
    public static void main(String[] args) {
        Employeee nilan=new Employeee();

        nilan.salary=34;
        nilan.name="Alur Porota";

        nilan.printData();

        nilan.setName("Alu Posto");

        nilan.printData();




    }
}
