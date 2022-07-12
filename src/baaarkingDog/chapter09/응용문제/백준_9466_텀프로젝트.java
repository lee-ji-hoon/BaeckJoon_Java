package baaarkingDog.chapter09.응용문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_9466_텀프로젝트 {
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            answer = 0;
            int n = Integer.parseInt(br.readLine());
            int[] student = new int[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine() ," ");
            for (int j = 1; j <= n; j++) {
                student[j] = Integer.parseInt(st.nextToken());
            }

            boolean[] visited = new boolean[n + 1];
            boolean[] team = new boolean[n + 1];

            for (int j = 1; j <= n; j++)
                // 1. 해당 유저가 아직 팀을 이루지 않았다면 확인
                if(!team[j])
                    dfs(j, visited, team, student);

            System.out.println(n - answer);
        }
    }


    private static void dfs(int num, boolean[] visited, boolean[] team, int[] student) {
        if(team[num])
            return;
        // 2. 이미 방문 했을 경우
        if(visited[num]){
            team[num] = true;
            answer++;
        }

        // 3. 방문했다는 의미로 체크하고 다음 인원 체크
        visited[num] = true;
        dfs(student[num], visited, team, student);

        team[num] = true;
        visited[num] = false; // 다음 dfs를 위해서 방문체크 했던거 초기화
    }
}
