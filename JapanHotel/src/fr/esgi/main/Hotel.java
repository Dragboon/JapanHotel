package fr.esgi.main;

import fr.esgi.employee.Employee;
import fr.esgi.menus.PlanningMenu;
import fr.esgi.room.Rooms;

import java.util.Scanner;

public class Hotel {
    //private Rooms rooms = new Rooms();
    //private Employee[] employees; //= getEmployeeList();

    Scanner scanner;
    String input;
    PlanningMenu planningMenu = new PlanningMenu();

    public void homepage() {

        do {
            System.out.println("1. Gestion des employés\n" +
                    "2. Gestion des plannings\n" +
                    "3. Restaurant\n" +
                    "4. Chambres"
            );
            scanner = new Scanner(System.in);
            input = scanner.nextLine();


            switch (input) {
                case "1" :

                    break;
                case "2" :
                    input = planningMenu.planningMenu();
                    break;
                case "3" :

                    break;
                case "4" :

                    break;
                default :
                    input = "-1";
            }
        } while (input.equals("-1"));
    }

}
