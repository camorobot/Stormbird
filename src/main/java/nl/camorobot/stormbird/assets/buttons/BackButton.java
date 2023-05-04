package nl.camorobot.stormbird.assets.buttons;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;
import nl.camorobot.stormbird.Stormbird;

public class BackButton extends SpriteEntity implements MouseButtonPressedListener {

    private Stormbird _stormbird;

    public BackButton(Stormbird stormbird, Coordinate2D coordinate2D){
        super("sprites/backButton.png", coordinate2D);
        this._stormbird = stormbird;
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        _stormbird.setActiveScene(0);
    }
}
