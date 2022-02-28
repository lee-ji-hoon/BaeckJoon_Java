package inflearn.dfs_bfs;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * DFS 코드 풀이
 * TODO
 * 마지막 dis point로 구하는 부분 끝까지 풀지 못해서 다시 풀어봐야함
 *
 * 1. 주어진 입력 받기
 * 2. class Point 이용
 * 3. 2차원 배열 중 house인 곳과 pizza인 곳 나눠서 리스트에 저장
 * 4. if M개 만 골라야하므로 line == M일때 까지 반복
 *  4-1. sum 초기화 후 for-each house로 시작
 *  4-2. 최솟값 구하기 위해 for-each a배열로 전부 찾기
 *   4-2-1. point의 x,y, pizza의 x,y 서로 빼기 (abs 로 절댓값으로 구하기)
 *   4-2-2. 최솟값 구하기 위해서 임의의 함수 만들어서 Math.min(b, 4-2-1)
 *  4-3. 최솟값 구하기 위해서 Math.min(4-2-2, 답)
 * 5. else a배열에 i 저장 후 DFS 호출 (line+1, start+1)
 */
class Point{
    public int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


public class Java08_14 {

    static int N, M, len, minimum = Integer.MAX_VALUE;
    static int[] answer;
    static ArrayList<Point> house, pizza;

    public void DFS(int line, int start) {

        if (line == M) {
            int sum = 0;
            for (Point point : house) {
                int dis = Integer.MAX_VALUE;

                for (int i : answer) {
                    dis = Math.min(dis, Math.abs(point.x - pizza.get(i).x) + Math.abs(point.y - pizza.get(i).y));
                }
                sum += dis;
            }
            minimum = Math.min(minimum, sum);

        } else {
            for (int i = start; i < len; i++) {
                answer[line] = i;
                DFS(line + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        Java08_14 T = new Java08_14();

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        answer = new int[M];

        house = new ArrayList<>();
        pizza = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int temp = sc.nextInt();
                if (temp == 1) house.add(new Point(i, j));
                else if (temp == 2) {
                    pizza.add(new Point(i, j));
                    len++;
                }
            }
        }
        T.DFS(0, 0);
        System.out.println(minimum);
    }
}
