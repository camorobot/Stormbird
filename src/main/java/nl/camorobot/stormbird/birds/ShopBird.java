package nl.camorobot.stormbird.birds;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;
import nl.camorobot.stormbird.dao.DatabaseDAO;
import nl.camorobot.stormbird.dao.PlayerDAO;
import nl.camorobot.stormbird.player.Player;

import java.sql.SQLException;
import java.util.Objects;

public class ShopBird extends SpriteEntity implements MouseButtonPressedListener {

    private int _price;
    private String _sprite;
    private Player _player;

    public ShopBird(String sprite, Coordinate2D initialLocation, Integer price, Player player) {
        super(sprite, initialLocation, new Size(60,60));
        this._sprite = sprite;
        this._price = price;
        this._player = player;
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        System.out.println(_sprite);
        try {
            buyBird(_sprite, _player.getPlayer_id());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void buyBird(String _sprite, int player_id) throws SQLException {
        System.out.println(_player.getCoins());
        if(_player.getCoins() <100){
            System.out.println("Sorry je hebt geeng geld.");
        } else{
            int bird_id = 0;
            if(_sprite.equals("sprites/yellowbird-midflap.png")){
                bird_id = 1;
            }
            if(_sprite.equals("sprites/bluebird-midflap.png")){
                bird_id = 2;
            }
            if(_sprite.equals("sprites/redbird-midflap.png")){
                bird_id = 3;
            }
            if(_sprite.equals("sprites/pinkbird-midflap.png")){
                bird_id = 1002;
            }
            if(_sprite.equals("sprites/greenbird-midflap.png")){
                bird_id = 1003;
            }
            PlayerDAO playerDAO = new PlayerDAO(_player);
            DatabaseDAO databaseDAO = new DatabaseDAO();
            playerDAO.buyBird(databaseDAO.connect(), player_id, bird_id, _player.getCoins() - 100);
            _player.setCoins(_player.getCoins() - 100);
        }

    }
}
