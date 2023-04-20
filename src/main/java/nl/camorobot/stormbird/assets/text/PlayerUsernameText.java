package nl.camorobot.stormbird.assets.text;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class PlayerUsernameText extends TextEntity {

    private String usernameText;

    public PlayerUsernameText(String usernameText, double x, double y) {
        super(new Coordinate2D(x, y));
        this.usernameText = usernameText;
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setFont(Font.font("Roboto", FontWeight.LIGHT, 25));
        setFill(Color.BLACK);
        setText(usernameText);
    }

    public void setPlayerUsernameText(String playerText, AnchorPoint AP) {
        setAnchorPoint(AP);
        setFont(Font.font("Roboto", FontWeight.LIGHT, 25));
        setFill(Color.BLACK);
        setUsernameText(playerText);
        setText(playerText);
    }

    public String getUsernameText() {
        return usernameText;
    }

    public void setUsernameText(String usernameText) {
        this.usernameText = usernameText;
    }
}

