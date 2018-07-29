package Adapter;

import java.util.List;

public class AdapterDemo {

    public static void main(String[] args){

        EmployeeClient client = new EmployeeClient();

        //hides from user. the getEmployeeList is adapting to multiple variations to getting employees
        //usually used for enhancing legacy code while making sure it still runs
        List<Employee> employees = client.getEmployeeList();

        for(Employee e : employees) {
            System.out.println(e);
        }

    }

}
