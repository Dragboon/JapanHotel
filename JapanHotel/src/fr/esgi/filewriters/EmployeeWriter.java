package fr.esgi.filewriters;

import fr.esgi.employee.Employee;
import fr.esgi.filereaders.EmployeeReader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EmployeeWriter {

    public static void writeEmployee(Object employee) {

        String objectData;
        File employeeFile = new File(System.getProperty("user.dir") + File.separator + "data" + File.separator + "employee.txt");
        FileWriter employeeWriter;
        EmployeeReader employeeReader = new EmployeeReader();

        if (employee instanceof Employee) {

            DirectoryCreation.checkDirectory(System.getProperty("user.dir") + File.separator + "data");
            FileCreation.checkFile(employeeFile.getPath());

            if (employeeReader.checkEmployee((Employee) employee) == true) {
                System.out.println("L'employé existe déjà.");
                return;
            }

            try {
                employeeWriter = new FileWriter(employeeFile, true);

                objectData = employee.getClass().getSimpleName() + "//";
                objectData += employee.toString();

                employeeWriter.append(objectData);
                employeeWriter.flush();
                employeeWriter.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
