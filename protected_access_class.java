class protected_access {
    //    protected variable
    protected String data;
    //        constructor
    protected_access(String data){
        this.data=data;
    }
    //        protected method
    protected String method(){
        return data;
    }
}
//        Driver code
public class protected_access_class {
    public static void main(String[] args) {
//        creating object
        protected_access test1 = new protected_access("Class with protected access modifier");
//        object calling method from outer class
        System.out.println(test1.method());
    }
}
