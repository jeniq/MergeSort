package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public static void mergeSort(int[] array, int start, int end){
        if (start < end) {
            int middle = (start + end) / 2;
            mergeSort(array, start, middle);
            mergeSort(array, middle + 1, end);
            merge(array, start, middle, end);
        }
    }

    public static void merge(int[] array, int start, int middle, int end){
        int n1 = start;
        int n2 = middle + 1;
        int curr = 0; // current position
        int[] tempArray = new int[end - start + 1];
        // merge until every sequence has at least one element
        while (n1 <= middle && n2 <= end){
            if (array[n1] < array[n2]){
                tempArray[curr] = array[n1];
                curr++;
                n1++;
            }else{
                tempArray[curr] = array[n2];
                curr++;
                n2++;
            }
        }

        // when one sequence is end, then copy elements from another sequence
        while (n2 <= end){
            tempArray[curr] = array[n2];
            curr++;
            n2++;
        }
        while (n1 <= middle){
            tempArray[curr] = array[n1];
            curr++;
            n1++;
        }
        
        for (curr = 0; curr < end - start + 1; curr++){
            array[start + curr] = tempArray[curr];
        }
    }
}
