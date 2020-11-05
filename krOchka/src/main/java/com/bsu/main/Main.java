package com.bsu.main;

import com.bsu.classes.Clients;
import com.bsu.classes.Menu;
import com.bsu.classes.Users;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Users> users = new ArrayList<>();
        try(BufferedReader firstFile = new BufferedReader(new FileReader(args[0]))) {
            String line;
            while((line = firstFile.readLine()) != null) {
                users.add(Users.createUser(line));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Clients> clients = new ArrayList<>();
        try(BufferedReader secondFile = new BufferedReader(new FileReader(args[1]))) {
            String line;
            while((line = secondFile.readLine()) != null) {
                clients.add(Clients.createClient(line));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        new Menu(new Scanner(System.in)).start(users, clients);
    }
}
