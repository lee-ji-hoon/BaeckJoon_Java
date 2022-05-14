package inflearn.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Java08_05_동전교환 {
    static int min = Integer.MAX_VALUE;
    void solution(int N, int M, int L, Integer[] arr, int sum) {
        // 더한 겂이 M 보다 크면 안된다.
        if (sum > M) return;
        // 최소값을 구하는것이기 때문에 현재 최소값이랑 똑같은 L은 굳이 구할필요가 없다.
        if (L == min) return;

        if (sum == M) {
            min = Math.min(min, L);
        } else {
            for (int i = 0; i < N; i++) {
                solution(N, M, L + 1, arr, sum + arr[i]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Java08_05_동전교환 main = new Java08_05_동전교환();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Integer[] arr = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬을 해줘야한다.
        // 미정렬시 sum == M까지 도달해서 min 값을 갱신해주는데까지 너무 오랜 시간이 걸린다.
        Arrays.sort(arr, Collections.reverseOrder());

        int M = Integer.parseInt(br.readLine());

        main.solution(N, M, 0, arr, 0);

        System.out.println(min);
    }
}