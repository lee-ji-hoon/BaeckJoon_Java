package inflearn.twoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 길이가 N인 수열, k 번의 변경 횟수
 * 2. 길이가 N인 윈도우 생성
 * 3. 0을 만날때마다 1로 바꿔줬다고 가정하고 cnt++
 *  3-1. rt가 N까지 반복
 *   3-1-1. rt == 0 -> cnt ++
 *   3-2. cnt > k 인 경우 반복
 *    3-2-1. lt == 0 -> cnt --, lt++
 *   3-3 answer = Math.max(answer, rt -lt)
 * 4. return answer;
 */

public class Java03_06_1 {

    public int solution(int N, int k, int[] arr) {

        int rt = 0, lt = 0, cnt = 0, answer = 0;

        while (rt < N) { // 오른쪽으로 가면서 N값까지 비교 -> rt == N 되면 빠져나옴

            if (arr[rt] == 0) { // rt칸이 0이면 cnt 증가
                cnt++;
            }

            while (cnt > k) { // cnt == k 되면 빠져나옴
                if (arr[lt] == 0) { // lt값의 칸이 0이면
                    System.out.println("cnt-- 발생");
                    cnt--;
                }
                lt++; // 왼쪽 pointer 위치 이동
            }
            System.out.println("lt + rt = " + lt + " + " + rt);
            rt++;
            answer = Math.max(answer, rt - lt); // 저장 돼 있는 길이와 현재 길이 비교
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {

        Java03_06_1 T = new Java03_06_1();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(T.solution(N, k, arr));
    }
}
