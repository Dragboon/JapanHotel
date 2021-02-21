package fr.esgi.menus.employee;

import fr.esgi.filereaders.EmployeeReader;
import fr.esgi.filewriters.EmployeeWriter;
import fr.esgi.menus.Utils;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RemoveMenu {

    public static void removeEmployee(Scanner scanner){

        String employee;
        EmployeeReader employeeReader = new EmployeeReader();
        EmployeeWriter employeeWriter = new EmployeeWriter();
        List<String> employeeList = new ArrayList<String>();
        int index;

        try {
            System.out.println("\n\nVeuillez choisir l'employé dont les informations doivent être effacées :\n");
            employee = Utils.selectEmployeeMenu(scanner);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return;
        }
        index = employeeReader.getEmployeeIndex(employee);
        employeeList = employeeReader.readEmployeesFile();

        employeeWriter.deleteEmployee(employeeList, index, employee);
        System.out.println("\nLes informations de l'employé ont bien été supprimées.");

    }


}
