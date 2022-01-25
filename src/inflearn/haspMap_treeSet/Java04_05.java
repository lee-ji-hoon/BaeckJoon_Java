package inflearn.haspMap_treeSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1. N장의 카드 K(몇 번째로 큰 것?) arr[N] 카드에 적힌 수
 * 2. TreeSet ts 생성
 * 3. 3중 for문으로 3개 뽑을 모든 경우의 수 ts.add
 * 4. ts에 있는 값들 for each 이용해서 비교하기
 *  4-1. cnt 값이 k 되면 answer = i 후 break;
 * 5. return answer; // 답이 없는경우 -1 출력이므로 answer = -1로 초기화 할 것
 */
public class Java04_05 {

    public int solution(int N, int K, int[] arr) {

        TreeSet<Integer> ts = new TreeSet<>(Collections.reverseOrder());
        // TreeSet 값들 오름차순 정렬 (중복제거)
        // Collections.reverseOrder() N번째로 큰 값을 구해야하므로 내림차순 정렬이 편하다.


        // 3중 for문 3개의 합 모든 경우의 수 등록
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    ts.add(arr[i] + arr[j] + arr[k]);
                }
            }
        }

        System.out.println("ts = " + ts);
        int cnt = 0;
        int answer = -1; // 없을 경우 -1 출력이므로 0으로 초기화x

        for (int i : ts) {
            cnt++;
            if(cnt == K) {
                answer = i;
                break; // 더이상 볼 필요 없으므로 빠져나갑니다.
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Java04_05 T = new Java04_05();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(T.solution(N, K, arr));
    }
}
