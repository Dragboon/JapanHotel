package fr.esgi.filewriters;

import fr.esgi.employee.Employee;
import fr.esgi.exceptions.EmployeeAlreadyExists;
import fr.esgi.filereaders.EmployeeReader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class EmployeeWriter {

    private FileWriter employeeWriter;
    private File employeeFile;

    public void writeEmployee(Object employee) throws IOException, EmployeeAlreadyExists {

        String objectData;
        employeeFile = new File(System.getProperty("user.dir") + File.separator + "data" + File.separator + "employee.txt");
        EmployeeReader employeeReader = new EmployeeReader();

        if (employee instanceof Employee) {

            DirectoryCreation.checkDirectory(System.getProperty("user.dir") + File.separator + "data");
            FileCreation.checkFile(employeeFile.getPath());

            if (employeeReader.exists((Employee) employee) == true) {
                throw new EmployeeAlreadyExists("L'employé existe déjà.\n");
            }
            employeeWriter = new FileWriter(employeeFile, true);

            objectData = employee.getClass().getSimpleName() + "//";
            objectData += employee.toString();

            employeeWriter.append(objectData);
            employeeWriter.flush();
            employeeWriter.close();

        }
    }

    public void deleteEmployee(List<String> employees, int index, String name) {

        String newEmployees = "";
        File employeeFile = new File(System.getProperty("user.dir") + File.separator + "data" + File.separator + "employee.txt");

        employees.remove(index);

        try {
            employeeWriter = new FileWriter(employeeFile);

            for (int counter = 0; counter < employees.size(); counter++) {
                newEmployees += employees.get(counter) + "\n";
            }

            employeeWriter.write(newEmployees);
            employeeWriter.flush();
            employeeWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
