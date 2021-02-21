package fr.esgi.menus.employee;

import fr.esgi.filereaders.EmployeeReader;
import fr.esgi.menus.Utils;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class GetMenu {

    public static void printInformations(Scanner scanner) {

        String name;
        String[] employeeData;
        EmployeeReader employeeReader = new EmployeeReader();

        try {
            name = Utils.selectEmployeeMenu(scanner);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return;
        }

        employeeData = employeeReader.getEmployeeInformations(name);

        System.out.println("\n\nFiche de : " + employeeData[1] +
                "\nSalaire : " + employeeData[2] + " €" +
                "\nCosplay : " + employeeData[3] +
                "\nDate d'arrivée : " + employeeData[4]);

        switch (employeeData[0]) {
            case "Waiter":
                System.out.println("Langues parlées : " + employeeData[5] +
                        "\nTâches effectuées : " + employeeData[6] + "\n");
                break;
            case "Reception":
            case "AccountingHR":
                System.out.println("Langues parlées : " + employeeData[5] + "\n");
                break;
            case "Chef":
                System.out.println("Nombre d'étoiles michelin : " + employeeData[5] +
                        "\nThèmes de cuisine : " + employeeData[6] + "\n");
                break;
            case "CleanService":
                System.out.println("Lieu de travail : " + employeeData[5] + "\n");
                break;
            case "RoomService":
                System.out.println("Services effectués : " + employeeData[5] + "\n");
                break;
        }
    }


}
