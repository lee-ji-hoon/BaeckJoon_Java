package baekjoon.class_;

public class class_15596 {
    long sum(int[] a) {
        long ans = 0;
        for (int i = 0; i < a.length; i++) {
            ans = ans + a[i];
        }
        return ans;
    }
}

