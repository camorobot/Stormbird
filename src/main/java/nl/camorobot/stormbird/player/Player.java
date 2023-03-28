package nl.camorobot.stormbird.player;

import nl.camorobot.stormbird.Stormbird;

public class Player {
    private Stormbird stormbird;

    private int player_id;
    private String username;
    private int coins;
    private int highScore;

    public Player(Stormbird stormbird){
        this.stormbird = stormbird;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(int player_id) {
        this.player_id = player_id;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }
}
