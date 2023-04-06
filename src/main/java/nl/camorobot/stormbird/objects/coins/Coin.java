package nl.camorobot.stormbird.objects.coins;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import nl.camorobot.stormbird.player.Player;

import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Coin extends DynamicSpriteEntity implements SceneBorderCrossingWatcher, Collided {

    private Player player;

    private double x;
    private double y;
    private int coinValue = 1;
    private boolean coinhit = false;

    public int tubeNumber;
    private List<Integer> coinPosition = Arrays.asList(250, 350, 450, 550);

    public Coin(String sprite, Player player, double x, double y) {
        super(sprite, new Coordinate2D(x, y));
        this.player = player;
        this.x = x;
        this.y = y;
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setMotion(6, 270d);
    }

    public void incrementCoins() {
        if(!coinhit){
            coinhit = true;
            Timer timerIncrementCoins = new Timer();
            TimerTask task = new TimerTask() {
                public void run() {
                    int currentCoins = player.getCoins();
                    player.setCoins(currentCoins + coinValue);
                    coinhit = false;
                }
            };
            timerIncrementCoins.schedule(task, 1000);
        }
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        setMotion(6, 270d);
        setAnchorLocation(new Coordinate2D(x + 25, coinPosition.get(tubeNumber)));
    }

    public void setTubeNumber(int tubeNumber) {
        this.tubeNumber = tubeNumber;
    }

    @Override
    public void onCollision(List<Collider> list) {
        incrementCoins();
        remove();
    }
}
