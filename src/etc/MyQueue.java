package etc;

class Queue<T>{
    class Node<T>{
        Node<T> next;
        T data;

        public Node(T data){
            this.data = data;
        }
    }

    Node<T> first;
    Node<T> last;

    // add
    public void add(T data){
        Node<T> t = new Node<>(data);

        if(last != null){
            last.next = t;
        }
        last = t;

        if(first == null)
            first = last;
    }
    // remove
    public T remove(){
        if(first == null){
            return (T) "비어있습니다.";
        }
        T data = first.data;
        first = first.next;

        if(first == null){
            last = null;
        }
        return data;
    }
    // peek
    public T peek() {
        if (first == null) {
            return (T) "비어있습니다.";
        }
        return first.data;
    }
    // isEmpty
    public boolean isEmpty(){
        return first == null;
    }
}

public class MyQueue {
    public static void main(String[] args) {
        Queue<Integer> q = new Queue<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.peek());
        System.out.println(q.remove());
        System.out.println(q.isEmpty());
        System.out.println(q.remove());
        System.out.println(q.isEmpty());
    }
}
