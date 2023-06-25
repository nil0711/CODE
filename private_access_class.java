class private_access {
    //    private variable
    private String data;
    //        constructor
    private_access(String data){
        this.data=data;
    }
    //        private method
    private String method(){
        return data;
    }
//    using getter method to access private method
    String getMethod(){
        return method();
    }
}
//  Driver code
public class private_access_class {
    public static void main(String[] args) {
//        creating object
        private_access test1= new private_access("Class with private access modifier");
//        object calling method from outer class
//        System.out.println(test1.method());
        System.out.println(test1.getMethod());
    }
}
