class public_access {
    //    public variable
    public String data;
    //        constructor
    public_access(String data){
        this.data=data;
    }
    //        public method
    public String method(){
        return data;
    }
}
//        Driver code
public class public_access_class {
    public static void main(String[] args) {
//        creating object
        public_access test1 = new public_access("Class with public access modifier");
//        object calling method from outer class
        System.out.println(test1.method());
    }
}
