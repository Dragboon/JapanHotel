package fr.esgi.employee;

import fr.esgi.planning.WeekPlanning;

import java.util.Date;

public class Reception extends Employee {


    private String[] languages;

    public Reception(String name, Double salary, String cosplay, Date date, WeekPlanning weekPlanning) {
        super(name, salary, cosplay, date, weekPlanning);
    }


    @Override
    public void newEmployee() {

    }
}
