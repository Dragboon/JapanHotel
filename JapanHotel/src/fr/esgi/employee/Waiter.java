package fr.esgi.employee;

import java.util.*;

public class Waiter extends Employee {

    private String languages;
    private String servicesRestaurant;

    public Waiter(String name, String salary, String cosplay, String date, String languages, String servicesRestaurants) {
        super(name, salary, cosplay, date);
        this.languages = languages;
        this.servicesRestaurant = servicesRestaurants;
    }

    public Waiter(List<String> attributes) {
        super(attributes);
        languages = attributes.get(5);
        servicesRestaurant = attributes.get(6);
    }

    @Override
    public String toString() {
        return super.toString() + languages + "//" + servicesRestaurant + "\n";
    }
}
