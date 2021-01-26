package fr.esgi.employee;

import fr.esgi.planning.WeekPlanning;

import java.util.Date;

public class Employee {

    private String name;
    private Double salary;
    private String cosplay;
    private Date date;
    private WeekPlanning weekPlanning;

    public Employee(String name, Double salary, String cosplay, Date date, WeekPlanning weekPlanning) {
        this.name = name;
        this.salary = salary;
        this.cosplay = cosplay;
        this.date = date;
        this.weekPlanning = weekPlanning;
    }

    public Double getSalary() {
        return this.salary;
    }

    public void setCosplay(String cosplay) {
        this.cosplay = cosplay;
    }

    public String getCosplay() {
        return cosplay;
    }

    public WeekPlanning getWeekPlanning() {
        return this.weekPlanning;
    }

    public String getTodaySchedule() {
        return;
    }
}
