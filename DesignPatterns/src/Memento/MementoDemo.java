package Memento;

public class MementoDemo {

    public static void main(String[] args){
        Caretaker caretaker = new Caretaker();

        Employee emp = new Employee();

        emp.setName("John Wick");
        emp.setAddress("111 blah st");
        emp.setPhone("111-111-2222");

        System.out.println("Employee before save: " + emp);
        caretaker.save(emp);

        emp.setPhone("444-555-6666");

        caretaker.save(emp);

        System.out.println("Employee after changed phone number save: " + emp);

        //didn't save
        emp.setPhone("333-999-0000");

        caretaker.revert(emp);

        System.out.println("Revert to last save point: " + emp);

        caretaker.revert(emp);

        System.out.println("Revert to original: " + emp);

    }

}
