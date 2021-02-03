package fr.esgi.filereaders;

import fr.esgi.employee.Employee;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EmployeeReader {

    File file = new File(System.getProperty("user.dir") + File.separator + "data" + File.separator + "employee.txt");
    Scanner scanner;
    String fileLine;
    String[] data;


    public boolean exists(Employee employee) {

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

    public String[] getEmployeeNames() throws FileNotFoundException {

        List<String> names = new ArrayList<String>();


        scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            fileLine = scanner.nextLine();

            data = fileLine.split("//");

            names.add(data[1]);
        }

        return names.toArray(new String[names.size()]);
    }

    public String[] getEmployeeInformations(String name) {

        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                fileLine = scanner.nextLine();

                data = fileLine.split("//");

                if (data[1].equals(name)) {
                    return data;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        return data;
    }

    public int getEmployeeIndex(String name) {

        int counter = 0;

        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                fileLine = scanner.nextLine();

                data = fileLine.split("//");

                if (data[1].equals(name)) {
                    return counter;
                }
                counter++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return counter;
    }

    public List<String> readEmployeesFile() {

        int counter = 0;
        List<String> reader = new ArrayList<String>();

        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                fileLine = scanner.nextLine();

                reader.add(fileLine);

                counter++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return reader;
    }
}