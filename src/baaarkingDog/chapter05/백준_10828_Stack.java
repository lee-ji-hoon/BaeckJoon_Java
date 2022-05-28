package baaarkingDog.chapter05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 백준_10828_Stack {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    void solution(int N, Stack<Integer> stack) throws IOException {
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            switch (str[0]) {
                case "push":
                    stack.push(Integer.valueOf(str[1]));
                    break;
                case "top":
                    if (stack.empty()) System.out.println(-1);
                    else System.out.println(stack.peek());
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "pop":
                    if (stack.empty()) System.out.println(-1);
                    else System.out.println(stack.pop());
                    break;
                case "empty":
                    if (stack.empty()) System.out.println(1);
                    else System.out.println(0);
                    break;
            }

        }
    }

    public static void main(String[] args) throws IOException {

        백준_10828_Stack main = new 백준_10828_Stack();

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        main.solution(N, stack);
    }
}
