package nl.camorobot.stormbird.assets.text;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class PlayerUsernameText extends TextEntity {

    String username;

    public PlayerUsernameText(String username, double x, double y) {
        super(new Coordinate2D(x,y));
        this.username = username;
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setFont(Font.font("Roboto", FontWeight.LIGHT, 25));
        setFill(Color.BLACK);
        setText(username);
    }

    public void setPlayerUsernameText(){

    }

    public void setBigPlayerUsernameText(String username){
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));
        setFill(Color.ORANGE);
        setText(username);
    }

    public void setSmallPlayerUsernameText(String username){

    }

    public String getUsername() {
        return username;
    }
}
