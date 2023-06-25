class default_access {
//    default variable
        String data;
//        constructor
        default_access(String data){
            this.data=data;
        }
//        default method
        String method(){
            return data;
        }
        }
//        Driver code
public class default_access_class {
    public static void main(String[] args) {
//        creating object
        default_access test1= new default_access("Class with default access modifier");
//        object calling method from outer class
        System.out.println(test1.method());
    }
}
