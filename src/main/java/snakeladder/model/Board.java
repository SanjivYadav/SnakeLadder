package main.java.snakeladder.model;

import java.util.Map;

public class Board {
    private int dimention;
    private Map<Integer, ForienEntity> forienEntitymap;

    public int getDimention() {
        return dimention;
    }

    public Map<Integer, ForienEntity> getForienEntitymap() {
        return forienEntitymap;
    }

    public void setForienEntitymap(Map<Integer, ForienEntity> forienEntitymap) {
        this.forienEntitymap = forienEntitymap;
    }

    public Board(int dimention) {
        this.dimention = dimention;
    }


}
