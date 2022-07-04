package inflearn.review.step6;

import java.util.Arrays;
import java.util.Scanner;

public class Step6_9_뮤직비디오_결정알고리즘 {

    public static void main(String[] args) {
        Step6_9_뮤직비디오_결정알고리즘 T = new Step6_9_뮤직비디오_결정알고리즘();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        int answer = T.solution(N, M, arr);
        System.out.println(answer);
    }

    private int solution(int n, int m, int[] arr) {
        int answer = 0;
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();

        while (lt <= rt){
            int mid = (lt + rt) / 2;
            if(count(arr, mid, m) <= m){
                answer = mid;
                rt = mid - 1;
            }
            else
                lt = mid + 1;
        }
        return answer;
    }

    public int count(int[] arr, int capacity, int m){
        int cnt = 1, sum = 0;
        for (int i : arr) {
            if(sum + i > capacity){
                // 새로운 장수 필요
                cnt ++;
                sum = i;
            }
            else
                sum += i;

            if(cnt > m)
                return m + 1;
        }
        return cnt;
    }
}
