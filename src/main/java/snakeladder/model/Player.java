package main.java.snakeladder.model;

import main.java.snakeladder.strategy.PlayerMoveStrategy;

import java.util.List;

public class Player {
    private List<Button> buttons;
    private int id;
    private String name;
    private PlayerStatus playerStatus;

    private PlayerMoveStrategy playerMoveStrategy;

    public PlayerMoveStrategy getPlayerMoveStrategy() {
        return playerMoveStrategy;
    }

    public void setPlayerMoveStrategy(PlayerMoveStrategy playerMoveStrategy) {
        this.playerMoveStrategy = playerMoveStrategy;
    }

    public List<Button> getButtons() {
        return buttons;
    }

    public void setButtons(List<Button> buttons) {
        this.buttons = buttons;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerStatus getPlayerStatus() {
        return playerStatus;
    }

    public void setPlayerStatus(PlayerStatus playerStatus) {
        this.playerStatus = playerStatus;
    }

    public int makeMove(Board board, Dice dice){

        System.out.println("    ");
        System.out.print(this.name +" please roll the dice : ");
        int diceValue = dice.roll();

        System.out.println(diceValue);

        this.playerMoveStrategy.makeNextMove(this, diceValue, board);
        if(this.checkIfWon()){
            this.setPlayerStatus(PlayerStatus.COMPLETED);
        }
        return diceValue;
    }

    public boolean checkIfWon(){
        for(Button button : this.getButtons()){
            if(!button.getButtonStatus().equals(ButtonStatus.ENDED))
                return false;
        }
        return true;
    }
}
