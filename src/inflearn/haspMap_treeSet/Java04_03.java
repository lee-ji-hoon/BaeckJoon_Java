package inflearn.haspMap_treeSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 1. N(총 매출 일), K(찾고자 하는 일), arr(매출액) 입력, ArrayList<Integer> answer
 * 2. Sliding Window 사용 해서 left, right 변수 지정
 * 3. K - 1까지 map.put(arr[i] 값 추가
 *  3-1. K가 4라고 치면 arr[0], arr[1], arr[2] 값을 map에 put
 * 4. right = k - 1 -> N
 *  4-1. arr[right]를 map에 put -> arr[3] 추가
 *  4-2. answer에 map.size()를 추가
 *  4-3. K(4)칸 씩 왼쪽에서 오른쪽으로 옮겨가면서 비교하는데 옮긴후에도 1일 경우 빼줘야함
 *  4-4. map의 key값이 0인 경우 그 값은 remove 해줌
 */

public class Java04_03 {

    public ArrayList<Integer> solution(int N, int K, int[] arr) {

        ArrayList<Integer> answer = new ArrayList<>();
        int left = 0;

        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < K - 1; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for (int right = K - 1; right < N ; right++) {

            map.put(arr[right], map.getOrDefault(arr[right], 0)+1); // 배열의 right번째 값을 Key, value 값을 1로 추가
            answer.add(map.size()); // map의 size 값을 answer에 추가
            map.put(arr[left], map.get(arr[left])-1); // 오른쪽으로 한 칸 이동 했을 때 map에 저장 된 배열의 left칸의 값이 0인지 체크하기 위해서 value 값 변경
            if(map.get(arr[left])==0) map.remove(arr[left]); // 0인 경우 쓸모가 없으므로 remove
            left++;
        }
        return answer;
    }


    public static void main(String[] args) throws IOException {

        Java04_03 T = new Java04_03();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i : T.solution(N, K, arr)) System.out.print(i + " ");
    }
}
