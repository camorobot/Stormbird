package nl.camorobot.stormbird.assets.text;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicTextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.camorobot.stormbird.observers.ScoreObserver;

import java.util.ArrayList;
import java.util.List;

public class ScoreText extends DynamicTextEntity {
    private int score;
    private List<ScoreObserver> observers;

    public ScoreText(Coordinate2D initialLocation) {
        super(initialLocation);
        setFill(Color.WHITE);
        setFont(Font.font("Arial", FontWeight.BOLD, 24));
        score = 0;
        setText("Score: " + score);
        observers = new ArrayList<>();
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
        setText("Score: " + score);
        notifyObservers();
    }

    public void addObserver(ScoreObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(ScoreObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (ScoreObserver observer : observers) {
            observer.onScoreUpdate(score);
        }
    }
}

