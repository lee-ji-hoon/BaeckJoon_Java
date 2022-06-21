package inflearn.review.step4;

import java.util.*;

public class Step4_5_K번째큰수 {
    public int solution(int[] arr, int M){
        int answer = -1;
        Set<Integer> temp = new TreeSet<>(Collections.reverseOrder());

        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                for(int k = j + 1; k < arr.length; k++){
                    temp.add(arr[i] + arr[j] + arr[k]);
                }
            }
        }

        if(temp.size() < M){
            return -1;
        }

        int idx = 0;
        for(int num : temp){
            if(idx == M - 1) {
                answer = num;
                break;
            }
            idx++;
        }

        return answer;
    }
    public static void main(String[] args){
        Step4_5_K번째큰수 T = new Step4_5_K번째큰수();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        System.out.print(T.solution(arr, M));
    }
}