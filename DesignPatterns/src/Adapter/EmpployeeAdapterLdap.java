package Adapter;

public class EmpployeeAdapterLdap implements Employee {

    private EmployeeLdap instance;

    public EmpployeeAdapterLdap(EmployeeLdap employeeFromLdap) {
        this.instance = employeeFromLdap;
    }

    @Override
    public String getId() {
        return instance.getCn();
    }

    @Override
    public String getFirstName() {
        return instance.getSurname();
    }

    @Override
    public String getLastName() {
        return instance.getGivenName();
    }

    @Override
    public String getEmail() {
        return instance.getMail();
    }

    @Override
    public String toString() {
        return "[id: " + instance.getCn() + ", firstName: " + instance.getSurname() + ", lastName: " + instance.getGivenName() + ", email: " + instance.getGivenName() + "]";
    }

}
