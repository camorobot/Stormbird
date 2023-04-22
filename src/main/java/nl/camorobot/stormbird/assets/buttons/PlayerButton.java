package nl.camorobot.stormbird.assets.buttons;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;
import nl.camorobot.stormbird.assets.text.CurrentPlayerText;
import nl.camorobot.stormbird.dao.DatabaseDAO;
import nl.camorobot.stormbird.dao.PlayerDAO;
import nl.camorobot.stormbird.player.Player;

public class PlayerButton extends SpriteEntity implements MouseButtonPressedListener {
    private CurrentPlayerText _playerUsernameText;
    private String _username;
    private String _sprite;
    private Player _player;

    public PlayerButton(String sprite, Coordinate2D coordinate2D, String _username, Size size, Player _player){
        super(sprite, coordinate2D, size);
        this._sprite = sprite;
        this._username = _username;
        this._player = _player;
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        _player.setUsername(_username);
        DatabaseDAO _databaseDAO = new DatabaseDAO();
        PlayerDAO playerDAO = new PlayerDAO(_player);
        playerDAO.retrievePlayer(_databaseDAO.connect(), _username);
        System.out.println(_player.toString());
    }
}
