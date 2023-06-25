public class UncheckedExceptions {

    public static void main(String[] args) {

        try {
            // Example 1: NullPointerException
            String str = null;
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException");
        }

        try {
            // Example 2: ArrayIndexOutOfBoundsException
            int[] arr = { 1, 2, 3 };
            System.out.println(arr[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException");
        }

        try {
            // Example 3: ArithmeticException
            int x = 5 / 0;
            System.out.println(x);
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException");
        }

        try {
            // Example 4: ClassCastException
            Object x = new Integer(0);
            System.out.println((String) x);
        } catch (ClassCastException e) {
            System.out.println("Caught ClassCastException");
        }

        try {
            // Example 5: IllegalArgumentException
            int age = -5;
            if (age < 0) {
                throw new IllegalArgumentException("Age cannot be negative");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException");
        }
    }
}
