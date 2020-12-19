package com.bsu.main;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите размер массива: ");
            int sizeOfArray = scanner.nextInt();

            List<Integer> arr = new Vector<>(sizeOfArray);

            Random random = new Random();
            for (int i = 0; i < sizeOfArray; i++) {
                arr.add(random.nextInt(200));
            }

            System.out.println("Размер массива: " + sizeOfArray);
            System.out.println("Полученный массив: " + arr);

            menu();

            Comparator<Integer> comparator = null;
            if (scanner != null) {
                int key;
                do {
                    key = scanner.nextInt();
                    switch (key) {
                        case 1:
                            comparator = (a, b) -> a - b;
                            break;
                        case 2:
                            comparator = (a, b) -> b - a;
                            break;
                        case 3:
                            comparator = (a, b) -> getCountOfDigits(a) - getCountOfDigits(b);
                            break;
                        case 4:
                            comparator = (a, b) -> getCountOfDigits(b) - getCountOfDigits(a);
                            break;
                        case 5:
                            System.out.println("Завершение программы.");
                            return ;
                        default:
                            throw new IOException("Неверная команда");
                    }


                SortThread run = new SortThread(arr, comparator);
                Thread sortThread = new Thread(run);
                sortThread.start();
                sortThread.join();


                List<Integer> sortedArr = run.getArray();
                System.out.println("Отсортированный массив: " + sortedArr);
                } while (key != 5);
            }
        } catch(Exception ex){
            System.out.println(ex.toString());
        }
    }

    static int getCountOfDigits(Integer number) {
        int x = number;
        int res = 0;
        while(x != 0){
            x /= 10;
            res ++;
        }
        return res;
    }

    public static void menu() {
        System.out.println("Введите 1 для сортировки массива по возрастанию.");
        System.out.println("Введите 2 для сортировки массива по убыванию.");
        System.out.println("Введите 3 для сортировки массива по возрвстанию количества цифр.");
        System.out.println("Введите 4 для сортировки массива по убыванию количества цифр.");
        System.out.println("Введите 5 для завершения программы.");
    }
}
