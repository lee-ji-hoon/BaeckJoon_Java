package com.company.arrange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Arrange_2577 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        int index = A * B * C;
        int[] digits = Stream.of(String.valueOf(index).split("")).mapToInt(Integer::parseInt).toArray(); // int -> String 값으로 변환 후 배열로 변환해주는 과정

        for (int i = 0; i < 10; i++) {
            int cnt=0;
            for (int j = 0; j < digits.length; j++) {
                if (digits[j] == i) {
                  cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}
