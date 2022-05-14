package inflearn.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java08_06_순열구하기 {

    static void solution(int L, int[] arr, int[] check, int[] answer, int M, int N) {
        if (L == M) {
            for (int i : answer) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < N; i++) {
                if(check[i] == 0){
                    check[i] = 1;
                    answer[L] = arr[i];
                    solution(L + 1, arr, check, answer, M, N);
                    check[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N]; // 입력 배열
        int[] check = new int[N]; // 사용 했는지 체크하는 배열
        int[] answer = new int[M]; // 출력을 위한 배열

        StringTokenizer forToken = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(forToken.nextToken());
        }

        solution(0, arr, check, answer, M, N);
    }
}
