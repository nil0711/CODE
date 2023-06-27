import java.io.*;


class java_checked_exception {
    public static void main(String[] args) throws IOException,ClassNotFoundException{
        FileInputStream test=null;
        try {
            test= new FileInputStream("/home/anon/test.text");
        }catch (FileNotFoundException e1){
            System.out.println(e1);
            System.out.println("File does not exist");
        }
        try {
            Class temp=Class.forName("sample");
        }catch (ClassNotFoundException e2){
            System.out.println(e2);
            System.out.println("Class not found");
        }
    }
}
