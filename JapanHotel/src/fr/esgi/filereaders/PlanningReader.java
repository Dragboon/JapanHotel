package fr.esgi.filereaders;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlanningReader {

    File file;
    Scanner scanner;
    String fileLine;
    String[] data;

    public boolean checkPlanning(String employeeName, String day) {

        file = new File(System.getProperty("user.dir") + File.separator + "data" + File.separator + "plannings" + File.separator + employeeName + ".txt");

        try {
            scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                fileLine = scanner.nextLine();

                data = fileLine.split("//");

                if (day.equals(data[0])) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<String> readPlanning(String employeeName) {

        file = new File(System.getProperty("user.dir") + File.separator + "data" + File.separator + "plannings" + File.separator + employeeName + ".txt");
        List<String> planning = new ArrayList<>();

        if (!file.exists()) {
            System.out.println("Le planning est introuvable.");
            return null;
        }

        try {
            scanner = new Scanner(file);

            while (scanner.hasNextLine()) {

                planning.add(scanner.nextLine());
            }
            return planning;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Le planning est introuvable.");
        return null;
    }

}
