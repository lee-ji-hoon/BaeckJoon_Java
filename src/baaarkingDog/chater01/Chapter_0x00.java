package baaarkingDog.chater01;

import java.io.IOException;

public class Chapter_0x00 {
    public static void main(String[] args) throws IOException {
        Chapter_0x00 chapter_0x00 = new Chapter_0x00();
        chapter_0x00.func5(1024);
    }

    int func1(int arr[], int n){        // 1
        int cnt = 0;                    // 2
        for (int i = 0; i < n; i++) {   // 3
            if(arr[i] % 5 == 0) cnt ++; // 4
        }                               // 5
        return cnt;                     // 6
    }

    void func2(int N) {
        int answer = 0; // 1
        // N * ( 1 + 2 + 2 + 1)
        for (int i = 3; i <= N; i++) {
            if(i % 3 == 0 || i % 5 == 0) answer += i;
        }
        // 1 + 6N -> O(N)
        System.out.println(answer);
    }

    void func3(int arr[], int N){
        int answer = 0;

        for (int i = 0; i < N - 1; i++) { // N * 2
            for (int j = i + 1; j < N; j++) { // N *( 1 + 2 + 2 + 1)
                if (arr[i] + arr[j] == 100) answer++;
            }
        } // 2N * 6N -> 12N^2 -> O(N^2)
        System.out.println(answer);
    }

    void func4(int N) {
        for (int i = 1; i * i <= N; i++) {
            if(i*i == N) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }

    void func5(int N) {
        int i = 2;
        while (i*2 <= N){
            i*=2;
        }
        System.out.println(i);
    }
}
