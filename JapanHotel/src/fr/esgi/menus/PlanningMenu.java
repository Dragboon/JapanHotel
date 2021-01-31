package fr.esgi.menus;

import fr.esgi.filereaders.EmployeeReader;
import fr.esgi.filereaders.PlanningReader;
import fr.esgi.filewriters.PlanningWriter;

import java.util.List;
import java.util.Scanner;

public class PlanningMenu {

    Scanner scanner;
    String input;

    public String planningMenu() {

        do {
            System.out.println("1. Créer un planning\n" +
                    "2. Consulter un planning\n" +
                    "3. Supprimer un planning\n" +
                    "4. Retour"
            );
            scanner = new Scanner(System.in);
            input = scanner.nextLine();

            switch (input) {
                case "1":
                    input = planningCreation();
                    break;
                case "2":
                    input = getPlanning();
                    break;
                case "3":
                    input = removePlanning();
                    break;
                case "4":
                    return "-1";
                default:
                    System.out.println("Veuillez entrer un nombre valide.");
                    input = "-1";
            }
        } while (input.equals("-1"));

        return "-1";

    }

    private String planningCreation() {

        String employee;
        String day;
        String[] workingTime = new String[2];
        PlanningWriter planningWriter = new PlanningWriter();

        if ((employee = selectEmployeeMenu()).equals("-1")) {
            return "-1";
        }

        if ((day = selectDayMenu()).equals("-1")) {
            return "-1";
        }

        workingTime = selectWorkingTime();

        if (workingTime == null) {
            return "-1";
        }

        planningWriter.newPlanning(employee, day, workingTime);

        return "-1";

    }

    private String getPlanning() {
        String employee;
        PlanningReader planningReader = new PlanningReader();
        List<String> planningOutput;
        String[] plannings;

        if ((employee = selectEmployeeMenu()).equals("-1")) {
            return "-1";
        }

        planningOutput = planningReader.readPlanning(employee);

        if (planningOutput == null) {
            return "-1";
        }


        System.out.println("Voici le planning de " + employee + " :\n");

        for (int counter = 0; counter < planningOutput.size(); counter++) {
            plannings = planningOutput.get(counter).split("//");
            System.out.println(plannings[0] + " de " + plannings[1] + " à " + plannings[2]);
        }
        return "-1";
    }

    private String removePlanning() {
        String employee;
        PlanningReader planningReader = new PlanningReader();
        List<String> planningOutput;
        PlanningWriter planningWriter = new PlanningWriter();
        String[] plannings;

        if ((employee = selectEmployeeMenu()).equals("-1")) {
            return "-1";
        }

        planningOutput = planningReader.readPlanning(employee);

        if (planningOutput == null) {
            return "-1";
        }
        do {
            for (int counter = 0; counter < planningOutput.size(); counter++) {
                plannings = planningOutput.get(counter).split("//");
                System.out.println(counter + 1 + ". " + plannings[0] + " de " + plannings[1] + " à " + plannings[2]);
            }

            System.out.println("\nQuel jour voulez-vous supprimer ?");
            scanner = new Scanner(System.in);
            input = scanner.nextLine();

            if (Integer.parseInt(input) < 1 || Integer.parseInt(input) > planningOutput.size()) {
                input = "-1";
                System.out.println("test");
            } else {
                planningWriter.deletePlanning(planningOutput, Integer.parseInt(input) - 1, employee);
                System.out.println("Suppression effectuée.");
            }

        } while (input == "-1");

        return "-1";
    }

    private String selectEmployeeMenu() {
        EmployeeReader employeeReader = new EmployeeReader();
        List<String> employeeNameList = employeeReader.getEmployeeNames();
        String employeeNameOutput = "";
        int counter;

        if (employeeNameList == null) {
            System.out.println("Vous n'avez pas d'employé.");
            return "-1";
        }

        for (counter = 1; counter - 1 < employeeNameList.size(); counter++) {
            employeeNameOutput += counter + ". " + employeeNameList.get(counter - 1) + "\n";
        }

        do {
            System.out.println("Veuillez sélectionner un employé :");
            System.out.println(employeeNameOutput);
            scanner = new Scanner(System.in);
            input = scanner.nextLine();

            if (Integer.parseInt(input) < 1 || Integer.parseInt(input) >= counter) {
                System.out.println("Veuillez entrer un nombre valide.");
                input = "-1";
            } else {
                return employeeNameList.get(Integer.parseInt(input) - 1);
            }
        } while (input.equals("-1"));

        System.out.println("Il y a eu une erreur, veuillez contacter le dev.");
        return "-1";
    }

    private String selectDayMenu() {
        String[] days = {"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"};
        int dayIndex;

        do {
            System.out.println("Veuillez choisir un jour de la semaine :\n" +
                    "1. Lundi\n2. Mardi\n3. Mercredi\n4. Jeudi\n5. Vendredi\n6. Samedi\n7. Dimanche\n8. Retour");
            scanner = new Scanner(System.in);
            input = scanner.nextLine();

            if (Integer.parseInt(input) == 8) {
                return "-1";
            }

            if (Integer.parseInt(input) < 1 || Integer.parseInt(input) > 7) {
                System.out.println("Veuillez entrer un nombre valide.");
                input = "-1";
            } else {
                return days[Integer.parseInt(input) - 1];
            }
        } while (input.equals("-1"));

        System.out.println("Il y a eu une erreur, veuillez contacter le dev.");
        return "-1";
    }

    private String[] selectWorkingTime() {

        String[] time;
        String[] result = new String[2];

        do {
            System.out.println("Veuillez entrer l'heure de début (sous le format 00:00) :\n");
            scanner = new Scanner(System.in);
            input = scanner.nextLine();

            if (!input.substring(2, 3).equals(":")) {
                input = "-1";
                continue;
            }
            time = input.substring(0, 5).split(":");
            if (Integer.parseInt(time[0]) > 23 || Integer.parseInt(time[0]) < 0 || Integer.parseInt(time[1]) < 0 || Integer.parseInt(time[1]) > 59) {
                input = "-1";
            } else {
                result[0] = input.substring(0, 5);
            }
        } while (input.equals("-1"));

        do {
            System.out.println("Veuillez entrer l'heure de fin (sous le format 00:00) :\n");
            scanner = new Scanner(System.in);
            input = scanner.nextLine();
            time = input.substring(0, 5).split(":");
            if (Integer.parseInt(time[0]) > 23 || Integer.parseInt(time[0]) < 0 || Integer.parseInt(time[1]) < 0 || Integer.parseInt(time[1]) > 59) {
                input = "-1";
            } else {
                result[1] = input.substring(0, 5);
                return result;
            }
        } while (input.equals("-1"));

        System.out.println("Il y a eu une erreur, veuillez contacter le dev.");
        return null;
    }
}
