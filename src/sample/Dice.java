package sample;

import java.util.Random;

public class Dice  implements Runnable {
    public int value = 0;
    Random rd = new Random();
    public int roll(){
        return ((int) (Math.random()*( 5))) + 1;
    }


    @Override
    public void run() {
//        System.out.println("hello from run")
        int temp = ((int) (Math.random()*( 5))) + 1;
        value = temp;
        System.out.println(this.value);
    }
}
