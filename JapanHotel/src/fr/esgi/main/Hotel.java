package fr.esgi.main;

import fr.esgi.employee.Employee;
import fr.esgi.room.Rooms;

public class Hotel {
    private Rooms rooms = new Rooms();
    private Employee[] employees = getEmployeeList();
}
