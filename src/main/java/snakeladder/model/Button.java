package main.java.snakeladder.model;

import main.java.snakeladder.strategy.ButtonStartStrategies;

import java.util.ArrayList;
import java.util.List;

public class Button {
    private int currPos;
    private ButtonStatus buttonStatus;

    private List<ButtonStartStrategies> buttonStartStrategies;

    public Button(){
        buttonStartStrategies = new ArrayList<>();
    }

    public List<ButtonStartStrategies> getButtonStartStrategies() {
        return buttonStartStrategies;
    }

    public void addButtonStartStrategies(List<ButtonStartStrategies> buttonStartStrategies) {
        this.buttonStartStrategies.addAll(buttonStartStrategies);
    }

    public void setCurrPos(int currPos) {
        this.currPos = currPos;
    }

    public void setButtonStatus(ButtonStatus buttonStatus) {
        this.buttonStatus = buttonStatus;
    }

    public int getCurrPos() {
        return currPos;
    }

    public ButtonStatus getButtonStatus() {
        return buttonStatus;
    }
}
