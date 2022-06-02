package baaarkingDog.chapter03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 백준_1475_방번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        float[] arr = new float[10];
        for (int i = 0; i < str.length(); i++) {
            int c = Integer.parseInt(String.valueOf(str.charAt(i)));
            if(c==6 || c==9)arr[c] += 0.5;
            else arr[c]+=1;
        }
        Arrays.sort(arr);
        System.out.println(Math.round(arr[9]));
    }
}
