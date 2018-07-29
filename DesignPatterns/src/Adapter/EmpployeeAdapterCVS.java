package Adapter;

public class EmpployeeAdapterCVS implements Employee {

    private EmployeeCSV instance;

    public EmpployeeAdapterCVS(EmployeeCSV employeeCSV) {
        instance = employeeCSV;
    }


    @Override
    public String getId() {
        return Integer.toString(instance.getId());
    }

    @Override
    public String getFirstName() {
        return instance.getFirstname();
    }

    @Override
    public String getLastName() {
        return instance.getLastname();
    }

    @Override
    public String getEmail() {
        return instance.getEmailAddress();
    }

    @Override
    public String toString() {
        return "[id: " + instance.getId() + ", firstName: " + instance.getFirstname() + ", lastName: " + instance.getLastname() + ", email: " + instance.getEmailAddress() + "]";
    }


}
