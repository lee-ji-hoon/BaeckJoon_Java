package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DP_2655 {

    static int[] dp;

    static class Brick implements Comparable<Brick> {
        // 번호 넓이 높이 무게
        public int number, area,  height, weight;

        Brick(int number, int area, int height, int weight) {
            this.number = number;
            this.area = area;
            this.height = height;
            this.weight = weight;
        }

        // compareTo 를 재정의 즉 오버라이드 해줘야 한다.
        @Override
        public int compareTo(Brick o) {
            return o.area - this.area;
        }
    }

    public static void solution(ArrayList<Brick> bricks, int N) {
        Collections.sort(bricks);

        dp[0] = bricks.get(0).height;
        int max = dp[0];

        for (int i = 1; i < N; i++) {
            dp[i] = bricks.get(i).height;

            // 최댓값 구하는 dp
            // dp[i] = Math.max(dp[i], dp[j] + i의 높이)
            for (int j = 0; j < i; j++) {
                if(bricks.get(i).weight < bricks.get(j).weight){ // area는 정렬 했으므로 height만 비교
                    dp[i] = Math.max(dp[i], dp[j] + bricks.get(i).height);
                }
            }
            // 현재 저장 된 최댓값 보다 높은지 체크
            max = Math.max(max, dp[i]);
        }

        // 다시 되돌아가면서 사용한 값들 찾기위한 리스트 생성
        ArrayList<Integer> result = new ArrayList<>();

        // N이 0이 될때까지 체크
        // 후위연산 으로 해야지만 N이 0일때도 체크한다.
        while (N-- != 0) {
            // max == dp[N]으로 조건문을 준 이유는
            // N, N-1 ~ 1, 0 까지의 dp값 중에서 max와 비교하기 위해서이다.
            if (max == dp[N]) {
                // result 리스트에 지금 현재 number즉 index 값을 넣어준다.
                result.add(bricks.get(N).number);
                /**
                 * max 에서 현재 height 값을 빼야지 다음 dp값을 찾으러 갈 수 있다.
                 * -------------------
                 * max = 10 dp[5] = 10
                 * max = 5  dp[4] = 4
                 * max = 5  dp[3] = 5
                 * -------------------
                 * 위처럼 진행이 된다.
                 */
                max -= bricks.get(N).height;
            }
        }

        // 길이부터 출력한다.
        System.out.println(result.size());
        // 배열 출력
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Brick> bricks = new ArrayList<>();
        dp = new int[N + 1];


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            // index 넓이 높이 무게
            int number = i + 1; // i가 0부터 시작하지만 우리가 원하는 값은 1부터 시작이므로 +1
            int area = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            // bricks 추가해준다.
            bricks.add(new Brick(number, area, height, weight));
        }

        solution(bricks, N);
    }
}
