package baekjoon.inputoutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputOutput_11721 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int strLength = str.length();

        for(int i=0; i<strLength/10; i++) { // 10글자씩 자른 몫 값을 구하기 위해서 10으로 나누고
            System.out.println(str.substring(i*10, (i+1)*10));
        }
        System.out.println(str.substring((strLength/10)*10));
    }
}
