package main.java.snakeladder.strategy;

import main.java.snakeladder.model.Board;
import main.java.snakeladder.model.Dice;
import main.java.snakeladder.model.Player;

public interface PlayerMoveStrategy {
     void makeNextMove(Player player, int  diceValue, Board board);
}
