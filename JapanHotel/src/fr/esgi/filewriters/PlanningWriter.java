package fr.esgi.filewriters;

import fr.esgi.filereaders.PlanningReader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class PlanningWriter {

    private File planningFile;
    private FileWriter planningWriter;

    public void newPlanning(String name, String day, String[] workingTime) {

        String objectData;
        planningFile = new File(System.getProperty("user.dir") + File.separator + "data" + File.separator + "plannings" + File.separator + name + ".txt");
        PlanningReader planningReader = new PlanningReader();

        DirectoryCreation.checkDirectory(System.getProperty("user.dir") + File.separator + "data");
        DirectoryCreation.checkDirectory(System.getProperty("user.dir") + File.separator + "data" + File.separator + "plannings");
        FileCreation.checkFile(planningFile.getPath());

        if (planningReader.checkPlanning(name, day) == true) {
            System.out.println("Le planning pour ce jour existe déjà.");
            return;
        }

        try {
            planningWriter = new FileWriter(planningFile, true);

            objectData = day + "//" + workingTime[0] + "//" + workingTime[1] + "\n";

            planningWriter.append(objectData);
            planningWriter.flush();
            planningWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deletePlanning(List<String> plannings, int index, String name) {

        String newPlannings = "";
        planningFile = new File(System.getProperty("user.dir") + File.separator + "data" + File.separator + "plannings" + File.separator + name + ".txt");

        plannings.remove(index);

        try {
            planningWriter = new FileWriter(planningFile);

            for (int counter = 0; counter < plannings.size(); counter++) {
                newPlannings += plannings.get(counter) + "\n";
            }

            planningWriter.write(newPlannings);
            planningWriter.flush();
            planningWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
