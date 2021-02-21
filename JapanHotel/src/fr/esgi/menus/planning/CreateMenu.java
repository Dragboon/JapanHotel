package fr.esgi.menus.planning;

import fr.esgi.filewriters.PlanningWriter;
import fr.esgi.menus.InputMenu;
import fr.esgi.menus.Utils;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CreateMenu {

    public static final String NOCHOICE = "-1";

    public static void planningCreation(Scanner scanner) {

        String employee;
        String day;
        String[] workingTime = new String[2];
        PlanningWriter planningWriter = new PlanningWriter();

        System.out.println("\n\nVeuillez choisir un employé : \n");
        try {
            employee = Utils.selectEmployeeMenu(scanner);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return;
        }

        if ((day = selectDayMenu(scanner)).equals("Back")) {
            return;
        }
        workingTime = selectWorkingTime(scanner);

        if (workingTime == null) {
            return;
        }
        planningWriter.newPlanning(employee, day, workingTime);

        return;
    }

    private static String selectDayMenu(Scanner scanner) {
        String[] choices = new String[]{"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche", "Retour"};
        int choice;

        System.out.println("\n\nVeuillez choisir un jour de la semaine :\n");
        choice = InputMenu.display(scanner, choices);
        if (choice == 8) {
            return "Back";
        }
        return choices[choice - 1];
    }

    private static String[] selectWorkingTime(Scanner scanner) {

        String[] time;
        String[] result = new String[2];
        String input;

        System.out.println("Veuillez entrer l'heure de début (sous le format 00:00) :");

        do {
            try {
                input = scanner.next("[0-2][0-9]:[0-5][0-9]");
                time = input.split(":");

                result[0] = input.substring(0, 5);

            } catch (InputMismatchException e) {
                scanner.next();
                input = "redo";
                System.out.println("\nVeuillez entrer une heure de début valide (sous le format 00:00) :");
            }
        } while (input.equals("redo"));

        System.out.println("Veuillez entrer l'heure de fin (sous le format 00:00) :");

        do {
            try {
                input = scanner.next("[0-2][0-9]:[0-5][0-9]");
                time = input.split(":");

                result[1] = input.substring(0, 5);

            } catch (InputMismatchException e) {
                scanner.next();
                input = "redo";
                System.out.println("\nVeuillez entrer une heure de fin valide (sous le format 00:00) :");
            }
        } while (input.equals("redo"));

        System.out.println("\n\nPlanning créé.");

        return result;
    }
}
