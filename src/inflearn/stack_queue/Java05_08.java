package inflearn.stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 인원수 n 목표가되는 사람 m 위험도 배열 arr
 * 2. 순번과 위험도가 같이 있는게 편할 것 같으므로 queue를 순선,위험도로 입력
 * 3. 임시로 Q.poll() 꺼내서 진료가 가능한지 확인하기
 *  3-1. 모든 인원 위험도 비교 후 만약 진료가 불가능한경우 다시 Q에 offer 후 break
 *  3-2. 진료가 가능한 경우 answer++ 후 return
 */


class Person{
    int id;
    int priority;
    public Person(int id, int priority){
        this.id=id;
        this.priority=priority;
    }
}

public class Java05_08 {
    public int solution(int n, int m, int[] arr){
        int answer = 0;
        Queue<Person> Q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            Q.offer(new Person(i, arr[i]));
        }
        while(!Q.isEmpty()){
            Person tmp = Q.poll();
            for (Person x : Q) {
                if (x.priority > tmp.priority) {
                    Q.offer(tmp);
                    tmp = null;
                    break;
                }
            }
            if(tmp!=null){
                answer++;
                if (tmp.id == m) {
                    return answer;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {

        Java05_08 T = new Java05_08();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(T.solution(N, M, arr));
    }
}
