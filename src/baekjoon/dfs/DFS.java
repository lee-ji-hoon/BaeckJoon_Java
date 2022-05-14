package baekjoon.dfs;

import java.util.Stack;

public class DFS {

    public static void depthFS(int[][] graph, int vertex) { // 깊이 우선탐색을 수행하는 함수입니다.
        // vertex는 시작점
        Stack<Integer> stack = new Stack(); // 깊이 우선 탐색에서 사용할 stack의 생성

        boolean[] visited = new boolean[graph.length]; // visited 배열의 생성
        for(int i = 0; i < visited.length; i++) { // visited 배열을 false로 초기화
            visited[i] = false;
        }

        stack.push(vertex);

        while(!stack.isEmpty()) { //stack이 공백이 될때까지 실행한다.
            int v = stack.pop(); // stack에 있는 데이터를 pop한다.

            if(!visited[v]) {  //pop한 정점이 방문하지 앟은 상태라면
                System.out.print(v + "  "); // 방문을하고
                visited[v] = true; // visited배열을 true로 바꿔준다.

                for(int i = graph[v].length-1; i >= 0; i--) { // 방문한 정점에 인접한 정점을 찾는다.
                    if(graph[v][i] == 1) {
                        if(!visited[i]) { // 인접한 정점중에 방문을 안한 정점이 있다면
                            stack.push(i); // stack에 push한다.
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0,1,1,1,0,0,0},
                {1,0,0,0,1,0,0},
                {1,0,0,0,1,1,0},
                {1,0,0,0,0,1,0},
                {0,1,1,0,0,0,1},
                {0,0,1,1,0,0,1},
                {0,0,0,0,1,1,0}
        };

        depthFS(graph,0);
    }

}