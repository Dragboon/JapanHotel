package fr.esgi.employee;

import java.util.ArrayList;
import java.util.List;

public class CleanService extends Employee {

    private String places;

    public CleanService(String name, String salary, String cosplay, String date, String places) {
        super(name, salary, cosplay, date);
        this.places = places;
    }

    public CleanService(List<String> attributes) {
        super(attributes);
        this.places = attributes.get(5);
    }

    @Override
    public String toString() {
        return super.toString() + places + "\n";
    }

}
