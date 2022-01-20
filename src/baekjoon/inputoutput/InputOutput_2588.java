package baekjoon.inputoutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputOutput_2588 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        String B = br.readLine();

        char[] BArray = B.toCharArray();

        System.out.println(A * (BArray[2]- '0'));
        System.out.println(A * (BArray[1]- '0'));
        System.out.println(A * (BArray[0]- '0'));
        System.out.println(A * Integer.parseInt(B));
    }
}
