package inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Java_02_01_2 {

    public ArrayList<Integer> solution(int N, int[] arr) {

        ArrayList<Integer> answer = new ArrayList<>();

        answer.add(arr[0]);

        for (int i = 1; i < N; i++) {;
            if (arr[i] > arr[i - 1]) {
                answer.add(arr[i]);
            }
        }
        return answer;
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

        for (int x : T.solution(N, temp)) {
            System.out.print(x + " ");
        }

    }
}
