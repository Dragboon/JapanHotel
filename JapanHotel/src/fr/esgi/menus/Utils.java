package fr.esgi.menus;

import fr.esgi.filereaders.EmployeeReader;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Utils {

    public static String selectEmployeeMenu(Scanner scanner) throws FileNotFoundException {

        int choice;

        EmployeeReader employeeReader = new EmployeeReader();
        String[] employeeNameArray;

        try {
            employeeNameArray = employeeReader.getEmployeeNames();
        } catch (FileNotFoundException e){
            throw new FileNotFoundException("Vous n'avez pas d'employé.");
        }

        choice = InputMenu.display(scanner, employeeNameArray);

        return employeeNameArray[choice - 1];
    }

}
