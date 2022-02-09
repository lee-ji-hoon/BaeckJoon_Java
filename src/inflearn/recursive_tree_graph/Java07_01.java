package inflearn.recursive_tree_graph;

public class Java07_01 {

    public void DFS(int N) {
        if (N == 0) return;
        else {
            System.out.print(N + " ");
            DFS(N - 1);
        }
    }

    public static void main(String[] args) {
        Java07_01 T = new Java07_01();
        T.DFS(3);
    }
}
