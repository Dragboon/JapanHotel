package fr.esgi.employee;

import fr.esgi.planning.WeekPlanning;

import java.util.Date;

public class AccountingHR extends Reception{


    public AccountingHR(String name, Double salary, String cosplay, Date date, WeekPlanning weekPlanning) {
        super(name, salary, cosplay, date, weekPlanning);
    }
}
