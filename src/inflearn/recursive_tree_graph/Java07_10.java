package inflearn.recursive_tree_graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1. tree 그려주기
 * 2. Queue 생성 <BFS>
 * 3. root 값 queue 저장
 * 4. queue 값이 빌때까지 반복
 *  4-1. queue.size 만큼 반복
 *   4-1-1. lt,rt == null return line;
 *   4-1-2. lt != null queue.offer(lt)
 *   4-1-3. rt != null queue.offer(rt)
 * 5. return 0 -> 여기까지 올 일 절대로 없음
 */

class BFS_shortest {
    int data;
    BFS_shortest lt, rt;

    public BFS_shortest(int val) {
        data = val;
        lt = rt = null;
    }
}
public class Java07_10 {

    BFS_shortest root;

    public int BFS(BFS_shortest root) {
        Queue<BFS_shortest> queue = new LinkedList<>();
        queue.offer(root);
        int line = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                BFS_shortest cur = queue.poll();
                if (cur.lt == null && cur.rt == null) return line;

                if (cur.lt !=null) queue.offer(cur.lt);
                if (cur.rt !=null) queue.offer(cur.rt);
            }
            line ++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Java07_10 tree = new Java07_10();
        tree.root = new BFS_shortest(1);
        tree.root.lt = new BFS_shortest(2);
        tree.root.rt = new BFS_shortest(3);
        tree.root.lt.lt = new BFS_shortest(4);
        tree.root.lt.rt = new BFS_shortest(5);
        System.out.println(tree.BFS(tree.root));
    }
}
