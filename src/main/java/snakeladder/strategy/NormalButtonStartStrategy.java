package main.java.snakeladder.strategy;

import main.java.snakeladder.model.Button;
import main.java.snakeladder.model.ButtonStatus;
import main.java.snakeladder.model.Player;

public class NormalButtonStartStrategy implements ButtonStartStrategies{
    @Override
    public boolean canStart(Button button, int pos, Player player) {
        return button.getButtonStatus() == ButtonStatus.LOCKED && pos == 6;
    }
}
