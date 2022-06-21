package inflearn.review.step5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Step5_8_응급실 {
    static class Patient{
        int idx;
        int priority;

        Patient(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }
    }
    public int solution(int[] arr, int M){
        int answer = 0;
        Queue<Patient> queue = new LinkedList<>();

        for (int i = 0; i < arr.length; i++)
            queue.add(new Patient(i, arr[i]));

        int count = 0;
        while(!queue.isEmpty()){
            Patient remove1 = queue.remove();
            boolean flag = true;
            for (int i = 0; i < queue.size(); i++) {
                Patient remove2 = queue.remove();
                if(remove2.priority > remove1.priority)
                    flag = false;
                queue.add(remove2);
            }
            if(!flag)
                queue.add(remove1);
            else{
                count++;
                if(remove1.idx == M) {
                    answer = count;
                    return answer;
                }
            }
        }

        return answer;
    }
    public static void main(String[] args){
        Step5_8_응급실 T = new Step5_8_응급실();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }

        System.out.print(T.solution(arr, M));
    }
}