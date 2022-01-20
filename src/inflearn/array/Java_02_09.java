package inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 1. 첫 줄에 자연수 N 이 주어지고 N * N의 격자판이 주어지므로 이중 for문으로 temp[i][j] 값 입력
 * 2. 행의 합 열의 합 두 대각선의 합 hap 배열에 저장
 * 3. 대각선 할 때 왼쪽에서 오른쪽([0~4][0~4] 행 == 열) 과 오른쪽에서 왼쪽으로 [0][4] [1][3] [2][2] [3][1] [4][0] 행 = 열(N - i -1) 두 가지 생각
 * 4. sort 정렬 후 size() - 1 해서 마지막 값 추출하면 끝
 */

public class Java_02_09 {

    public int solution(int N, int[][] temp) {

        int answer = 0;

        ArrayList<Integer> hap = new ArrayList<>(N * 2 + 2); // 모든 행의 합 열의 합 + 대각선 2개 이므로 N * N + 2개의 배열이 나온다.

        for (int i = 0; i < N; i++) { // 행과 열 더하기
            int widthSum = 0; // 행 변수
            int lengthSum = 0; // 열 변수

            for (int j = 0; j < N; j++) {
                lengthSum = lengthSum + temp[i][j]; // [0][0~4] 열 더하기
                widthSum = widthSum + temp[j][i]; // [0~4][0] 행 더하기
            }
            hap.add(widthSum); // 열 값 hap ArrayList에 추가
            hap.add(lengthSum); // 행 값 hap ArrayList에 추가
        }

        int diagonal = 0; // 왼쪽에서 오른쪽으로 가는 대각선 구하기
        int diagonalReverse = 0; // 오른쪽에서 왼쪽으로 가는 대각선 구하기

        for (int i = 0; i < N; i++) {
            diagonal = diagonal + temp[i][i]; // [0~4][0~4] 즉 (행 == 열) 같은 값으로 돈다.
            diagonalReverse = diagonalReverse + temp[i][N - i - 1]; // [0][4] [1][3] [2][2] [3][1] [4][0] 행 = 열(N - i -1) 값이다.
        }
        hap.add(diagonal);
        hap.add(diagonalReverse);

        Collections.sort(hap); // 최대값 구하기 위해서 정렬
        answer = hap.get(hap.size() - 1); // 마지막 값이 최대값이므로 size()-1 가져옴
        return answer;
    }

    public static void main(String[] args) throws IOException {

        Java_02_09 T = new Java_02_09();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] temp = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                temp[i][j] = num;
            }
        }
        System.out.println(T.solution(N, temp));
    }
}
