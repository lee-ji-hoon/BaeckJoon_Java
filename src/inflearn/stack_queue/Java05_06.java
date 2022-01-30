package inflearn.stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 첫 줄에 N(왕자의 수)과 K(제외된 왕자) 입력
 * 2. Queue에 n번째까지 저장
 * 3. Queue빈 값일 때까지 반복
 *  3-1. Queue에 poll값 집어 넣기
 *  3-2. Queue poll한 후 size == 1 -> answer에 poll 값 대입
 * 4. return answer;
 */
public class Java05_06 {

    public int Solution(int n, int k) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        while (!queue.isEmpty()) {
            for (int i = 1; i < k; i++) {
                queue.offer(queue.poll());
            }
            queue.poll();
            if (queue.size() == 1) answer = queue.poll();
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {

        Java05_06 T = new Java05_06();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(T.Solution(n, k));

    }
}
