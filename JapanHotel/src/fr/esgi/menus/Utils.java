package fr.esgi.menus;

import fr.esgi.filereaders.EmployeeReader;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Utils {

    public static String selectEmployeeMenu(Scanner scanner) {

        int choice;

        EmployeeReader employeeReader = new EmployeeReader();
        String[] employeeNameArray;

        try {
            employeeNameArray = employeeReader.getEmployeeNames();
        } catch (FileNotFoundException e) {
            System.out.println("Vous n'avez pas d'employé.");
            return "-1"; //Faire exception ou return -1
        }

        choice = InputMenu.display(scanner, employeeNameArray);

        return employeeNameArray[choice - 1];
    }

}
