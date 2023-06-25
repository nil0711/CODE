//private class demo_class1{
//    String str;
//    String method (String data){
//        return str+data;
//    }
//}
//protected class demo_class2{
//    String str;
//
//        demo_class2(String data){
//            this.str=data;
//        }
//        String method (String data){
//            return str+data;
//        }
//}
//public class demo_class2{
//    String str;
//
//    demo_class2(String data){
//        this.str=data;
//    }
//    String method (String data){
//        return str+data;
//    }
  class demo_class2{
    private String str;

    demo_class2(String data){
        this.str=data;
    }
    demo_class2(){

    }
    String getMethod(String data){
        return method(data);
    }
   private String method (String data){
        return str+data;
    }

}
public class lab_access_modifiers {
//    private static class demo_class1{
//        String str;
//
//        demo_class1(String data){
//            this.str=data;
//        }
//        String method (String data){
//            return str+data;
//        }
//    }
//protected  class demo_class2{
//    String str;
//
//    demo_class2(String data){
//        this.str=data;
//    }
//    String method (String data){
//        return str+data;
//    }
//public static class demo_class2{
//    String str;
//
//    demo_class2(String data){
//        this.str=data;
//    }
//    String method (String data){
//        return str+data;
//    }

    public static void main(String[] args) {
        demo_class2 test = new demo_class2("Testing ");
        System.out.println(test.getMethod("Passed"));
    }
}
