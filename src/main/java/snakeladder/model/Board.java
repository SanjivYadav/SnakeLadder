package main.java.snakeladder.model;

import java.util.*;

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

    public Board(int dimention, List<ForienEntity> forienEntities) {
        this.dimention = dimention;
        forienEntitymap = new HashMap<>();
        for(ForienEntity forienEntity : forienEntities){
            forienEntitymap.put(forienEntity.getFrom(), forienEntity);
        }
        //createLadder();
    }

    /*private void createSnake(){
        Random random = new Random();
        int noOfSnake = random.nextInt(4,4+random.nextInt(3));
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<noOfSnake;i++){
            int from = random.nextInt();
        }
    }
*/
}
