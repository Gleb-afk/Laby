package com.bsu.classes;

import java.util.List;

public class Users {
    private String name;
    private String login;
    private String Email;
    private String password;
    private String role;

    public Users(String name, String login, String Email, String password, String role) {
        this.name = name;
        this.login = login;
        this.Email = Email;
        this.password = password;
        this.role = role;
    }

    public String getName() {return name;}
    public String getLogin() {return login;}
    public String getEmail() {return Email;}
    public String getPassword() {return password;}
    public String getRole() {return role;}

    @Override
    public String toString() {
        return name + ", " + login + ", " + Email + ", " + password + ", " + role + "\n";
    }

    public static Users createUser(String line) {
        String[] field = line.split(", ");
        String name = field[0];
        String login= field[1];
        String Email = field[2];
        String password = field[3];
        String role = field[4];
        Users user = new Users(name, login, Email, password, role);
        return user;
    }
}
