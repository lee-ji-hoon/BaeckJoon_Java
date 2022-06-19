package inflearn.review.step2;


import java.util.Scanner;

public class Step2_3_가위바위보 {
    // 1: 가위 2: 바위 3: 보
    public String[] solution(int[] arr1, int[] arr2){
        String[] answer = new String[arr1.length];
        for(int i = 0; i < arr1.length; i++){
            int a = arr1[i];
            int b = arr2[i];
            int sum = a - b;
            if(a == b)
                answer[i] = "D";
            else if(sum == 1 || sum == 2)
                answer[i] = "A";
            else
                answer[i] = "B";
        }

        return answer;
    }
    public static void main(String[] args){
        Step2_3_가위바위보 T = new Step2_3_가위바위보();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr1 = new int[N];
        int[] arr2 = new int[N];

        for(int i = 0; i < arr1.length; i++)
            arr1[i] = sc.nextInt();
        for(int i = 0; i < arr2.length; i++)
            arr2[i] = sc.nextInt();

        String[] answer = T.solution(arr1, arr2);
        for(String num : answer)
            System.out.println(num);
    }
}
