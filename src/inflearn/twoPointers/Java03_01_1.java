package inflearn.twoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 1. a {1, 3 , 5}  // b {2, 3, 6 ,7, 9}
 * 2. a의 p1 과 b의 p2값 비교 (pointer)
 *  2-1. p1 < n // p2 < m
 *  2-2. 둘 중에 낮은 곳의 p값은 증가 ? 같은 값일 때는? 어떻게?
 *  2-3. p1 or p2 가 최댓값 까지 가면 나머지 남은 배열을 그대로 추가
 */

public class Java03_01_1 {

    public ArrayList<Integer> solution (int n, int m, int[] a, int[] b) {
        ArrayList<Integer> answer = new ArrayList<>();
        int p1 = 0, p2 = 0;

        while (p1 < n && p2 < m) { // 둘 중 하나라도 최댓값을 넘어가면 while문 종료
            if (a[p1] < b[p2]) answer.add(a[p1++]);  // 후이증감 연산자 // 전지증감 연산자
                // answer.add(a[p1++]) 할 경우 p1의 해당하는 값 add 해준 뒤 p1++
                // answer.add(a[p1]); p1++ 과 같음
            else answer.add(b[p2++]);
        }

        while (p1<n) answer.add(a[p1++]);
        while (p2<m) answer.add(b[p2++]);

        return answer;
    }

    public static void main(String[] args) throws IOException {

        Java03_01_1 T = new Java03_01_1();

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



