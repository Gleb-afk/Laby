package com.bsu.classes;

import java.text.ParseException;
import java.util.Objects;

public class Employee {
    private String name;
    public Integer dollarsy; //доллары
    private String position; //должность
    public boolean isWork; // работает(true) или в отпуске (false)

    public Employee(String name, Integer dollarsy, String position, boolean isWork) {
        this.name = name;
        this.dollarsy = dollarsy;
        this.position = position;
        this.isWork = isWork;
    }

    public String getName() { return name;}
    public Integer getDollarsy() { return dollarsy;}
    public String getPosition() { return position;}
    public String workOrNot(boolean worked) {
        if(worked)
            return "work";
        return "not work";
    }

    @Override
    public String toString() {
        return name + ", " + "salary: " + dollarsy + ", " + position + ", " + workOrNot(isWork);
    }

    public static Employee createEmployee(String line) throws ParseException {
        String[] field = line.split(", ");
        String name = field[0];
        Integer dollarsy = Integer.parseInt(field[1]);
        String position = field[2];
        boolean isWork = Boolean.parseBoolean(field[3]);

        return new Employee(name, dollarsy, position, isWork);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return isWork == employee.isWork &&
                Objects.equals(name, employee.name) &&
                Objects.equals(dollarsy, employee.dollarsy) &&
                Objects.equals(position, employee.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dollarsy, position, isWork);
    }
}