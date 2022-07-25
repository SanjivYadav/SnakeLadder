package main.java.snakeladder.strategy;

import main.java.snakeladder.model.Board;
import main.java.snakeladder.model.Dice;
import main.java.snakeladder.model.Player;

import java.util.Scanner;

public class NormalPlayerMoveStrategy implements PlayerMoveStrategies{
    @Override
    public void makeNextMove(Player player, Dice dice, Board board) {
        System.out.print("Please roll the dice :");
        int noOfPositionToMove = dice.roll();
        for(int i=0;i<player.getButtons().size();i++){
            //if(player.getButtons().get(i).getButtonStatus() ==)
        }
    }
}
