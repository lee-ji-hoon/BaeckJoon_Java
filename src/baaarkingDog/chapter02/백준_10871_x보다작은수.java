package baaarkingDog.chapter02;

import java.util.Scanner;

public class 백준_10871_x보다작은수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        int X = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int dummy = sc.nextInt();
            if(dummy < X) sb.append(dummy).append(" ");
        }
        System.out.println(sb);
    }
}
