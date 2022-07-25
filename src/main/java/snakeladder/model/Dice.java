package main.java.snakeladder.model;

import java.util.List;
import java.util.Random;

public class Dice {
    private int max_no;

    public int getMax_no() {
        return max_no;
    }

    public void setMax_no(int max_no) {
        this.max_no = max_no;
    }

    public int roll(){
        Random random = new Random();
        return 1+random.nextInt(max_no);
    }
}
