package com.bsu.main;

import java.util.Comparator;
import java.util.List;

public class SortThread implements Runnable {
    private List<Integer> arr;
    private Comparator<Integer> comparator;

    public List<Integer> getArray() {
        return arr;
    }

    public SortThread(List<Integer> array, Comparator<Integer> comparator){
        this.arr = array;
        this.comparator = comparator;
    }

    @Override
    public void run() {
        try {
            arr.sort(comparator);
        } catch(Exception ex) {
            System.out.println(ex.toString());
        }
    }
}