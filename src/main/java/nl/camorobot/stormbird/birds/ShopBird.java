package nl.camorobot.stormbird.birds;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;

public class ShopBird extends SpriteEntity implements MouseButtonPressedListener {

    private int _price;
    private String _sprite;

    public ShopBird(String sprite, Coordinate2D initialLocation, Integer price) {
        super(sprite, initialLocation, new Size(60,60));
        this._sprite = sprite;
        this._price = price;
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        System.out.println(_sprite);
    }
}
