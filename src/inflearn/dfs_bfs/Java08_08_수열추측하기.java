package inflearn.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java08_08_수열추측하기 {

    static int[][] combinationArr;
    // answer   : 출력 배열
    // checkArr : 사용했는지 체크하는 배열
    // b        : combination 값 저장 배열
    static int[] answer, checkArr, b;
    static int N, F;
    static boolean check = false;

    // combination 배열 1인 경우 체크
    static void setCombination() {
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                if (i == j || j == 0) {
                    combinationArr[i][j] = 1;
                }
            }
        }
    }


    // 콤비네이션 값 미리 입력(메모이제이션)
    static int combination(int L, int R) {
        if(combinationArr[L][R] != 0) return combinationArr[L][R];
        return combinationArr[L][R] = combination(L - 1, R - 1) + combination(L - 1, R);
    }

    static void solution(int L, int sum) {
        if(check) return; // check true == 이미 정답을 찾았음
        if(sum > F) return; // DFS 합이 F(입력값) 보다 크면 더 이상 볼 필요 없음
        if(sum == F && L == N) { // sum == F만 체크하면 끝까지 내려가서 찾는게 아니므로 L==N 추가로 확인해야 한다.
            for (int i : answer) {
                System.out.print(i + " ");
            }
            check = true; // check를 true로 바꿔줌으로써 이후의 solution 메서드 수행할 때 맨 위에서 체크할 수 있다.
        } else{
            for (int i = 1; i <= N; i++) {
                if(checkArr[i] == 0){ // 1 ~ N의 숫자 중 이미 사용한 것들은 무시해야 한다.
                    checkArr[i] = 1; // 사용했다는 의미로 1로 바꿔준다.
                    answer[L] = i; // answer 배열에 지금 현재 for문의 i값을 넣어준다.

                    // sum은 현재 저장된 i값과 combination배열이 저장된 b를 곱해준다.
                    solution(L + 1, sum + (answer[L] * b[L]));
                    checkArr[i] = 0; // 값을 못찾고 끝났으므로 check 배열을 다시 0으로 초기화 해주고 현재 노드를 끝마친다.
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 1 <= N <= 10
        N = Integer.parseInt(st.nextToken());
        F = Integer.parseInt(st.nextToken());

        // combinationArr 은 0 ~ N 까지 체크하므로 N+1 공간을 할당해야한다.
        combinationArr = new int[N + 1][N + 1];
        // 맨 윗줄 값은 0~N-1가 아닌 1부터 N까지다.
        checkArr = new int[N + 1];
        b = new int[N];
        answer = new int[N];

        setCombination();
        // 3 1 2 4
        // 3+1 1+2 2+4
        // 3+1+1+2 1+2+2+4
        // 3+1+1+1+2+2+2+4
        // 3은1번 1은3번 2는3번 4는1번 이런식으로 된다.
        // 3C0 3C1 3C2 3C3의 경우의 수이며 값은 각 값을 곱해주면 된다.
        // 그러므로 combination 배열부터 체크
        for (int i = 0; i < N; i++) {
            b[i] = combination(N - 1, i);
        }
        solution(0,0);
    }
}
