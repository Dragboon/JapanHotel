package fr.esgi.menus.employee;

import fr.esgi.employee.*;
import fr.esgi.exceptions.EmployeeAlreadyExists;
import fr.esgi.filewriters.EmployeeWriter;
import fr.esgi.menus.InputMenu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CreateMenu {

    public static void createEmployee(Scanner scanner) {
        String[] choices = {"Réception", "Chef", "Service de nettoyage", "Room service", "Serveur", "RH / Comptable", "Retour"};
        int choice;
        List<String> attributes;
        SpecialAttributes specAtt = new SpecialAttributes();

        System.out.println("\n\nAjout d'un employé\n");
        choice = InputMenu.display(scanner, choices);
        attributes = jobAttributes(scanner);
        EmployeeWriter employeeWriter = new EmployeeWriter();

        try {
            switch (choice) {
                case 1 :
                    attributes.add("Reception");
                    attributes = specAtt.languagesAttribute(scanner, attributes);
                    employeeWriter.writeEmployee(new Reception(attributes));
                    break;
                case 2 :
                    attributes.add("Chef");
                    attributes = specAtt.michelinAttributes(scanner, attributes);
                    attributes = specAtt.themesAttribute(scanner, attributes);
                    employeeWriter.writeEmployee(new Chef(attributes));
                    break;
                case 3 :
                    attributes.add("CleanService");
                    attributes = specAtt.placesAttribute(scanner,attributes);
                    employeeWriter.writeEmployee(new CleanService(attributes));
                    break;
                case 4 :
                    attributes.add("RoomService");
                    attributes = specAtt.roomServicesAttribute(scanner, attributes);
                    employeeWriter.writeEmployee(new RoomService(attributes));
                    break;
                case 5 :
                    attributes.add("Waiter");
                    attributes = specAtt.languagesAttribute(scanner, attributes);
                    attributes = specAtt.restaurantServicesAttribute(scanner, attributes);
                    employeeWriter.writeEmployee(new Waiter(attributes));
                    break;
                case 6 :
                    attributes.add("AccountingHR");
                    attributes = specAtt.languagesAttribute(scanner, attributes);
                    employeeWriter.writeEmployee(new AccountingHR(attributes));
                    break;
            }
        } catch (EmployeeAlreadyExists | IOException e) {
            System.out.println(e.getMessage());
        }

        if (choice == 7) {
            return;
        }
        System.out.println("\nL'employé a bien été ajouté.");
    }

    private static List<String> jobAttributes(Scanner scanner) {
        String name;
        String cosplay;
        String beginDate;
        String salary;

        List<String> employeeAttributes = new ArrayList<String>();

        name = getEmployeeName(scanner);
        employeeAttributes.add(name);

        cosplay = getCosplay(scanner);
        employeeAttributes.add(cosplay);

        beginDate = getBeginDate(scanner);
        employeeAttributes.add(beginDate);

        salary = getEmployeeSalary(scanner);
        employeeAttributes.add(salary);

        return employeeAttributes;
    }

    private static String getEmployeeName(Scanner scanner){
        String name;

        System.out.println("\n\nVeuillez entrer le nom de l'employé :\n");
        do {
            try {
                name = scanner.next("[^/][^/]+");
                return name;
            } catch (InputMismatchException e){
                System.out.println("\n\nVeuillez entrer le nom valide de l'employé :\n");
                scanner.next();
            }
        } while (true);
    }

    private static String getCosplay(Scanner scanner){
        String cosplay;

        System.out.println("\n\nVeuillez entrer un cosplay :\n");
        do {
            try {
                cosplay = scanner.next("[^/][^/]+");
                return cosplay;
            } catch (InputMismatchException e) {
                System.out.println("\n\nVeuillez entrer un nom de cosplay valide :\n");
                scanner.next();
            }
        } while (true);
    }

    private static String getBeginDate(Scanner scanner) {
        String date;
        System.out.println("\n\nVeuillez entrer une date de commencement (sous le format jj/mm/aaaa) :\n");
        do {
            try {
                date = scanner.next("[0-3][0-9]/[0-1][0-9]/20[0-2][0-9]");
                return date;
            } catch (InputMismatchException e) {
                System.out.println("\n\nVeuillez entrer une date de commencement valide (sous le format jj/mm/aaaa) :\n");
                scanner.next();
            }
        } while (true);
    }

    private static String getEmployeeSalary(Scanner scanner) {
        String salary;
        System.out.println("\n\nVeuillez entrer un salaire (sous le format 100,00) :\n");
        do {
            try {
                salary = scanner.next("[0-9]+,[0-9]+");
                return salary;
            } catch (InputMismatchException e) {
                System.out.println("\n\nVeuillez entrer un salaire valide (sous le format 100,00) :\n");
                scanner.next();
            }
        } while (true);
    }
}