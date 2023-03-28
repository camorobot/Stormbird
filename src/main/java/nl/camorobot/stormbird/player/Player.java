package nl.camorobot.stormbird.player;

import nl.camorobot.stormbird.Stormbird;

public class Player {
    private Stormbird stormbird;
    private int coins;

    public Player(Stormbird stormbird){
        this.stormbird = stormbird;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }
}
