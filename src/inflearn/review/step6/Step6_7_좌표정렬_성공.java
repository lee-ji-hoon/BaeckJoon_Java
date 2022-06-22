package inflearn.review.step6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Step6_7_좌표정렬_성공 {
    static class Node implements Comparable<Node>{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o){
            if(this.x == o.x)
                return this.y - o.y;
            else
                return this.x - o.x;
        }
    }
    private static void solution(int[][] arr, int n) {


    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        ArrayList<Node> arrayList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            arrayList.add(new Node(x, y));
        }
        Collections.sort(arrayList);

        for (Node node : arrayList) {
            System.out.println(node.x + " " + node.y);
        }
    }
}
