package inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. N * N 격자판 주어짐 가장자리는 0이라고 했으므로 [N+2][N+2]으로 해야된다.
 * 2  가장자리에서 시작 할 필요가 없으므로 for문 할 때 i, j = 1 시작
 * 3. temp[i][j] > temp[i+1/-1][j+1/-1] 경우 cnt ++
 */
public class Java_02_10_1 {

    public int solution(int N, int[][] temp) {

        int cnt = 0;

        for (int i = 1; i <= N ; i++) {
            for (int j = 1; j <= N ; j++) {

                if (temp[i][j] > temp[i + 1][j] && // 아래
                        temp[i][j] > temp[i - 1][j] && // 위
                        temp[i][j] > temp[i][j + 1] && // 오른쪽
                        temp[i][j] > temp[i][j - 1]) { // 왼쪽
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {

        Java_02_10_1 T = new Java_02_10_1();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] temp = new int[N+2][N+2];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                int num = Integer.parseInt(st.nextToken());
                temp[i][j] = num;
            }
        }

        System.out.println(T.solution(N, temp));
    }
}
