package nl.camorobot.stormbird.objects.coins;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import nl.camorobot.stormbird.player.Player;

import java.util.Arrays;
import java.util.List;

public class SilverCoin extends DynamicSpriteEntity implements Coin, SceneBorderCrossingWatcher, Collided {

    private Player player;

    private double x;
    private double y;
    private int coinValue = 1;

    public int tubeNumber;
    private List<Integer> coinPosition = Arrays.asList(250, 350, 450, 550);

    public SilverCoin(Player player, double x, double y){
        super("sprites/silverCoin.png", new Coordinate2D(x, y), new Size(80,80));
        this.player = player;
        this.x = x;
        this.y = y;
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setMotion(6, 270d);
    }

    @Override
    public void incrementCoins() {
        int currentCoins = player.getCoins();
        player.setCoins(currentCoins + coinValue);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        setAnchorLocation(new Coordinate2D(x + 50, coinPosition.get(tubeNumber)));
    }

    public void setTubeNumber(int tubeNumber) {
        this.tubeNumber = tubeNumber;
    }

    @Override
    public void onCollision(List<Collider> list) {
        incrementCoins();
    }
}
