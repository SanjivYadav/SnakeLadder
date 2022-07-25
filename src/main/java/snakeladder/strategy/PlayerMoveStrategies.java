package main.java.snakeladder.strategy;

import main.java.snakeladder.model.Board;
import main.java.snakeladder.model.Dice;
import main.java.snakeladder.model.Player;

public interface PlayerMoveStrategies {
     void makeNextMove(Player player, Dice dice, Board board);
}
