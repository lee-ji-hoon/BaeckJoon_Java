package baaarkingDog.chapter04;

import java.io.*;
import java.util.Stack;

public class 백준_1406_에디터 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> stL = new Stack<>();
        Stack<Character> answer = new Stack<>();

        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            stL.push(str.charAt(i));
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            String command = br.readLine();
            char c = command.charAt(0);
            if (command.contains("P")) {
                char t = command.charAt(2);
                stL.push(t);
            }
            else if(command.equals("L")) {
                if (!stL.empty()) {
                    answer.push(stL.pop());
                }
            }
            else if(command.equals("D")) {
                if (!answer.empty()) {
                    stL.push(answer.pop());
                }
            }

            else {
                if (!stL.empty()) {
                    stL.pop();
                }
            }
        }

        while (!stL.empty()) answer.push(stL.pop());
        while (!answer.empty()) bw.write(answer.pop());

        bw.flush();
        bw.close();
    }
}