class EmployeeException extends Exception{
    EmployeeException(String s) {
        super(s);
    }
}
public class java_user_defined_exception {
    static class SampleEmp{
        void empIDCheck ( int EmpID) throws EmployeeException {
        if (EmpID <= 0 || EmpID > 999) {
            throw new EmployeeException("Invalid Employee ID");
        }
    }
    }

    public static void main(String[] args) {
        SampleEmp emp = new SampleEmp();
        try
        {
            emp.empIDCheck(0);
        }
        catch (EmployeeException e) {
            System.out.println("Exception caught");
            System.out.println(e);
        }
    }
}

