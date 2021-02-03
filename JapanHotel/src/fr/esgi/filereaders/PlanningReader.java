package fr.esgi.filereaders;

import fr.esgi.exceptions.EmptyFileException;

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

    public List<String> readPlanning(String employeeName) throws FileNotFoundException, EmptyFileException {

        file = new File(System.getProperty("user.dir") + File.separator + "data" + File.separator + "plannings" + File.separator + employeeName + ".txt");
        List<String> planning = new ArrayList<>();

        if (!file.exists()) {
            throw new FileNotFoundException("Le fichier du planning de l'employé est introuvable.\n\n");
        }

        scanner = new Scanner(file);

        while (scanner.hasNextLine()) {

            planning.add(scanner.nextLine());
        }

        if(planning.isEmpty()){
            throw new EmptyFileException("L'employé sélectionné n'a pas de planning.\n\n");
        }

        return planning;

    }

}
