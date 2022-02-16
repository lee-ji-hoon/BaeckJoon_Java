package inflearn.recursive_tree_graph;

/**
 * 1. tree 동일하게 그려주기
 * 2. 최소거리 이므로 root의 lt,rt = null 일 때 return L
 * 3. 그 외의 경우는 Main.min 사용해서 DFS((L+1), root.lt), DFS((L+1), root.rt) 비교 후 값 return
 */

class DFS_shortest {
    int data;
    DFS_shortest lt, rt;

    public DFS_shortest(int val) {
        data = val;
        lt = rt = null;
    }
}

public class Java07_09 {

    DFS_shortest root;

    public int DFS(int L, DFS_shortest root) {
        if (root.lt == null && root.rt == null) return L;
        else return Math.min(DFS(L + 1, root.lt), DFS(L + 1, root.rt));
    }

    public static void main(String[] args) {
        Java07_09 tree = new Java07_09();
        tree.root = new DFS_shortest(1);
        tree.root.lt = new DFS_shortest(2);
        tree.root.rt = new DFS_shortest(3);
        tree.root.lt.lt = new DFS_shortest(4);
        tree.root.lt.rt= new DFS_shortest(5);
        System.out.println(tree.DFS(0 , tree.root));
    }
}
