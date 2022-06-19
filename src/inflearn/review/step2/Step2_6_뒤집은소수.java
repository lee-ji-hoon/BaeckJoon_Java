package inflearn.review.step2;

import java.util.ArrayList;
import java.util.Scanner;

public class Step2_6_뒤집은소수 {
    public ArrayList<Integer> solution(int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();
        for(int num : arr){
            int flipNumber = flip(num);
            if(isPrime(flipNumber))
                answer.add(flipNumber);
        }
        return answer;
    }

    public static int flip(int num){
        int result=0;
        while(num!=0){
            result= result * 10 + num % 10;
            num /= 10;
        }
        return result;
    }

    public static boolean isPrime(int num){
        if(num <= 1)
            return false;
        if(num == 2)
            return true;
        else{
            for(int i = 2; i <= Math.sqrt(num); i++)
                if(num % i == 0)
                    return false;
        }
        return true;
    }


    public static void main(String[] args){
        Step2_6_뒤집은소수 T = new Step2_6_뒤집은소수();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        ArrayList<Integer> answer = T.solution(arr);
        for(int num : answer)
            System.out.print(num + " ");
    }
}