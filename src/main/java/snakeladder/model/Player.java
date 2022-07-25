package main.java.snakeladder.model;

import main.java.snakeladder.strategy.ButtonStartStrategies;

import java.util.List;

public class Player {
    private List<Button> buttons;
    private int id;
    private String name;
    private PlayerStatus playerStatus;

    private ButtonStartStrategies buttonStartStrategies;

    public ButtonStartStrategies getButtonStartStrategies() {
        return buttonStartStrategies;
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
}
