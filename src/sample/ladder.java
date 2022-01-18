package sample;

public class ladder {
    private int start;
    private int end;

    public ladder(int s , int e){
        start = s;
        end = e;
    }

    public int getEnd() {
        return end;
    }

    public int getStart() {
        return start;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public void setStart(int start) {
        this.start = start;
    }
}
