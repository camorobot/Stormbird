package nl.camorobot.stormbird.assets.text;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class CoinsText extends TextEntity {
    private int _coins;
    private boolean _owned;

    public CoinsText(Coordinate2D initialLocation, int coins, boolean owned) {
        super(initialLocation);
        this._coins = coins;
        this._owned = owned;
        setFont(Font.font("Roboto", FontWeight.NORMAL, 30));
        setFill(Color.BLACK);
        if(owned) {
            setAnchorPoint(AnchorPoint.TOP_CENTER);
            setText("Owned");
        }
        else {
            setCoins(coins);
        }
    }

    public void setCoins(int coins){
        this._coins = coins;
        setText(String.valueOf(coins));
    }

    public void setTextVisibility(boolean visible) {
        this.setVisible(visible);
    }

}
