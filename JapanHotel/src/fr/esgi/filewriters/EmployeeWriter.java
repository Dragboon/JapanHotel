package fr.esgi.filewriters;

import fr.esgi.employee.Employee;
import fr.esgi.employee.Waiter;

import java.io.File;
import java.io.FileWriter;

public class EmployeeWriter {
    File employeeFile = new File(System.getProperty("user.dir") + File.separator + "data" + File.separator + "employee.txt");
    //FileWriter employeeWriter = new FileWriter();

    public static void writeEmployee(Object o) {

        String className;
        if (o instanceof Employee) {
            className = o.getClass().getSimpleName() + "//";
            className += o.toString();

            System.out.println(className);
            // Waiter//

        }




    }
}
