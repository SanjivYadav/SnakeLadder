package main.java.snakeladder.strategy;

import main.java.snakeladder.model.Button;
import main.java.snakeladder.model.ButtonStatus;
import main.java.snakeladder.model.Player;

public class ButtonWithOneStartStrategy implements ButtonStartStrategies{
    @Override
    public boolean canStart(Button button, int pos) {
        return button.getButtonStatus() == ButtonStatus.LOCKED && pos == 1;
    }
}
