package Adapter;

public class EmployeeDB implements Employee {

    private String id;
    private String firstName;
    private String lastName;
    private String email;

    public EmployeeDB(String id, String fn, String ln, String email){
        this.id = id;
        this.firstName = fn;
        this.lastName = ln;
        this.email = email;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "[id: " + id + ", firstName: " + firstName + ", lastName: " + lastName + ", email: " + email + "]";
    }
}
