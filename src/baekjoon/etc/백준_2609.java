package baekjoon.etc;

import java.util.Scanner;

// 최대 공약수, 최소 공배수
public class 백준_2609 {
    public void solution(int a, int b) {
        int num1 = Math.max(a, b);
        int num2 = Math.min(a, b);

        int gcd = gcd(num1, num2);
        int lcm = lcm(num1, num2, gcd);

        System.out.println(gcd);
        System.out.println(lcm);
    }

    static int gcd(int a, int b) {
        if( a % b == 0) return b;
        return gcd(b, a % b);
    }

    static int lcm(int a, int b, int gcd){
        return a * b / gcd;
    }

    public static void main(String[] args) {
        백준_2609 t = new 백준_2609();
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        t.solution(a, b);
    }
}
