package com.company;


import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {


    int[] a = new int[args[0].split (" ").length];
    int i =0;
        for (String s : args[0].split (" ")) {
            a[i] = Integer.parseInt (s);
            i++;
        }
    int n1 = -1;
    int n2 = -1;
    int min = a[0];
        for(i = 0;i<a.length;i++){
            if(a[i]<min){
                min = a[i];
                n1 = i;
            }
        }
        int second = a[0];
        for(i = 0;i<a.length;i++){
            if(a[i]<second && a[i] > min){
                second = a[i];
                n2 = i;
            }
        }
    System.out.println(Math.abs(n1-n2));
    }
}
