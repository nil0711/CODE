import java.util.*;
class MyMainEmployee{
    private int id;
    private String name;

    public MyMainEmployee(String myName,int myId) {
        id =myId;
        name=myName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName(){return name;}

    public void setName(String name) {
        this.name = name;
    }

}
public class java_constructors {
    public static void main(String[] args) {
        MyMainEmployee Employee = new MyMainEmployee("gh",34);

//        Employee.setName("Sd");
//        Employee.setId(8);

        System.out.println((Employee.getName()));
        System.out.println((Employee.getId()));

    }

}
