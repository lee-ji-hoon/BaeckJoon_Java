package com.baekjoon.for_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class for_2439 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N - i; j++) { // N이 5라고 쳤을 때 빈칸은 공백으로 남아야하므로 1 ~ N-i 사이 칸들은 공백으로 해준다.
                sb.append(" ");
            }
            for (int j = 1; j <= i; j++) { // 공백 이후에 별이 찍힌다.
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
