package baekjoon.inputoutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputOutput_10992 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) { // 별의 범위에서 양 끝에 열 출력 -> 그러므로 0부터 시작

            for (int j = 1; j < 2 * N; j++) {

                if (j > N + i)
                    break;
                if (i == N - 1) { // 마지막 행 출력
                    sb.append("*");
                    continue;
                }
                if (j == N - i || j == N + i) { // 양 끝에 별 출력 및 중간 공백을 위한 조건문
                    sb.append("*");
                } else
                    sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}


