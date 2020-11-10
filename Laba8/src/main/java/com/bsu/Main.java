package com.bsu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(args[0]));
        StringBuilder string = new StringBuilder();
        while(scan.hasNextLine()) {
            string.append(scan.nextLine()).append("\n");
        }
        Pattern pattern = Pattern.compile("\\/{2}.+\n|\\/\\*+[\\S\\s]+?\\*+\\/", Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(string.toString());
        while (matcher.find()) {
            System.out.print(matcher.group(0));
        }
    }
}