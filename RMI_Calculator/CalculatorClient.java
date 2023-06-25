//package RMI_Calculator;
//
//import java.rmi.Naming;
//import java.util.Scanner;
//
//public class CalculatorClient {
//    public static void main(String[] args) {
//        try {
//            Calculator calculator = (Calculator) Naming.lookup("//localhost/CalculatorService");
//            Scanner scanner = new Scanner(System.in);
//            while (true) {
//                System.out.println("Enter an operation (add, subtract, multiply, divide, power, sqrt) or type \"exit\" to exit:");
//                String operation = scanner.nextLine();
//                if (operation.equals("exit")) {
//                    break;
//                }
//                System.out.print("Enter the first number: ");
//                double a = scanner.nextDouble();
//                System.out.print("Enter the second number: ");
//                double b = scanner.nextDouble();
//                scanner.nextLine();
//                double result = 0;
//                switch (operation) {
//                    case "add":
//                        result = calculator.add(a, b);
//                        break;
//                    case "subtract":
//                        result = calculator.subtract(a, b);
//                        break;
//                    case "multiply":
//                        result = calculator.multiply(a, b);
//                        break;
//                    case "divide":
//                        result = calculator.divide(a, b);
//                        break;
//                    case "power":
//                        result = calculator.power(a, b);
//                        break;
//                    case "sqrt":
//                        result = calculator.sqrt(a);
//                        break;
//                    default:
//                        System.out.println("Invalid operation");
//                        break;
//                }
//                System.out.println("Result: " + result);
//            }
//        } catch (Exception e) {
//            System.out.println("CalculatorClient error: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }
//}
//
