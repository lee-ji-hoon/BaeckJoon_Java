package etc;

import java.util.Scanner;

public class DecimalConvert {

    public static String solution(int num, int N) {
        StringBuilder sb = new StringBuilder();

        if(N == 10)
            return String.valueOf(num);
        if(N <= 0)
            return "-1";

        while(num > 0){
            int share = num / N;
            int remain = num % N;
            if(remain > 9)
                sb.append((char)(remain + 55));
            else
                sb.append(remain);

            num = share;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(); // 바꿀 숫자
        int N = sc.nextInt(); // 진수

        String solution = solution(num, N);
        System.out.println("solution = " + solution);
    }
}
