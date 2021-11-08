package ru.skypro.Level_Nedium;
public class FullName {
    private final String firstName;
    private String middleName;
    private final String surname;

    public FullName(String firstName, String middleName, String surname) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.surname = surname;
    }

    public FullName(String firstName, String surname) {
        this.firstName = firstName;
        this.middleName = " ";
        this.surname = surname;
    }

    public String getFullName() {
        return String.join(" ", firstName, middleName, surname);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return String.format("%-15s %-15s %-15s", getFirstName(), getMiddleName(), getSurname());
    }
}