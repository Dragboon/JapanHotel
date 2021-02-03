package fr.esgi.employee;

import java.util.List;

public class AccountingHR extends Reception {

    public AccountingHR(String name, String salary, String cosplay, String date, String languages) {
        super(name, salary, cosplay, date, languages);
    }

    public AccountingHR(List<String> attributes) {
        super(attributes);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}