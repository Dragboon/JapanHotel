package fr.esgi.menus.employee;

import fr.esgi.menus.InputMenu;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SpecialAttributes {

    public List<String> languagesAttribute(Scanner scanner, List<String> attributes) {

        int choice;
        String result = "[";
        String[] languages = new String[]{"Français", "Anglais", "Allemand", "Italien", "Espagnol", "Japonais", "Chinois", "Terminer"};
        System.out.println("\n\nQuelles sont les langues parlées (entrer Terminer quand vous avez fini) ?\n");
        do {
            choice = InputMenu.display(scanner, languages);
            if (!result.contains(languages[choice - 1]) && choice != 8) {
                result += languages[choice - 1] + ", ";
                System.out.println("\n\nLangue ajoutée. \n");
            } else if (result.length() < 2) {
                System.out.println("\n\nVeuillez entrer au moins une langue.\n");
                choice = 0;
            } else if (choice != 8) {
                System.out.println("\n\nLa langue a déjà été ajoutée.\n");
            }
        } while (choice != 8);

        result = result.substring(0, result.length() - 2);
        result += "]";
        attributes.add(result);

        return attributes;
    }

    public List<String> michelinAttributes(Scanner scanner, List<String> attributes) {

        int choice = 0;

        do {
            try {
                System.out.println("\n\nCombien d'étoiles possède le chef ?\n");
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.next();
                System.out.println("\n\nVeuillez entrer un nombre correcte.\n");
            }
        } while (choice < 0 || choice > 5);

        attributes.add(String.valueOf(choice));
        return attributes;
    }

    public List<String> themesAttribute(Scanner scanner, List<String> attributes) {

        int choice;
        String result = "[";
        String[] themes = new String[]{"Japon", "Animés", "Jeux-vidéo", "Chine", "Autre", "Terminer"};

        System.out.println("\n\nQuels sont les thèmes proposés par le chef (entrer Terminer quand vous avez fini) ?\n");

        do {
            choice = InputMenu.display(scanner, themes);
            if (!result.contains(themes[choice - 1]) && choice != 6) {
                result += themes[choice - 1] + ", ";
                System.out.println("\n\nThème ajouté.\n");
            } else if (result.length() < 2) {
                System.out.println("\n\nVeuillez entrer au moins une tâche.\n");
                choice = 0;
            } else if(choice != 6) {
                System.out.println("\n\nLe thème a déjà été ajoutée.\n");
            }
        } while (choice != 6);

        result = result.substring(0, result.length() - 2);
        result += "]";
        attributes.add(result);

        return attributes;
    }

    public List<String> placesAttribute(Scanner scanner, List<String> attributes) {

        int choice;
        String result;

        System.out.println("\n\nQuel est le lieu de travail ?\n");
        String[] places = new String[]{"Buanderie", "Chambres", "Restaurant", "Autre"};

        choice = InputMenu.display(scanner, places);
        result = places[choice - 1];
        attributes.add(result);

        return attributes;
    }

    public List<String> roomServicesAttribute(Scanner scanner, List<String> attributes) {

        int choice;
        String result = "[";
        System.out.println("\n\nQuelles sont les tâches effectuées (entrer Terminer quand vous avez fini) ?\n");
        String[] themes = new String[]{"Service en chambre", "Massage", "Autre", "Terminer"};

        do {
            choice = InputMenu.display(scanner, themes);
            if (!result.contains(themes[choice - 1]) && choice != 4) {
                result += themes[choice - 1] + ", ";
                System.out.println("\n\nTâche ajoutée.\n");
            } else if (result.length() < 2) {
                System.out.println("\n\nVeuillez entrer au moins une tâche.\n");
                choice = 0;
            } else if (choice != 4) {
                System.out.println("\n\nLa tâche a déjà été ajoutée.\n");
            }
        } while (choice != 4);

        result = result.substring(0, result.length() - 2);
        result += "]";
        attributes.add(result);

        return attributes;
    }

    public List<String> restaurantServicesAttribute(Scanner scanner, List<String> attributes) {

        int choice;
        String result = "[";
        System.out.println("\n\nQuels sont les tâches effectuées (entrer Terminer quand vous avez fini) ?\n");
        String[] services = new String[]{"Service", "Chant", "Danse", "Photographie", "Autre", "Terminer"};

        do {
            choice = InputMenu.display(scanner, services);
            if (!result.contains(services[choice - 1])  && choice != 6) {
                result += services[choice - 1] + ", ";
                System.out.println("\n\nTâche ajoutée.\n");
            } else if (result.length() < 2) {
                System.out.println("\n\nVeuillez entrer au moins une tâche.\n");
                choice = 0;
            } else if (choice != 6) {
                System.out.println("\n\nLa tâche a déjà été ajoutée.\n");
            }
        } while (choice != 6);

        result = result.substring(0, result.length() - 2);
        result += "]";
        attributes.add(result);

        return attributes;
    }
}
