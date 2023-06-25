class lab_work{
//    Variable
    String str;
    int number;
//
//  Constructor 1
    lab_work(String data){
        this.str=data;
    }
//    Constructor 2
    lab_work(String data,int a){
        this.str=data;
        this.number=a;
    }
//    Default constructor
    lab_work(){
        str="Default ";
        number=100;
    }
//    Method
    String return_method(String data){
        System.out.println(number);
        str= str+data;
        return  str;
    }
}
//   Driver Code
public class lab_classes_and_objects {
    public static void main(String[] args) {
//        Creating object
        lab_work test =  new lab_work("Testing ");
        System.out.println(test.return_method("passed"));
        lab_work test2 = new lab_work("Testing ",7);
        System.out.println(test2.return_method("passed"));
        lab_work test3 = new lab_work();
        System.out.println(test3.return_method("passed"));
    }
}
