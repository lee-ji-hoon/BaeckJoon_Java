package baaarkingDog.chapter05;

public class Stack_직접만들어보기 {

    static int MX = 10000005;
    static int[] dat = new int[MX];
    static int pos = 0;

    void push(int x){
        dat[pos++] = x;
    }

    void pop(){
        dat[pos--] = 0;
    }

    int top(){
        return dat[pos];
    }

    void test(){
        for (int i = 0; i < 10; i++) push(i);
        pop();
        System.out.println(top());

    }

    public static void main(String[] args) {
        Stack_직접만들어보기 stack = new Stack_직접만들어보기();
        stack.test();
    }
}
