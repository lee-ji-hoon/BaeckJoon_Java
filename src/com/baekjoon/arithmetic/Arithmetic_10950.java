package com.baekjoon.arithmetic;
/*문제
        두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

        입력
        첫째 줄에 테스트 케이스의 개수 T가 주어진다.

        각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)

        출력
        각 테스트 케이스마다 A+B를 출력한다*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Arithmetic_10950 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // Scanner 와 비슷한 방법인데 BufferedReader 는 문자열로 받아들임
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder(); // 계산한 식을 넣어준 뒤 한 번에 출력

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " "); // StringTokenizer 는 공백을 기준으로 문자열 분리를 위해 사용 -> split() 메소드보다 성능이 좋다
            sb.append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()));
            sb.append('\n');
        }
        System.out.println(sb);
    }
}