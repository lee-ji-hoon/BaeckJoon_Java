package baekjoon.math;

import java.util.Scanner;

/**
 * 0~2 사이의 숫자가 들어올 경우 바로 출력 시켜버리면 된다.
 * 3이후부터는 solution 클래스로 들어가서 pibo 배열에 값 넣으면서 구한다.
 * 이때 pibo[num] 값이 0이 아니면 굳이 다시 구할 필요가 없으므로 바로 return 해버린다.
 */
public class Math_10870 {
    static int[] pibo;

    static int solution(int n, int num) {
        if(pibo[num] != 0) {
            return pibo[num];
        } else {
            for (int i = 3; i <= n; i++) {
                pibo[i] = solution(n, i - 2) + solution(n, i - 1);
            }
        }

        return pibo[num];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        pibo = new int[n+1];

        if(n >= 0) pibo[0] = 0;
        if(n >= 1) pibo[1] = 1;
        if(n >= 2) pibo[2] = 1;

        if(n < 3) System.out.println(pibo[n]);
        else {
            solution(n, 3);
            System.out.println(pibo[n]);
        }
    }
}
