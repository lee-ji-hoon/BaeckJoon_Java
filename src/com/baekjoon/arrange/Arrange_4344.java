package com.baekjoon.arrange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Arrange_4344 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine()); // 성적 입력 받을 학생 수
        int score[]; // 성적 입력 받을 배열

        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 학생 수 및 성적 입력

            int student = Integer.parseInt(st.nextToken()); // 첫 번째 토큰을 학생수로 입력
            score = new int[student]; // score 배열의 수를 student 값으로 입력

            double sum = 0; // 점수 총 합

            for (int j = 0; j < student; j++) {
                int val = Integer.parseInt(st.nextToken()); // 토큰에 남아 있는 성적 값 순서대로 입력
                score[j] = val; // 입력받은 성적 값 배열에 입력
                sum = sum + val; // 합 누적
            }

            double average = sum / student; // 평균 구하기 -> 소수점 셋째 자리까지 출력이므로 double
            double cnt = 0; // int형으로 할 경우 마지막 sout에서 오류 생김 주의
            for (int j = 0; j < student; j++) {
                if(score[j] >  average){
                    cnt++;
                }
            }
            System.out.printf("%.3f%%\n", (cnt / student) * 100);
        }
    }
}
