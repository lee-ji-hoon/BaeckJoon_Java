package programmers.lv2;

class 프로그래머스_Level2_행렬테두리회전하기 {
    private static int[][] arr;
    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    private static int min;

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        arr = new int[rows][columns];
        int value = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = value++;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            min = Integer.MAX_VALUE;
            answer[i] = rotate(query);
        }

        return answer;
    }

    private int rotate(int[] query) {
        int x1 = query[0] - 1;
        int y1 = query[1] - 1;
        int x2 = query[2] - 1;
        int y2 = query[3] - 1;

        int temp = arr[x1][y1];
        int idx = 0;

        int nowX = x1;
        int nowY = y1;

        while (idx < 4) {
            int nextX = nowX + dx[idx];
            int nextY = nowY + dy[idx];

            if (nextX < x1 || nextY < y1 || nextX > x2 || nextY > y2) {
                idx++;
            } else {
                arr[nowX][nowY] = arr[nextX][nextY];
                min = Math.min(min, arr[nowX][nowY]);
                nowX = nextX;
                nowY = nextY;
            }
        }

        arr[nowX][nowY + 1] = temp;

        min = Math.min(min, arr[nowX][nowY + 1]);

        return min;
    }
    public static void main(String[] args) {
        프로그래머스_Level2_행렬테두리회전하기 s = new 프로그래머스_Level2_행렬테두리회전하기();
        int[][] queries = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};
        s.solution(6, 6, queries);
    }
}
