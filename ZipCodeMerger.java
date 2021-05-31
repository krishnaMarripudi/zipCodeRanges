package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ZipCodeMerger {

    private List<int[]> mergeRanges(List<int[]> list) {
        int[] prev = new int[2];
        List<int[]> output = new ArrayList<>();
        //int[][] output = new int[list.size()][2];
        boolean skip = true;
        for (int i = 0; i < list.size(); i++) {
            int[] currentElement = list.get(i);
            if (prev[0] < currentElement[0] && prev[1] > currentElement[0]) {
                prev[1] = currentElement[1];
                i++;
                skip = false;
            }
            prev = currentElement;
            if(skip)
            output.add(prev);
            skip = true;
        }
        return output;
    }

    public List<int[]> sortElementsBasedOnFirstIndex(int[][] datasets) {
        List<int[]> list = Arrays.asList(datasets).stream().sorted((x1, x2) -> {
            if (x1[0] > x2[0]) {
                return 1;
            }
            return -1;
        }).filter(x-> x[0] > 0).collect(Collectors.toList());
        return mergeRanges(list);
    }

    public void log(List<int[]> newdatasets) {
        for (int i = 0; i < newdatasets.size(); i++) {

            for (int j = 0; j < newdatasets.get(i).length; j++) {
                System.out.print(" " + newdatasets.get(i)[j]);
            }
            System.out.println();
        }
    }

}
