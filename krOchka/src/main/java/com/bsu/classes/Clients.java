package com.bsu.classes;

import java.util.Date;

public class Clients {
    private String identifier;
    private String nameOfPortfolio;
    private String dateOfCreating;
    private String currency;
    private String sum;
    private String translationCourse;

    public Clients(String identifier, String nameOfPortfolio, String dateOfCreating, String currency,
                   String sum, String translationCourse) {
        this.identifier = identifier;
        this.nameOfPortfolio = nameOfPortfolio;
        this.dateOfCreating = dateOfCreating;
        this.currency= currency;
        this.sum = sum;
        this.translationCourse = translationCourse;
    }

    public String getIdentifier() {return identifier;}
    public String getNameOfPortfolio() {return nameOfPortfolio;}
    public String getDateOfCreating() {return dateOfCreating;}
    public String getCurrency() {return currency;}
    public String getSum() {return sum;}
    public String getTranslationCourse() {return translationCourse;}

    @Override
    public String toString() {
        return identifier + ", " + nameOfPortfolio + ", " + dateOfCreating + ", " +
               currency + ", " + sum + ", " + translationCourse + "\n";
    }

    public static Clients createClient(String line) {
        String field[] = line.split(", ");
        String identifier = field[0];
        String nameOfPortfolio = field[1];
        String dateOfCreating = field[2];
        String currency = field[3];
        String sum = field[4];
        String translationCourse = field[5];
        Clients client = new Clients(identifier, nameOfPortfolio, dateOfCreating, currency,
                                     sum, translationCourse);
        return client;
    }
}
