package inflearn.stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Queue;

/**
 * 1. 필수과목 입력 및 본인 과목 입력
 * 2. 필수과목 Queue queue 넣기
 * 3. 본인 과목이랑 비교하기 위해서 queue.contains()사용
 *  3-1. queue.contains(o)
 *   3-1-1. o != poll() true -> o가 큐의 맨 윗값 확인 후 같으면 패스
 *   3-1-2. o != poll() false -> answer = "NO", break;
 * 4. 아예 필수과정이 없는 경우도 체크
 * 5. return answer;
 */

public class Java05_07 {
    public String solution(String need, String plan){
        String answer="YES";
        Queue<Character> queue=new LinkedList<>();
        for (char o : need.toCharArray()) queue.offer(o); // 필수과목

        for (char o : plan.toCharArray()) { // 확인해봐야할 과목들

            if (queue.contains(o)) { // x가 포함 돼있나 확인
                if (o != queue.poll()){
                    answer = "NO"; // 없는 경우
                    break;
                }
            } // 있으면 그대로 YES
        }

        if(!queue.isEmpty()) answer = "NO"; // 아예 이수 안하는 경우도 생각해야하므로 return NO
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Java05_07 T = new Java05_07();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String need = br.readLine();
        String plan = br.readLine();

        System.out.println(T.solution(need, plan));
    }
}
