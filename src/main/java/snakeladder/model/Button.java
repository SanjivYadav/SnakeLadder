package main.java.snakeladder.model;

public class Button {
    private int currPos;
    private ButtonStatus buttonStatus;

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
