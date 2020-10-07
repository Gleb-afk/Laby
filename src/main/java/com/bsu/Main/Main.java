package com.bsu.Main;

import com.bsu.Classes.Company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Company> companies = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
            String line;
            while((line = br.readLine()) != null) {
                Company company = new Company();
                companies.add(company.createCompany(line));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try(FileWriter writer = new FileWriter(args[1])) {
            for(Company company: companies) {
                writer.write(company.createToString());
                writer.append(System.lineSeparator());
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static void getAllCompanies(List<Company> companies) {
        for (Company x : companies) {
            System.out.println(x.toString());
        }
    }
}