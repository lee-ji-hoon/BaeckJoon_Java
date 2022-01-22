package inflearn.twoPointers;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1. 1차원 배열 입력 2개 받기 N개와 M개
 * 2. 한개로 합쳐서 내림차순 해야 하므로 answer[N+M] 에 각각 누적시킨다
 *  2-1. N은 i = 0  ~ N -> answer[i]
 *  2-2. M은 i = N ~ N+M -> answer[i]
 *   2-2-1. M의 값을 answer[i]에 넣을 때 M[i-N] 해줘야 한다 M[0] ~ M[M-1]이 들어가야 하기 때문에
 *  2-3. Arrays.sort(배열) -> return 배열
 */

public class Java03_01 {

    public int[] solution(int N, int M, int[] arr1, int[] arr2) {

        int length = N + M; // answer 배열 길이
        int[] answer = new int[length];

        for (int i = 0; i < N; i++) { // N의 배열 추가
            answer[i] = arr1[i];
        }

        for (int i = N ; i < length; i++) { // M의 배열 추가
            answer[i] = arr2[i-N];
            // arr2[i] 아닌 이유 -> 예) i = 3 ~ 8 까지 가는데
            // 우리가 원하는 값은 arr2[0] ~ arr[M-1] 이기때문
        }
        Arrays.sort(answer);

        return answer;
    }

    public static void main(String[] args) throws IOException {

        Java03_01 T = new Java03_01();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N개의 배열 입력
        int N = Integer.parseInt(br.readLine());
        int[] arr1 = new int[N];
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(st1.nextToken());
        }

        // M개의 배열 입력
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        int[] arr2 = new int[M];
        for (int i = 0; i < M; i++) {
            arr2[i] = Integer.parseInt(st2.nextToken());
        }

        for (int x : T.solution(N, M, arr1, arr2)) System.out.print(x+" ");
    }
}
