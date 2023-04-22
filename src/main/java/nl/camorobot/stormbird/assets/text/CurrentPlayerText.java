package nl.camorobot.stormbird.assets.text;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class CurrentPlayerText extends TextEntity {

    private String _currentPlayer;
    private CurrentPlayerText _CurrentPlayerText;

    public CurrentPlayerText(String _currentPlayer, double x, double y) {
        super(new Coordinate2D(x, y));
        this._currentPlayer = _currentPlayer;
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setFont(Font.font("Roboto", FontWeight.LIGHT, 25));
        setFill(Color.BLACK);
        setText(_currentPlayer);
    }

    public String get_currentPlayer() {
        return _currentPlayer;
    }


//    public void set_currentPlayer(String playerText, AnchorPoint AP) {
//        setAnchorPoint(AP);
//        setFont(Font.font("Roboto", FontWeight.LIGHT, 25));
//        setFill(Color.BLACK);
//        setUsernameText(playerText);
//        setText(playerText);
//    }
//
//    public String getUsernameText() {
//        return _currentPlayer;
//    }
//
//    public void setUsernameText(String usernameText) {
//        this._currentPlayer = usernameText;
//    }
}

