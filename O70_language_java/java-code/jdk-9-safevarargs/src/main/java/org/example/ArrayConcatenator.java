package org.example;

import java.util.ArrayList;
import java.util.List;

public class ArrayConcatenator {
    public static <T> List<T> concatArrays(T[]... arrays) {
        List<T> result = new ArrayList<>();
        for (T[] array : arrays) {
            for (T item : array) {
                result.add(item);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Integer[] array1 = {1, 2, 3};
        Integer[] array2 = {4, 5, 6};
        List<Integer> concatenatedList = concatArrays(array1, array2);
        System.out.println(concatenatedList);
    }
}
