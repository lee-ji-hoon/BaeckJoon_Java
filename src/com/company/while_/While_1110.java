package com.company.while_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class While_1110 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int fixedNum = N;
        int cnt = 1;
        while (true) {
            N = ((N % 10) * 10) + (((N % 10) + (N / 10)) % 10); //(N % 10) * 10) 다음 숫자의 10의 자리 + ((N % 10) + (N / 10)) % 10 다음 숫자의 1의 자리
            if (N == fixedNum) {
                break;
            }
            cnt++; // 사이클 수 더해주기
        }
        System.out.println(cnt);
    }
}
