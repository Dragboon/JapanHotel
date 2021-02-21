package fr.esgi.employee;

import java.util.List;

public abstract class Employee {

    private String name;
    private String salary;
    private String cosplay;
    private String date;

    public Employee(String name, String salary, String cosplay, String date) {
        this.name = name;
        this.salary = salary;
        this.cosplay = cosplay;
        this.date = date;
    }

    public Employee(List<String> attributes) {
        this.name = attributes.get(0);
        this.cosplay = attributes.get(1);
        this.date = attributes.get(2);
        this.salary = attributes.get(3);
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name + "//" + salary + "//" + cosplay + "//" + date + "//";
    }
}
