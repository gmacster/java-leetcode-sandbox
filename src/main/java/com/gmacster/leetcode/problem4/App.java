package com.gmacster.leetcode.problem4;

import java.util.TreeSet;

/*
 * This Java source file was generated by the Gradle 'init' task.
 */
public class App {

    public static void main(String[] args) {
        App app = new App();

        int[] first = new int[] {3, 1};
        int[] second = new int[] {2, 4, 5};

        System.out.println(app.findMedianSortedArrays(first, second));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        // merge the two
        Integer[] combined = new Integer[nums1.length + nums2.length];
        
        for (int i = 0; i < nums1.length; i++) {
            insertSorted(combined, nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            insertSorted(combined, nums2[i]);
        }

        for (int i = 0; i < combined.length; i++) {
            System.out.println(combined[i]);
        }

        if (combined.length % 2 == 0) {
            int middle = combined.length / 2;
            return (combined[middle] + combined[middle - 1]) / 2.0;
        } else {
            return combined[combined.length / 2];
        }
    }

    private void insertSorted(Integer[] destination, int value) {
        
        int i = 0;
        int targetIndex = 0;

        while (i < destination.length && destination[i] != null && value > destination[i]) {
            i++;
        }

        targetIndex = i;

        i = destination.length - 1;

        while (i > targetIndex) {
            destination[i] = destination[i - 1];
            i--;
        }

        destination[targetIndex] = value;
    }
}
