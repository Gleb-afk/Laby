package com.bsu.main;

import com.bsu.classes.Employee;
import com.sun.javaws.IconUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList<>();
        try (BufferedReader file = new BufferedReader(new FileReader(args[0]))) {
            String line;
            while ((line = file.readLine()) != null) {
                Employee employee = Employee.createEmployee(line);
                list.add(employee);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Средняя зарплата каждой профессии:");
        Map<String, Double> map1 = list.stream()
                .collect(Collectors.groupingBy(Employee::getPosition,
                        Collectors.averagingInt(Employee::getDollarsy)));
        for (Map.Entry<String, Double> pair : map1.entrySet()) {
            String key = pair.getKey();
            Double value = pair.getValue();
            System.out.println(key + ":" + value);
        }

        System.out.println('\n' + "Вывод имен всех работников компании:");
        String names  = list.stream().reduce("", (x, y) -> x + y.getName() + " ", (x, y) -> x + y);
        System.out.println(names);


        System.out.println('\n' + "Проверка всех сотрудников професси работают они или нет:");
        String position = "boss";
        boolean s = list.stream().filter(x -> x.getPosition().equals(position)).allMatch(x -> x.isWork);
        if(s) {
            System.out.println("Работают все:");
            list.stream().filter(x -> x.getPosition().equals(position)).forEach(System.out::println);
        }
        else System.out.println("сотрудники не работают.");

        System.out.println('\n' + "Увелечение зарплаты всем сотрудникам в два раза:");
        List<Integer> dollars1 = new ArrayList<>();
        for(Employee x : list) {
            dollars1.add(x.getDollarsy());
        }
        List<Integer> dollars2 = dollars1.stream().map(n -> n * 2).collect(Collectors.toList());
        System.out.println(dollars2);

        System.out.println('\n' +"Вывод первого сотрудника в списке, у которого зарплата выше 500:");
        System.out.println(list.stream().filter(x -> x.getDollarsy() > 500).findFirst());

        System.out.println('\n' +"Вывод случайного сотрудника в списке, у которого зарплата ниже 400:");
        System.out.println(list.stream().filter(x -> x.getDollarsy() < 400).findAny());

        System.out.println('\n' + "Вывод сотрудников в соответсвии с их профессиями:");
        Map<String, String> nameToPosition = list.stream().collect(Collectors.
                toMap(Employee::getName, Employee::getPosition));
        System.out.println(nameToPosition);

    }
}
