package fr.esgi.employee;

import java.util.List;

public class Chef extends Employee {

    private String michelinStar;
    private String theme;


    public Chef(String name, String salary, String cosplay, String date, String michelinStar, String theme) {
        super(name, salary, cosplay, date);
        this.michelinStar = michelinStar;
        this.theme = theme;
    }

    public Chef(List<String> attributes) {
        super(attributes);
        this.michelinStar = attributes.get(5);
        this.theme = attributes.get(6);
    }

    @Override
    public String toString() {
        return super.toString() + michelinStar + "//" + theme + "\n";
    }

}
