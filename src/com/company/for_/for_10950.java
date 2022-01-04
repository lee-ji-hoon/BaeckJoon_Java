package com.company.for_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class for_10950 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder(); // 계산한 식을 넣어준 뒤 한 번에 출력

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            sb.append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())); // sb에 값을 계속 추가 시킨다.
            sb.append('\n'); // 추가 시킨 값들이 한 줄씩 띄어져있어한다.
        }
        System.out.println(sb);
    }
}
