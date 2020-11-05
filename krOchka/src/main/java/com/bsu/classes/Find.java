package com.bsu.classes;

import java.util.List;

public class Find {
    public static Users logIn(String[] lines) {
        String name = lines[0];
        String login= lines[1];
        String Email = lines[2];
        String password = lines[3];
        String role = "USER";
        Users user = new Users(name, login, Email, password, role);
        return user;
    }

    public static void signIn(String[] lines, List<Users> users) {
        boolean flag = false;
        String login = lines[0];
        String password = lines[1];
        for(int i = 0; i < users.size(); ++i) {
            if(login == users.get(i).getLogin() && password == users.get(i).getPassword()) {
                flag = true;
            }
        }
        if (flag) {
            System.out.println("success");
        }
        else {
            System.out.println("Incorrect login or password");
        }
    }

    public static void topClients (List<Clients> clients, int n, String cur) {
        int max = 0;
        for(int i = 0; i < clients.size(); ++i) {
            if((max < Integer.parseInt(clients.get(i).getSum()))) {
                max = Integer.parseInt(clients.get(i).getSum());
            }
        }
    }

    public static Clients portfolioNumber (List<Clients> clients, List<Users> users, String login,
                                           String password, String portfolioNumber) {
        Users user = null;
        Clients client = null;
        for(int i = 0; i < users.size(); ++i) {
            if(login == users.get(i).getLogin() && password == users.get(i).getPassword()) {
                user = users.get(i);
            }
        }
        if(user.getRole() == "ADMIN") {
            for(int i = 0; i < clients.size(); ++i) {
                if(clients.get(i).getIdentifier() == portfolioNumber) {
                    client = clients.get(i);
                }
            }
        }
        else {
            System.out.println("You are not the ADMIN");
        }

        return client;
    }
}
