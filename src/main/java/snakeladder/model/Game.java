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

    private int no_of_snake;
    private int no_of_ladder;

    public int getNo_of_snake() {
        return no_of_snake;
    }

    public int getNo_of_ladder() {
        return no_of_ladder;
    }

    private List<Player> playerRankings;

    private List<Player> playersInGame;

    List<ForienEntity> forienEntities;

    public List<Player> getPlayersInGame() {
        return playersInGame;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

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
        this.playersInGame = new ArrayList<>();
        this.forienEntities = new ArrayList<>();
    }

    public static GameBuilder builder(){
        return new GameBuilder();
    }

    public static class GameBuilder{
        private int boardSize;
        private List<Player> players;
        private int noOfButtonsPerPlayers;

        List<ForienEntity> forienEntities;
        private List<ButtonStartStrategies> buttonStartStrategies;

        public GameBuilder(){
            players = new ArrayList<>();
            buttonStartStrategies = new ArrayList<>();
            forienEntities = new ArrayList<>();
        }

        public GameBuilder addPlayers(List<Player> players){
            this.players.addAll(players);
            return this;
        }
        public GameBuilder addPlayer(Player player){
            this.players.add(player);
            return this;
        }

        public GameBuilder addButtonStartStrategies(List<ButtonStartStrategies> buttonStartStrategies){
            this.buttonStartStrategies.addAll(buttonStartStrategies);
            return this;
        }
        public GameBuilder addButtonStartStrategy(ButtonStartStrategies buttonStartStrategies){
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

        public GameBuilder addForienEntities(List<ForienEntity> forienEntities) {
            this.forienEntities.addAll(forienEntities);
            return this;
        }

        public Game build() throws Exception {
            //do validation

            if(this.players.size()<2){
                throw new Exception("Players are not sufficient to play the game");
            }

            Game game = new Game();
            game.board= new Board(this.boardSize,forienEntities);
            game.noOfButtonsPerPlayers = this.noOfButtonsPerPlayers;
            game.buttonStartStrategies = this.buttonStartStrategies;
            for(Player player : this.players){
                List<Button> buttons = new ArrayList<>();
                for(int i=0;i<noOfButtonsPerPlayers;i++){
                    Button button = new Button();
                    button.setButtonStatus(ButtonStatus.LOCKED);
                    button.setCurrPos(-1);
                    button.addButtonStartStrategies(this.buttonStartStrategies);
                    buttons.add(button);
                }
                player.setButtons(buttons);
            }
            game.players = this.players;
            game.playersInGame.addAll(this.players);
            Dice dice = new Dice();
            dice.setMax_no(6);
            game.dice = dice;
            return game;
        }
    }


    public void makeMove(){
        this.lastPlayerMovedIndex = (this.lastPlayerMovedIndex +1)%this.playersInGame.size();
        Player player = this.playersInGame.get(this.lastPlayerMovedIndex);
        int diceValue = player.makeMove(this.board, this.dice);
        if(diceValue == 6)
            this.lastPlayerMovedIndex = (this.lastPlayerMovedIndex -1+this.playersInGame.size())%this.playersInGame.size();

        if(player.checkIfWon()){
            player.setPlayerStatus(PlayerStatus.COMPLETED);
            this.playerRankings.add(player);
            this.playersInGame.remove(player);
        }

    }

}
