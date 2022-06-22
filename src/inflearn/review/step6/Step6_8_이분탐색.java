package inflearn.review.step6;

import java.util.Scanner;
import java.util.Arrays;

public class Step6_8_이분탐색 {
    static int solution(int size, int find, int[] arr){
        int answer = 0;

        Arrays.sort(arr);

        int low = 0;
        int high = size;
        int mid = 0;

        while(low <=  high){
            mid = (low+high) / 2;

            if(find == arr[mid])
                return mid;
            else if(find < arr[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }

        return answer;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 길이
        int M = sc.nextInt(); // 찾을 수
        int[] arr = new int[N+1];

        for(int i = 1; i <= N; i++)
            arr[i] = sc.nextInt();

        System.out.print(solution(N, M, arr));
    }
}
