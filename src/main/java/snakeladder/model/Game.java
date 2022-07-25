package main.java.snakeladder.model;

import main.java.snakeladder.strategy.ButtonStartStrategies;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private int boardSize;
    private Board board;
    private List<Player> players;
    private int noOfButtonsPerPlayers;
    private Dice dice;
    private int lastPlayerMovedIndex;
    private List<Player> playerRankings;
    private GameStatus gameStatus;
    private List<ButtonStartStrategies> buttonStartStrategies;

    public int getBoardSize() {
        return boardSize;
    }

    public Board getBoard() {
        return board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getNoOfButtonsPerPlayers() {
        return noOfButtonsPerPlayers;
    }

    public Dice getDice() {
        return dice;
    }

    public int getLastPlayerMovedIndex() {
        return lastPlayerMovedIndex;
    }

    public List<Player> getPlayerRankings() {
        return playerRankings;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public List<ButtonStartStrategies> getButtonStartStrategies() {
        return buttonStartStrategies;
    }

    private Game(){
        this.lastPlayerMovedIndex = -1;
        this.players = new ArrayList<>();
        this.buttonStartStrategies = new ArrayList<>();
        this.playerRankings = new ArrayList<>();
        this.gameStatus = GameStatus.INPROGRESS;
    }

    public static GameBuilder builder(){
        return new GameBuilder();
    }

    public static class GameBuilder{
        private int boardSize;
        private List<Player> players;
        private int noOfButtonsPerPlayers;
        private List<ButtonStartStrategies> buttonStartStrategies;

        public GameBuilder(){
            players = new ArrayList<>();
            buttonStartStrategies = new ArrayList<>();
        }

        public GameBuilder addPlayers(List<Player> players){
            this.players.addAll(players);
            return this;
        }
        public GameBuilder addPlayer(Player player){
            this.players.add(player);
            return this;
        }

        public GameBuilder addButtonWinninfStrategies(List<ButtonStartStrategies> buttonStartStrategies){
            this.buttonStartStrategies.addAll(buttonStartStrategies);
            return this;
        }
        public GameBuilder addButtonWinninfStrategy(ButtonStartStrategies buttonStartStrategies){
            this.buttonStartStrategies.add(buttonStartStrategies);
            return this;
        }

        public GameBuilder setBoardSize(int size){
            this.boardSize = size;
            return this;
        }

        public GameBuilder setNoOfButtonPerPlayer(int noOfButtonPerPlayer){
            this.noOfButtonsPerPlayers = noOfButtonPerPlayer;
            return this;
        }

        public Game build() throws Exception {
            //do validation

            if(this.players.size()<2){
                throw new Exception("Players are not sufficient to play the game");
            }

            Game game = new Game();
            game.board= new Board(this.boardSize);
            game.noOfButtonsPerPlayers = this.noOfButtonsPerPlayers;
            game.buttonStartStrategies = this.buttonStartStrategies;
            game.players = this.players;
            return game;
        }
    }

}
