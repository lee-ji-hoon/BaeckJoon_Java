package com.baekjoon.if_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class if_9498 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int str = Integer.parseInt(br.readLine());

        System.out.println((str >= 90) ? "A" : (str>= 80) ? "B" : (str>=70) ? "C" : (str>=60) ? "D" : "F");
    }
}
