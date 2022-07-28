package main.java.snakeladder.strategy;

import main.java.snakeladder.model.*;

public class NormalPlayerMoveStrategy implements PlayerMoveStrategy {
    @Override
    public void makeNextMove(Player player, int value, Board board) {
        for(Button button : player.getButtons()) {
            for (ButtonStartStrategies buttonStartStrategy : button.getButtonStartStrategies()) {
                if (buttonStartStrategy.canStart(button, value)) {
                    button.setButtonStatus(ButtonStatus.IN_GAME);
                    button.setCurrPos(1);
                    return;
                }
            }
        }
        for(Button button : player.getButtons()){
            int nextPos = button.getCurrPos()+value;
            if(nextPos > board.getDimention()){
                continue;
            }
            if(button.getCurrPos()+value == board.getDimention()){
                button.setCurrPos(board.getDimention());
                button.setButtonStatus(ButtonStatus.ENDED);
                return;
            }
            if(board.getForienEntitymap().containsKey(nextPos)
                    && board.getForienEntitymap().get(nextPos).getType() == EntityType.LADDER){
                System.out.println(player.getName() + "Found ladder");
                button.setCurrPos(board.getForienEntitymap().get(nextPos).getTo());
                return;
            }
            else if(board.getForienEntitymap().containsKey(nextPos)
                    && board.getForienEntitymap().get(nextPos).getType() == EntityType.SNAKE){
                System.out.println(player.getName() + "Found snake");
                button.setCurrPos(board.getForienEntitymap().get(nextPos).getTo());
                return;
            }else{
                button.setCurrPos(button.getCurrPos()+value);
                return;
            }
        }
    }
}
