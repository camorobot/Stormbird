package nl.camorobot.stormbird.dao;

import nl.camorobot.stormbird.player.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerDAO {
    private Player player;

    public PlayerDAO(Player player){
        this.player = player;
    }

    public void retrievePlayer(Connection con, int player_id){
        String SQL = "SELECT * FROM [players] WHERE [player_id] = ?";

        try{
            PreparedStatement stmt = con.prepareStatement(SQL);
            stmt.setString(1, String.valueOf(player_id));
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                player.setPlayer_id(rs.getInt("playlist_id"));
                player.setUsername(rs.getString("username"));
                player.setHighScore(rs.getInt("highscore"));
                player.setCoins(rs.getInt("coins"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
