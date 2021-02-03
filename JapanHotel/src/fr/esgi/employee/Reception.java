package fr.esgi.employee;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Reception extends Employee {


    private String languages;

    public Reception(String name, String salary, String cosplay, String date, String languages) {
        super(name, salary, cosplay, date);
        this.languages = languages;
    }

    public Reception(List<String> attributes) {
        super(attributes);
        this.languages = attributes.get(5);
    }

    @Override
    public String toString() {
        return super.toString() + languages + "\n";
    }
}
