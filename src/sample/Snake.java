package sample;

public class Snake {
    private int head;
    private int tail;

    private int number;


    public Snake(int num){
        number = num;
    }

    public int getNumber() {
        return number;
    }

    public int getHead() {
        return head;
    }

    public int getTail() {
        return tail;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public void setTail(int tail) {
        this.tail = tail;
    }

    public void setNumber(int number) {
        this.number = number;
    }


}
