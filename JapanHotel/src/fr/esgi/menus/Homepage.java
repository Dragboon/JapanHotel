package fr.esgi.menus;

import fr.esgi.menus.employee.EmployeeMenu;
import fr.esgi.menus.planning.PlanningMenu;

import java.util.Scanner;

public class Homepage extends InputMenu {

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        InputMenu display;
        int choice;


        String[] choices = new String[] {"Gestion des employés",
                "Gestion des plannings", "Quitter"};


        do {
            System.out.println("\n\nBienvenue sur le programme des gestion de JapanHotel\n");
            choice = InputMenu.display(scanner, choices);
            switch (choice) {
                case 1:
                    display = new EmployeeMenu();
                    display.firstPageMenu(scanner);
                    break;
                case 2:
                    display = new PlanningMenu();
                    display.firstPageMenu(scanner);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Veuillez entrer un nombre valide.");
            }
        } while (choice != 3);
    }
}
