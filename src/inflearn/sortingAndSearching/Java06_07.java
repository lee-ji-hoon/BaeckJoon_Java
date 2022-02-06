package inflearn.sortingAndSearching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 1. N 입력
 * 2. x 값에 의해서 정렬이지만 x값이 같은 경우 y값 정렬
 *  2-1. Comparable 사용
 * 3. Collections.sort 이용해서 정렬
 * 4. 좌표 문제 나올 때마다 사용하게 되므로 구조 자체를 외워두기
 */

public class Java06_07 {


    static class Point implements Comparable<Point>{

        // 좌표 시작 -> 외워버리기
        public int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o){
            if (this.x == o.x) {
                return this.y - o.y; // 내림차순이면 순서만 바꿔주기
            } else {
                return this.x - o.x;
            }
        }
        // 좌표 끝
    }

    public static void main(String[] args) {
        Java06_07 T = new Java06_07();

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        ArrayList<Point> arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            arr.add(new Point(x, y));
        }
        Collections.sort(arr);
        for (Point point : arr) System.out.println(point.x + " " + point.y);
    }
}
