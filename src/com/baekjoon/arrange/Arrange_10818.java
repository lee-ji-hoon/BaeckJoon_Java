package com.baekjoon.arrange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Arrange_10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int index = 0;
        int[] arr = new int[N];

        /*for (int i = 0; i < N ; i++) {
            arr[index] = Integer.parseInt(st.nextToken());
            index++;
        }*/

        while (st.hasMoreTokens()) { // hasMoreTokens -> StringTokenizer에 토큰이 남아있으면 true 비어있으면 false 반환
            arr[index] = Integer.parseInt(st.nextToken());
            index++;
        }

        Arrays.sort(arr);
        System.out.println(arr[0] + " " + arr[N - 1]);
    }
}
