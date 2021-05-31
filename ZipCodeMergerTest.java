package com.example.demo;

import jdk.nashorn.internal.AssertsEnabled;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.IntStream;

public class ZipCodeMergerTest {

    public static void main(String[] args) {

        int[][] datasets1 = new int[4][2];
        datasets1[2] = new int[]{94133, 94133};
        datasets1[0] = new int[]{94200, 94299};
        datasets1[1] = new int[]{94201, 94699};
        ZipCodeMerger zipCodeMerger1 = new ZipCodeMerger();
        List<int[]> output1 = zipCodeMerger1.sortElementsBasedOnFirstIndex(datasets1);
        Assert.isTrue(output1.size()== 2, "should return 2 objects");
        zipCodeMerger1.log(output1);
        System.out.println();
        int[][] datasets2 = new int[4][2];
        datasets2[2] = new int[]{94133, 94133};
        datasets2[0] = new int[]{94200, 94299};
        datasets2[1] = new int[]{94600, 94699};
        ZipCodeMerger zipCodeMerger2 = new ZipCodeMerger();
        List<int[]> output2 = zipCodeMerger2.sortElementsBasedOnFirstIndex(datasets2);
        zipCodeMerger2.log(output2);
        Assert.isTrue(output2.size() == 3, "Should return 3 objects");


    }

}
