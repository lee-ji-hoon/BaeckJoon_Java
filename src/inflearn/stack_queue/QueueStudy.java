package inflearn.stack_queue;

public class QueueStudy {
    int front;
    int rear;
    int capacity;

    Object[] queue;

    QueueStudy(int capacity){
        this.front = -1;
        this.rear = -1;
        this.capacity = capacity;
        queue = new Object[this.capacity];
    }

    public boolean isFull() {
    // capacity가 10이면 배열은 0~9를 갖고, rear도 0부터 시작하기 때문에 -1을 해야한다.
        return (this.rear == this.capacity-1);
    }

    public boolean isEmpty() {
    // front와 rear가 같으면 비어있는 상태이기 때문에, 편의를 위해 front와 rear를 -1로 초기화 시켜준다.
        if(front == rear) {
            front = -1;
            rear = -1;
        }
        return (this.front == this.rear);
    }

    public int size() {
        return Math.abs((rear + 1) - (front + 1));
    }

    public static void main(String[] args) {

        QueueStudy queueStudy = new QueueStudy(10);

        System.out.println("queue.size() = " + queueStudy.size());

    }
}

