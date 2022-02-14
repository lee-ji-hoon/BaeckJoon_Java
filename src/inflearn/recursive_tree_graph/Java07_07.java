package inflearn.recursive_tree_graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1. 새로운 Node 작성
 * 2. Queue 생성 tree의 root 값 offer
 * 3. Queue의 값이 없을 때까지 반복
 * 4. queue 값을 cur 이라는 변수에 저장
 * 5. cur의 lt 값 rt값 비교 후 null이 아니면 offer
 * 6. L++
 */

class BFS_Node {
    int data;
    BFS_Node lt, rt; // 객체 주소 저장

    public BFS_Node(int val) {
        data = val;
        lt = rt = null;
    }
}

public class Java07_07 {

    BFS_Node root;

    public void BFS(BFS_Node root) {
        Queue<BFS_Node> queue = new LinkedList<>();
        queue.offer(root);

        int L = 0;
        while (!queue.isEmpty()){
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                BFS_Node cur = queue.poll(); // 메인이되는 숫자 집어넣기
                System.out.print(cur.data + " ");

                if (cur.lt != null) queue.offer(cur.lt); // cur의 왼쪽
                if (cur.rt != null) queue.offer(cur.rt); // cur의 오른쪽
            }
            L++;
            System.out.println();
        }
    }
    public static void main(String[] args) {

        Java07_07 tree = new Java07_07();
        tree.root = new BFS_Node(1);
        tree.root.lt = new BFS_Node(2);
        tree.root.rt = new BFS_Node(3);
        tree.root.lt.lt = new BFS_Node(4);
        tree.root.lt.rt = new BFS_Node(5);
        tree.root.rt.lt = new BFS_Node(6);
        tree.root.rt.rt = new BFS_Node(7);
        tree.BFS(tree.root);
    }
}
