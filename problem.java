package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {

        int[][] datasets = new int[4][2];
        datasets[2] = new int[]{94133, 94133};
        datasets[0] = new int[]{94200, 94299};
        datasets[1] = new int[]{94201, 94699};

//        list.forEach(x-> {
//            System.out.println(x[0]+"  "+ x[1]);
//        });
        sortJava8(datasets);
    }

    private static void mergeRanges(List<int[]> list) {
        int[] prev = new int[2];
        int[] prev1 = new int[2];
        List<int[]> output = new ArrayList<>();
        boolean skip = true;
        for (int i = 0; i < list.size(); i++) {
            int[] currentElement = list.get(i);

//            if(i==0){
//                prev = currentElement;
//            }else{
            if (prev[0] < currentElement[0] && prev[1] > currentElement[0]) {
                prev[1] = currentElement[1];
                i++;
                skip = false;
            }
            prev = currentElement;
            if(skip)
            output.add(prev);
            skip = true;
            // }

        }
        output.forEach(x->{
            System.out.println (x[0] +"   "+x[1]);
        });

    }

    private static void sortJava8(int[][] datasets) {
        List<int[]> list = Arrays.asList(datasets).stream().sorted((x1, x2) -> {
            if (x1[0] > x2[0]) {
                return 1;
            }
            return -1;
        }).collect(Collectors.toList());
        mergeRanges(list);
    }

    private static void sort(int[][] datasets) {
        int[][] newdatasets = new int[3][2];
        int[] prev = new int[2];

        for (int i = 0; i < datasets.length; i++) {
            // while(){
            int[] ele = datasets[i];
            if (i == 0) {
                prev = ele;
                newdatasets[i] = ele;
            }
            if (i > 0) {
                if (prev[0] > ele[0]) {
                    int loc = i;
                    while (prev[0] > ele[0]) {
                        int[] temp = prev;
                        newdatasets[loc] = temp;
                        loc--;
                        newdatasets[loc] = ele;
                        prev = ele;
                    }

                } else {
                    newdatasets[i] = ele;
                    prev = ele;
                }
            }
        }
        for (int i = 0; i < newdatasets.length; i++) {

            for (int j = 0; j < newdatasets[i].length; j++) {
                System.out.print(" " + newdatasets[i][j]);
            }
            System.out.println();
        }
    }
}