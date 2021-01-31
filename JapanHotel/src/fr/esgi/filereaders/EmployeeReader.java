package fr.esgi.filereaders;

import fr.esgi.employee.Employee;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeReader {

    File file = new File(System.getProperty("user.dir") + File.separator + "data" + File.separator + "employee.txt");
    Scanner scanner;
    String fileLine;
    String[] data;


    public boolean checkEmployee(Employee employee) {

        try {
            scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                fileLine = scanner.nextLine();

                data = fileLine.split("//");

                if (employee.getName().equals(data[1])) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<String> getEmployeeNames() {

        List<String> names = new ArrayList<String>();

        try {
            scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                fileLine = scanner.nextLine();

                data = fileLine.split("//");

                names.add(data[1]);
            }

            return names;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

}
