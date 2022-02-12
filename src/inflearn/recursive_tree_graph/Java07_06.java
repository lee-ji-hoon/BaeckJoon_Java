package inflearn.recursive_tree_graph;

/**
 * 1. lt, rt, data 로 이루어진 Node 생성
 * 2. root 값이 null 이면 종료
 * 3. DFS의 root.lt 호출
 * 4. DFS의 root.rt 호출
 * 5. 3~4 사이에 어디에 sout 해야 전위 중위 후위가 되는지 확인
 *
 * TODO
 * 1. 직접 그려가며 복습하기
 */

class Node{
    int data;
    Node lt, rt; // 객체 주소 저장

    public Node(int val) {
        data = val;
        lt = rt = null;
    }
}

public class Java07_06 {
    Node root;

    public void DFS(Node root) {
        if(root == null) return;
        else {
            // System.out.println("root.data = " + root.data); // 전위
            DFS(root.lt);
            // System.out.println("root.data = " + root.data); // 중위
            DFS(root.rt);
            System.out.println("root.data = " + root.data); // 후위

        }
    }

    public static void main(String[] args) {
        Java07_06 tree = new Java07_06();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.DFS(tree.root);
    }
}
