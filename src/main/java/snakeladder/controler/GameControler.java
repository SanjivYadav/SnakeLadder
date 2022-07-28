package main.java.snakeladder.controler;

import main.java.snakeladder.model.ForienEntity;
import main.java.snakeladder.model.Game;
import main.java.snakeladder.model.GameStatus;
import main.java.snakeladder.model.Player;
import main.java.snakeladder.strategy.ButtonStartStrategies;

import java.util.List;

public class GameControler {
    public Game createGame(List<Player> players, int boardSize, int noOfButtonsPerPlayer,
                           List<ButtonStartStrategies> buttonStartStrategies,
                           List<ForienEntity> forienEntities){

        try {
            Game game = Game.builder()
                    .addPlayers(players)
                    .setBoardSize(boardSize)
                    .setNoOfButtonPerPlayer(noOfButtonsPerPlayer)
                    .addButtonStartStrategies(buttonStartStrategies)
                    .addForienEntities(forienEntities)
                    .build();
            return game;
        } catch (Exception e) {
            throw new RuntimeException("Something went wrong. Please try again ....!");
        }
    }

    public GameStatus checkGameStatus(Game game){
        return game.getGameStatus();
    }

    public List<Player> checkRanking(Game game){
        if(game.getGameStatus().equals(GameStatus.ENDED))
            return game.getPlayerRankings();
        return null;
    }

    public void makeMove(Game game){
       game.makeMove();
       if(game.getPlayersInGame().size()==1)
           game.setGameStatus(GameStatus.ENDED);
    }
}
