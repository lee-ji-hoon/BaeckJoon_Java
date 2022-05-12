package inflearn.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Java10_4_가장높은탑쌓기 {

    static int[] dp;

    static class Brick implements Comparable<Brick> {
        // 넓이 높이 무게
        public int area,  height, weight;

        Brick(int area, int height, int weight) {
            this.area = area;
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Brick o) {
            return o.area - this.area;
        }
    }

    public static int solution(ArrayList<Brick> bricks) {
        Collections.sort(bricks);

        dp[0] = bricks.get(0).height;
        int max = dp[0];

        for (int i = 1; i < bricks.size(); i++) {
            dp[i] = bricks.get(i).height;

            for (int j = 0; j < i; j++) {
                if(bricks.get(i).weight < bricks.get(j).weight){
                    dp[i] = Math.max(dp[i], dp[j] + bricks.get(i).height);
                }
            }

            max = Math.max(max, dp[i]);
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        ArrayList<Brick> bricks = new ArrayList<>();
        dp = new int[N];

        for (int i = 0; i < N; i++) {
            // 넓이 높이 무게
            int area = sc.nextInt();
            int height = sc.nextInt();
            int weight = sc.nextInt();

            bricks.add(new Brick(area, height, weight));
        }

        System.out.println(solution(bricks));
    }
}
