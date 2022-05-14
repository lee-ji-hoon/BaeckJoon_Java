package inflearn.dfs_bfs;

import java.util.Scanner;

/**
 * 1. N개 배열 입력
 * 2. 원소의 합이 서로 같은 경우 이므로 원소의 합은 배열의 합의 / 2
 * 3. 배열의 모든 값 비교 후 2번의 조건과 동일하면 answer = "YES" 변경 후 return
 */

public class Java08_01_합이같은부분수열 {

    static int[] arr;
    static int sum;
    static String answer = "NO";
    static boolean checkPoint;

    static void solution(int L, int N, int total) {
        if(checkPoint) return; // answer가 yes인 경우 더 이상 밑에 조건을 비교할 이유가 없다.
        if (L == N) { // L == N 의미는 index = N 이라고 봐도 된다. 즉 끝까지 탐색했을 경우에만 검사한다.
            if (total * 2 == sum) { // 총 합이 32인 경우 지금까지 더 해진 값이 16이라면 조건에 무조건 부합하게 된다.
                answer = "YES";
                checkPoint = true; // checkPoint를 true로 바꿔줌으로써 이후의 메모리 낭비를 방지한다.
            }
        }else{
            // 현재 이후 다음 값을 더하냐 안더하냐 차이 이다.
            solution(L + 1, N, total + arr[L]);
            solution(L + 1, N, total);
            // 예시로 아래 처럼 된다.
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        solution(0, N, 0);
        System.out.println(answer);
    }
}
