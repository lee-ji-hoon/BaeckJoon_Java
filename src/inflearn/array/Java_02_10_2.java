package inflearn.array;

import java.util.*;

/**
 * 1. if 문 4개짜리 안쓰는 이유 -> 4방향이 아닌 8방향인 경우 if문 8개 16방향이면 16개 이렇게 필요해져서 코드가 복잡해짐
 * 2. 위 오른쪽 아래 왼쪽 순으로 비교하게 됨
 * 3. boolean 으로 체크 해서 true 일 때만 answer++
 * 4. N + 2 해서 가상의 행과 열을 만드는 방법은 좋지 않은 방법임 필요 없는 행과 열이 생기기 때문
 *
 */
public class Java_02_10_2 {

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public int solution(int n, int[][] arr) {

        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                boolean flag = true;

                for (int k = 0; k < 4; k++) {

                    int nx = i + dx[k]; // 행 {-1, 0, 1, 0}
                    int ny = j + dy[k]; // 열 {0, 1, 0, -1} 위 오른 아래 왼 순으로 비교하게 됨

                    // 자주 실수하는 경우 arr~ 부터 한 뒤 nx ny 비교 하게 되면 IndexOutOf 가 먼저 뜨므로 순서 주의 할 것
                    // 미리 걸러줘야하는거 주의
                    if (nx >= 0 && // x 값 이동한게 0 크거나 같아야만 하고
                            nx < n && // x 값 이동한게 n 보다 작아야 한다
                            ny >= 0 && //
                            ny < n && //
                            arr[nx][ny] >= arr[i][j]) // 중심인 지점과 이동한 위치 비교
                    {

                        flag = false;
                        break; // 더 이상 확인 할 필요가 없으니 break 해서 끝냄
                    }
                }
                if (flag) answer++;
            }
        }

        System.out.println(Arrays.deepToString(arr));
        return answer;
    }

    public static void main(String[] args){
        Java_02_10_2 T = new Java_02_10_2();

        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int[][] arr = new int[n][n];

        for(int i=0; i<n; i++){
            for (int j = 0; j < n; j++) {

                arr[i][j] = kb.nextInt();
            }
        }
        System.out.print(T.solution(n, arr));
    }
}
