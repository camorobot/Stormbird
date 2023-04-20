package nl.camorobot.stormbird.assets.buttons;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;
import nl.camorobot.stormbird.assets.text.PlayerUsernameText;
import nl.camorobot.stormbird.scenes.TitleScene;

import java.util.Objects;

public class PlayerButton extends SpriteEntity implements MouseButtonPressedListener {
    private PlayerUsernameText _playerUsernameText;
    private TitleScene _titileScene;

    public PlayerButton(PlayerUsernameText _playerUsernameText, Coordinate2D coordinate2D, TitleScene _titileScene){
        super("sprites/player.png", coordinate2D, new Size(100,100));
        this._playerUsernameText = _playerUsernameText;
        this._titileScene = _titileScene;
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        if(Objects.equals(_playerUsernameText.getUsernameText(), "Kevin") || Objects.equals(_playerUsernameText.getUsernameText(), "Player: Kevin")){
            if(Objects.equals(_playerUsernameText.getUsernameText(), "Kevin")) {
                _playerUsernameText.setPlayerUsernameText("Player: Kevin",AnchorPoint.CENTER_RIGHT);
                _titileScene.setActivePlayer("Kevin");
            } else {
                _playerUsernameText.setPlayerUsernameText("Kevin",AnchorPoint.CENTER_LEFT);
                _titileScene.setActivePlayer(null);
            }
        } else{
            if(Objects.equals(_playerUsernameText.getUsernameText(), "Stormy")){
                _playerUsernameText.setPlayerUsernameText("Player: Stormy",AnchorPoint.CENTER_RIGHT);
                _titileScene.setActivePlayer("Stormy");
            } else {
                _playerUsernameText.setPlayerUsernameText("Stormy",AnchorPoint.CENTER_LEFT);
                _titileScene.setActivePlayer(null);
            }
        }
    }
}
