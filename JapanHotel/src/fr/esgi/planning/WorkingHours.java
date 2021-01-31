package fr.esgi.planning;

public class WorkingHours {

    private String employeeName;
    private String day;
    private String startingTime;
    private String endTime;

    public String getEmployeeSchedule(String name) {
        return "";
    }

    public WorkingHours(String employeeName, String day, String startingTime, String endTime) {
        this.employeeName = employeeName;
        this.day = day;
        this.startingTime = startingTime;
        this.endTime = endTime;
    }
}
