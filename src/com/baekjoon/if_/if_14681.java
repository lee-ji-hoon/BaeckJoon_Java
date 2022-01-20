package com.baekjoon.if_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class if_14681 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine()); // X
        int B = Integer.parseInt(br.readLine()); // Y

        if (A > 0) {
            if (B > 0) {
                System.out.println("1");
            } else {
                System.out.println("4");
            }
        } else { // X = -
            if (B > 0) {  // Y = +
                System.out.println("2");
            }else{
                System.out.println("3");
            }
        }
    }
}
