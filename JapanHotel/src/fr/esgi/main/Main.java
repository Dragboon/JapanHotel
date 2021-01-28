package fr.esgi.main;

import fr.esgi.employee.Waiter;
import fr.esgi.employee.Employee;

public class Main {

    public static void main(String[] args) {
        String[] l = {"Fr","En"};
        Waiter w = new Waiter("e", 43.2, "rem", null, null, l, null);

        w.newEmployee();
    }


}
