package com.company.inputoutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputOutput_2446 {
    public static void main(String[] args) throws IOException {
      /*  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i - 1; j++) {
                sb.append(" ");
            }
            for (int j = 0; j <= 2 * (N - i); j++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < N - i; j++) {
                sb.append(" ");
            }
            for (int j = 0; j < (2 * i) - 1; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}*/

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < 2 * n - 1; i++) {
            int abs = Math.abs(n - i - 1);
            System.out.println(" ".repeat(n - abs - 1) + "*".repeat(2 * abs + 1));
        }
    }
}
