package fr.esgi.employee;

import fr.esgi.exceptions.EmployeeAlreadyExists;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RoomService extends Employee   {

    private String servicesRoom;

    public RoomService(String name, String salary, String cosplay, String date, String servicesRoom) {
        super(name, salary, cosplay, date);
        this.servicesRoom = servicesRoom;
    }

    public RoomService(List<String> attributes) {
        super(attributes);
        this.servicesRoom = attributes.get(5);
    }
    @Override
    public String toString() {
        return super.toString() + servicesRoom + "\n";
    }
}
