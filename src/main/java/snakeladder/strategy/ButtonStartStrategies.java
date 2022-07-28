package main.java.snakeladder.strategy;

import main.java.snakeladder.model.Button;
import main.java.snakeladder.model.Player;

public interface ButtonStartStrategies {
    boolean canStart(Button button, int pos);
}
