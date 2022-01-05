package com.company.for_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class for_2742 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = N; i >= 1; i--) {
            sb.append(i);
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
