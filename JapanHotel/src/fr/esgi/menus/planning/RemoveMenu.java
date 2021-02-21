package fr.esgi.menus.planning;

import fr.esgi.exceptions.EmptyFileException;
import fr.esgi.filereaders.PlanningReader;
import fr.esgi.filewriters.PlanningWriter;
import fr.esgi.menus.InputMenu;
import fr.esgi.menus.Utils;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class RemoveMenu {

    public static void removePlanning(Scanner scanner) {
        String employee;
        PlanningReader planningReader = new PlanningReader();
        List<String> planningOutput;
        PlanningWriter planningWriter = new PlanningWriter();
        String[] plannings;
        String[] display;
        int choice = 0;

        System.out.println("\n\nVeuillez choisir un employé : \n");

        try {
            employee = Utils.selectEmployeeMenu(scanner);
            planningOutput = planningReader.readPlanning(employee);

            System.out.println("\nQuel jour voulez-vous supprimer ?");
            display = new String[planningOutput.size() + 1];
            for (int counter = 0; counter < planningOutput.size(); counter++) {
                plannings = planningOutput.get(counter).split("//");
                display[counter] = plannings[0] + " de " + plannings[1] + " à " + plannings[2];
            }
            display[display.length - 1] = "Retour";
            choice = InputMenu.display(scanner, display);
            if (choice == display.length) {
                return;
            }
            planningWriter.deletePlanning(planningOutput, choice - 1, employee);
            System.out.println("Suppression effectuée.\n\n");

        } catch (FileNotFoundException | EmptyFileException e) {
            System.out.println(e.getMessage());
        }
    }
}
