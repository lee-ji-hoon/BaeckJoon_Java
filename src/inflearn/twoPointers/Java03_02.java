package inflearn.twoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1. N 개의 집합 A, M 개의 잡합 B 입력
 * 2. Arrays.sort(A), Arrays.sort(B)
 * 3. pi -> A의 pointer, pj -> B의 pointer
 *  3-1. A[0]B[0] A[1]B[1] ~ A[N-1]B[N-1] 비교해서 같은게 있으면 answer배열에 추가
 *  3-2. 중복되면 안되므로 answer에 add
 * 4. return answer
 */

public class Java03_02 {

    public ArrayList<Integer> solution (int N, int M, int[] A, int[] B) {
        ArrayList<Integer> answer = new ArrayList<>();

        int pi = 0, pj =0;

        Arrays.sort(A); // A 배열 정렬
        Arrays.sort(B); // B 배열 정렬

        while (pi < N && pj < M) {
            if(A[pi] == B[pj]){ // 공통 원소인 경우
                answer.add(A[pi++]); // A[pi] add 후 pi++
                pj++;
            }
            else if(A[pi] > B[pj]) pj++; // 큰 은 계속 비교해야 하므로 증가 시키지 않는다.
            else pi++; // (A[pi] <= B[pj] 인 경우
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {

        Java03_02 T = new Java03_02();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] B = new int[M];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        for (int x : T.solution(N, M, A, B)) System.out.print(x + " ");
    }
}
