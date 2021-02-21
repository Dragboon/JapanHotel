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
    private final static String USERDIR = "user.dir";
    private final static String DATAFOLDER = System.getProperty(USERDIR) + File.separator + "data";
    private final static String EMPLOYEEFILE = DATAFOLDER + File.separator + "employee.txt";

    public void writeEmployee(Object employee) throws IOException, EmployeeAlreadyExists {

        String objectData;
        employeeFile = new File(EMPLOYEEFILE);
        EmployeeReader employeeReader = new EmployeeReader();

        if (employee instanceof Employee) {

            DirectoryCreation.checkDirectory(DATAFOLDER);
            FileCreation.checkFile(employeeFile.getPath());

            if (employeeReader.exists((Employee) employee)) {
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
        File employeeFile = new File(EMPLOYEEFILE);
        PlanningWriter planningWriter = new PlanningWriter();

        employees.remove(index);

        try {
            employeeWriter = new FileWriter(employeeFile);

            for (int counter = 0; counter < employees.size(); counter++) {
                newEmployees += employees.get(counter) + "\n";
            }

            employeeWriter.write(newEmployees);
            employeeWriter.flush();
            employeeWriter.close();
            planningWriter.deletePlanningFile(name);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
