package inflearn.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java08_02_바둑이승차 {
    static int max = Integer.MIN_VALUE;

    void solution(int L, int N, int C, int sum , int arr[]) {
        // 트럭에 태울 수 있는 무게보다 현재 더해진 값이 더 크면 그냥 바로 return 해버리면 된다.
        if (C < sum) return;
        if (L == N) {
            // L == N  이 즉 가장 아래까지 갔을 때를 체크하는 것이다.
            max = Math.max(max, sum);
        }else{
            // 4 5 1 2 9 이 입력이라고 치면
            // 4가 더해지고 그 뒤 5를 더해지고 그렇게 9까지 간 뒤 다음 solution이 작동한다.
            solution(L + 1, N, C, sum + arr[L], arr);
            solution(L + 1, N, C, sum, arr);
        }
    }

    public static void main(String[] args) throws IOException {
        Java08_02_바둑이승차 main = new Java08_02_바둑이승차();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        main.solution(0, N, C, 0, arr);
        System.out.println(max);
    }
}
