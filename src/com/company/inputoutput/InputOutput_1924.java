package com.company.inputoutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class InputOutput_1924 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int monthNum = Integer.parseInt(st.nextToken());
        int dayNum = Integer.parseInt(st.nextToken());

        int[] month = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] day = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        int cnt = 0;
        for (int i = 0; i < monthNum; i++) {
            cnt = cnt + month[i];
        }
        cnt = cnt + dayNum;
        sb.append(day[cnt % 7]);
        System.out.println(sb);
    }
}
