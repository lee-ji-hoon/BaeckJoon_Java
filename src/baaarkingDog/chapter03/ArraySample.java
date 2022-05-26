package baaarkingDog.chapter03;

import java.util.Arrays;

public class ArraySample {
    static int[] arr = {10, 50, 40, 30, 70, 20, 0, 0, 0, 0};
    static int len = 6;

    static void insert(int idx, int num) {
        len++;
        for (int i = len; i > idx; i--) arr[i] = arr[i - 1];
        arr[idx] = num;
    }

    static void erase(int idx){
        len--;
        for (int i = idx; i < len; i++) {
            arr[i] = arr[i + 1];
            arr[i + 1] = 0;
        }
    }
    public static void main(String[] args) {

        insert(3, 60);
        erase(4);

        System.out.println(Arrays.toString(arr));
        System.out.println("len = " + len);
    }
}
