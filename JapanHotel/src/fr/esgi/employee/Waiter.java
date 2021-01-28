package fr.esgi.employee;

import fr.esgi.filewriters.EmployeeWriter;
import fr.esgi.planning.WeekPlanning;

import java.util.Arrays;
import java.util.Date;

public class Waiter extends Employee {

    private String[] languages;
    private String[] servicesRestaurants;

    public Waiter(String name, Double salary, String cosplay, Date date, WeekPlanning weekPlanning, String[] languages, String[] servicesRestaurants) {
        super(name, salary, cosplay, date, weekPlanning);
        this.languages = languages;
        this.servicesRestaurants = servicesRestaurants;
    }

    @Override
    public void newEmployee() {
        EmployeeWriter.writeEmployee(this);
    }

    @Override
    public String toString() {
        return super.toString() + Arrays.toString(languages) + "//" + Arrays.toString(servicesRestaurants) + "\n";
    }
}
