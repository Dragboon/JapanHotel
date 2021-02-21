package fr.esgi.menus.planning;

import fr.esgi.exceptions.EmptyFileException;
import fr.esgi.filereaders.PlanningReader;
import fr.esgi.menus.InputMenu;
import fr.esgi.menus.Utils;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class PlanningMenu extends InputMenu {

    public void firstPageMenu(Scanner scanner) {
        int choice;

        do {
            System.out.println("\n\nGestionnaire des plannings\n");
            choice = InputMenu.display(scanner,new String[] {"Créer un planning",
                                                                "Consulter un planning",
                                                                "Supprimer un planning",
                                                                "Retour"});
            switch (choice) {
                case 1 :
                    CreateMenu.planningCreation(scanner);
                    break;
                case 2 :
                    getPlanning(scanner);
                    break;
                case 3 :
                    RemoveMenu.removePlanning(scanner);
                    break;
                case 4 :
                    return;
            }
        } while (choice != 4);
    }

    private void getPlanning(Scanner scanner) {
        String employee;
        PlanningReader planningReader = new PlanningReader();
        List<String> planningOutput;
        String[] plannings;

        System.out.println("\n\nVeuillez choisir un employé : \n");

        try {
            employee = Utils.selectEmployeeMenu(scanner);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return;
        }

        try {
            planningOutput = planningReader.readPlanning(employee);

            System.out.println("\n\nVoici le planning de " + employee + " :\n");

            for (int counter = 0; counter < planningOutput.size(); counter++) {
                plannings = planningOutput.get(counter).split("//");
                System.out.println(plannings[0] + " de " + plannings[1] + " à " + plannings[2]);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (EmptyFileException e) {
            System.out.println(e.getMessage());
        }
    }


}
