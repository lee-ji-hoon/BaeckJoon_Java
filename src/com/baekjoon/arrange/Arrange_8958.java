package com.baekjoon.arrange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Arrange_8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        String arr[] = new String[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = br.readLine();
        }

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            int cnt = 0;

            for (int j = 0; j < arr[i].length(); j++) {
                if (arr[i].charAt(j) == 'O') {
                    cnt++;
                }else{
                    cnt=0;
                }
                sum = sum + cnt;
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}


