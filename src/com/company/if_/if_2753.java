package com.company.if_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class if_2753 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int year = Integer.parseInt(br.readLine());

//        System.out.println((year % 4 == 0)?((year % 400 ==0) ? "1" :(year%100 ==0) ? "0" : "1"):"0");

        if((year % 4 == 0) && (year % 100 !=0) || (year % 400 == 0)){
            System.out.println("1");
        }else{
            System.out.println("0");
        }

    }
}
