package fr.esgi.menus.employee;

import fr.esgi.menus.InputMenu;

import java.util.Scanner;

public class EmployeeMenu extends InputMenu {

    public void firstPageMenu(Scanner scanner) {
        int choice;

        do {
            System.out.println("\n\nGestionnaire des employés\n");
            choice = InputMenu.display(scanner,new String[] {"Ajouter un employé",
                    "Informations sur un employé",
                    "Suppression des données d'un employé",
                    "Retour"});
            switch (choice) {
                case 1 :
                    CreateMenu.createEmployee(scanner);
                    break;
                case 2 :
                    GetMenu.printInformations(scanner);
                    break;
                case 3 :
                    RemoveMenu.removeEmployee(scanner);
                    break;
                case 4 :
                    return;
            }
        } while (choice != 4);
    }

}
