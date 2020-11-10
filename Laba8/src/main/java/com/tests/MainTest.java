package com.tests;
import org.junit.jupiter.api.Test;
import com.bsu.Main;

import java.io.FileNotFoundException;

public class MainTest {
    @Test
    void test() throws FileNotFoundException {
        String[] args1 = {"src/main/java/Test.txt"};
        String[] args2 = {"src/main/java/Test2.txt"};
        System.out.println("Test1");
        Main.main(args1);
        System.out.println("Test2");
        Main.main(args2);
    }
}