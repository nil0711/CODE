public class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) throws InvalidEmployeeAgeException {
        this.name = name;
        if (age < 18 || age > 60) {
            throw new InvalidEmployeeAgeException("Invalid employee age: " + age);
        }
        this.age = age;
    }

    // getters and setters for name and age

    public static void main(String[] args) {
        try {
            Employee ram = new Employee("Ram", 25);
            System.out.println("Employee created: " + ram.getName() + ", " + ram.getAge() + " years old.");

            Employee shyam = new Employee("Shyam", 65); // this will throw an exception
        } catch (InvalidEmployeeAgeException e) {
            System.out.println("Error creating employee: " + e.getMessage());
        }
    }

    private int getAge() {

        return age;
    }

    private String getName() {
        return name;
    }
}

class InvalidEmployeeAgeException extends Exception {
    public InvalidEmployeeAgeException(String message) {
        super(message);
    }
}

