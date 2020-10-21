package com.bsu.Classes;

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private final Scanner scan;

    public Menu(Scanner scan) {
        this.scan = scan;
    }

    private void printMenu() {
        System.out.println("Меню запросов:");
        System.out.println("1. Поиск комании по краткому названию;");
        System.out.println("2. Поиск компаний по отрослям;");
        System.out.println("3. Поиск компаний по виду деятельности;");
        System.out.println("4. Поиск команий по дате основания с и по;");
        System.out.println("5. Поиск компаний по числу сотрудников с и по;");
        System.out.println("6. Выход.");
    }

    public void start(List<Company> companies) {
        if (this.scan != null) {
            int key;
            do {
                printMenu();
                System.out.print("Введите номер запроса:");
                key = this.scan.nextInt();
                switch (key) {
                    case 1:
                        System.out.println("Введите компанию по краткому названию:");
                        String shortName = this.scan.next();
                        Find.findByShortName(companies, shortName);
                        break;
                    case 2:
                        System.out.println("Введите необходимые отрасли:");
                        this.scan.nextLine();
                        String firstConsoleLine = this.scan.nextLine();
                        String[] brunches = firstConsoleLine.split(" ");
                        Find.findByBrunchOfWork(companies, brunches);
                        break;
                    case 3:
                        System.out.println("Введите необходимые виды деятельности:");
                        this.scan.nextLine();
                        String secondConsoleLine = this.scan.nextLine();
                        String[] types = secondConsoleLine.split(" ");
                        Find.findByTypeOfWork(companies, types);
                        break;
                    case 4:
                        System.out.println("Введите диапозон поиска (формат dd.mm.yyyy):");
                        String x = this.scan.next();
                        String y = this.scan.next();
                        Find.findInDate(companies, x, y);
                        break;
                    case 5:
                        System.out.println("Введите диапозон поиска:");
                        int from = this.scan.nextInt();
                        int to = this.scan.nextInt();
                        Find.findByCountOfEmployees(companies, from, to);
                        break;
                    case 6:
                        System.out.println("Завершение программы");
                        break;
                    default:
                        System.out.println("Вы ввели неверный запрос");
                }
            } while (key != 6);
        }
    }
}

class Find {

    public static void findByShortName(List<Company> companies, String s) {
        boolean flag = true;
        for(Company company : companies) {
            if(s.equalsIgnoreCase(company.getShortName())) {
                System.out.println(company.toString());
                flag = false;
            }
        }
        if(flag) {
            System.out.println("Компаний не обнаружено");
        }
    }

    public static void findByTypeOfWork(List<Company> companies, String[] consoleTypes) {
        boolean flag = false;
        boolean count = false;
        for(Company company : companies) {
            String[] types = company.getTypeOfWork().split("/");
            for(String typeFromConsole : consoleTypes) {
                flag = false;
                for(String wordFromTypes : types) {
                    if(wordFromTypes.equalsIgnoreCase(typeFromConsole)) flag = true;
                }
                if(!flag) break;
            }
            if(flag) {
                System.out.println(company.toString());
                count = true;
            }
        }
        if(!count) {
            System.out.println("Компаний не обнаружено");
        }
    }

    public static void findByBrunchOfWork(List<Company> companies, String[] consoleBrunches) {
        boolean flag = false;
        boolean count = false;
        for(Company company : companies) {
            String[] brunches =company.getBrunchOfWork().split("/");
            for(String brunchFromConsole : consoleBrunches) {
                flag = false;
                for(String wordFromBrunch : brunches) {
                    if(wordFromBrunch.equalsIgnoreCase(brunchFromConsole)) flag = true;
                }
                if(!flag) break;
            }
            if(flag) {
                System.out.println(company.toString());
                count = true;
            }
        }
        if(!count) {
            System.out.println("Компаний не обнаружено");
        }
    }

    public static void findByCountOfEmployees(List<Company> companies, int x, int y) {
        boolean flag = true;
        for (Company company : companies) {
            if (company.getEmployees() > x && company.getEmployees() < y) {
                System.out.println(company.toString());
                flag = false;
            }
        }
        if (flag) {
            System.out.println("Компаний не обнаружено");
        }
    }

    public static void findInDate(List<Company> companies, String x, String y) {
        boolean flag = true;
        for (Company company : companies) {
            if (toDate(company.getDateOfFoundation()).before(toDate(y)) &&
                    toDate(company.getDateOfFoundation()).after(toDate(x))) {
                System.out.println(company.toString());
                flag = false;
            }
        }
        if (flag) {
            System.out.println("Компаний не обнаружено");
        }
    }

    public static Date toDate(String s) {
        Date date = null;
        try {
            date = new SimpleDateFormat("dd.MM.yyyy").parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}