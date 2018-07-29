package Adapter;

import java.util.ArrayList;
import java.util.List;

public class EmployeeClient {

    public List<Employee> getEmployeeList(){

        List<Employee> employees = new ArrayList<>();

        Employee employeeFromDB = new EmployeeDB("123", "John", "Wick", "jw@continental.co");
        employees.add(employeeFromDB);


        //Employee employeeFromLdap = new EmployeeLdap("123", "John", "Wick", "jw@continental.co");
        EmployeeLdap employeeFromLdap = new EmployeeLdap("chewie", "solo", "han", "han@sw.co");
        employees.add(new EmpployeeAdapterLdap(employeeFromLdap));


        EmployeeCSV employeeCSV = new EmployeeCSV("546,mulan,han,girl@china.co");
        employees.add(new EmpployeeAdapterCVS(employeeCSV));


        return employees;

    }


}
