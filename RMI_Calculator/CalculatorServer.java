//package RMI_Calculator;
//
//import java.rmi.*;
//import java.rmi.registry.LocateRegistry;
//
//public class CalculatorServer {
//    public static void main(String[] args) {
//        try {
//            Calculator calculator = new Calculator();
//            LocateRegistry.createRegistry(22448);
//            Naming.rebind("//localhost/CalculatorService", calculator);
//            System.out.println("CalculatorService bound in registry");
//        } catch (Exception e) {
//            System.out.println("CalculatorService error: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }
//}
//
