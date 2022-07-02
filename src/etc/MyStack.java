package etc;

class Stack<T>{
    class Node<T> {
        Node<T> next;
        T data;

        public Node(T data){
            this.data = data;
        }
    }

    Node<T> top;

    // push
    public void push(T data){
        Node<T> t = new Node<>(data);
        t.next = top;
        top = t;
    }
    // pop
    public T pop(){
        if (top == null)
            return (T) "비어있";
        T data = top.data;
        top = top.next;
        return data;
    }
    // peek
    public T peek() {
        if (top == null)
            return (T) "비어있";
        return top.data;
    }
    // isEmpty
    public boolean isEmpty(){
        return top == null;
    }
}

public class MyStack {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.isEmpty());
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.peek());
        System.out.println(s.isEmpty());
    }
}
