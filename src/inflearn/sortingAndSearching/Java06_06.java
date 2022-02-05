package inflearn.sortingAndSearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1. N과 N으로 이루어진 arr입력 arr = temp
 * 2. temp 는 Arrays.sort(temp)로 정렬
 * 3. for(i ~ N) arr[i] != temp[i] -> sb.append(i+1).append(" ");
 * 4. return sb.toString()
 */

public class Java06_06 {

    public String solution(int N, int[] arr, int[] temp) {
        StringBuilder sb = new StringBuilder();
        // int[] temp = arr.clone(); // -> int[] temp = arr.clone(); 을 하면 sort 했을 때 둘 다 정렬이 되어버림

        for (int i = 0; i < N; i++) {
            if(arr[i] != temp[i]) {
                sb.append(i + 1).append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {

        Java06_06 T = new Java06_06();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] temp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = temp[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(temp);
        System.out.println(T.solution(N, arr, temp));
    }
}
