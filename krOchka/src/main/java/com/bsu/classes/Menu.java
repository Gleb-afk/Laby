package com.bsu.classes;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private final Scanner scanner;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    private void printMenu() {
        System.out.println("Menu");
        System.out.println("1. Log in");
        System.out.println("2. Sign in");
        System.out.println("3. Check all entries");
        System.out.println("4. Portfolio search by client number(only for ADMIN)");
        System.out.println("5. Client statistic");
        System.out.println("6. Top N clients in ... currency");
        System.out.println("7. Exit");
    }
    public void start(List<Users> users, List<Clients> clients) {
        if(this.scanner != null) {
            int key;
            do {
                printMenu();
                System.out.println("Enter your request number");
                key = this.scanner.nextInt();
                switch (key) {
                    case 1:
                        System.out.println("Enter your details: name, login, Email, password");
                        this.scanner.nextLine();
                        String line = this.scanner.nextLine();
                        String[] lines = line.split(", ");
                        Users user = Find.logIn(lines);
                        users.add(user);
                        try(FileWriter writer = new FileWriter("src/main/java/users.txt", true)) {
                        boolean flag = true;
                        for(int i = 0; i < users.size(); ++i) {
                            if(user.getLogin() == users.get(i).getLogin()) {
                                flag = false;
                            }
                        }
                        if(flag) {
                            writer.write(user.toString());
                            System.out.println("success!");
                        }
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                        }
                        break;
                    case 2:
                        System.out.println("Enter login and password:");
                        this.scanner.nextLine();
                        String loginAndPass = this.scanner.nextLine();
                        String[] signIn =loginAndPass.split(" ");
                        Find.signIn(signIn, users);
                        break;
                    case 3:
                        for(Users user1: users) {
                            System.out.println(user1.toString());
                        }
                        break;
                    case 4:

                        break;
                    case 5:
                        break;
                    case 6:
                        System.out.println("Enter the number of top portfolios and currency:");
                        int n = this.scanner.nextInt();
                        this.scanner.nextLine();
                        String currency = this.scanner.nextLine();

                        break;
                    case 7:
                        System.out.println("End of the program");
                        break;
                    default:
                        System.out.println("Incorrect request");
                }
            } while(key !=7);
        }
    }
}
