package main.java.snakeladder.simulator;

import main.java.snakeladder.controler.GameControler;
import main.java.snakeladder.model.*;
import main.java.snakeladder.strategy.ButtonStartStrategies;
import main.java.snakeladder.strategy.ButtonWithSixStartStrategy;
import main.java.snakeladder.strategy.NormalPlayerMoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class GameSimulator {

    public static void main(String[] args) {

        ButtonStartStrategies buttonStartStrategy = new ButtonWithSixStartStrategy();
        List<ButtonStartStrategies> buttonStartStrategies = new ArrayList<>();
        buttonStartStrategies.add(buttonStartStrategy);

        List<Player> players = new ArrayList<>();

        Player player1 = new Player();
        player1.setPlayerStatus(PlayerStatus.IN_GAME);
        player1.setId(1);
        player1.setName("Sanjiv");
        player1.setPlayerMoveStrategy(new NormalPlayerMoveStrategy());

        Player player2 = new Player();
        player2.setPlayerStatus(PlayerStatus.IN_GAME);
        player2.setId(2);
        player2.setName("Takshvi");
        player2.setPlayerMoveStrategy(new NormalPlayerMoveStrategy());

        players.add(player1);
        players.add(player2);
        List<ForienEntity> foreignEntities = new ArrayList<>();
        foreignEntities.add(new Snake(97, 41));
        foreignEntities.add(new Snake(88, 3));
        foreignEntities.add(new Snake(79, 45));
        foreignEntities.add(new Snake(28, 10));
        foreignEntities.add(new Ladder(5, 42));
        foreignEntities.add(new Ladder(21, 83));
        foreignEntities.add(new Ladder(38, 52));
        foreignEntities.add(new Ladder(65, 85));
        GameControler gameControler = new GameControler();
        Game game = gameControler.createGame(players,
                100,
                2,
                buttonStartStrategies,
                foreignEntities
        );

        while(!game.getGameStatus().equals(GameStatus.ENDED)){
            gameControler.makeMove(game);
            System.out.println("............................Current Status Of Each Player is ................................");
            for(Player player : game.getPlayers()){
                System.out.print(player.getName() + " has buttons at postion : ");
                for(Button button : player.getButtons()){
                    System.out.print(" "+button.getCurrPos());
                }
                System.out.println("      ");
            }
        }
        System.out.println("..................Game Ended...................................");
        for(Player player : game.getPlayerRankings()){
            System.out.print(player.getName() +" ");
        }
        System.out.println(" ");
    }
}
