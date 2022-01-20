package inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_02_01_1 {

    public String solution(int N, int[] arr) {

        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]).append(" ");

        for (int i = 1; i < N; i++) {;
            if (arr[i] > arr[i - 1]) {
                sb.append(arr[i]).append(" ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        Java_02_01_2 T = new Java_02_01_2();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int[] temp = new int[N];

        StringTokenizer st = new StringTokenizer(str, " ");
        for (int i = 0; i < N; i++) {
            temp[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(T.solution(N, temp));

    }
}