package nl.camorobot.stormbird.dao;

import nl.camorobot.stormbird.player.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PlayerDAO {
    private Player player;
    private ArrayList<Integer> dropSkins = new ArrayList<Integer>();

    public PlayerDAO(Player player){
        this.player = player;
    }

    public void retrievePlayer(Connection con, String _username){
        String SQL = "SELECT * FROM players p JOIN player_skins ps on p.player_id = ps.player_id WHERE p.username = ?";

        try{
            PreparedStatement stmt = con.prepareStatement(SQL);
            stmt.setString(1, String.valueOf(_username));
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                player.setPlayer_id(rs.getInt("player_id"));
                player.setUsername(rs.getString("username"));
                player.setHighScore(rs.getInt("hightScore"));
                player.setCoins(rs.getInt("coins"));
                dropSkins.add(rs.getInt("skin_id"));
            }
            player.setSkins(dropSkins);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void buyBird(Connection con, int player_id, int bird_id ) throws SQLException {
        String SQL = "INSERT INTO [player_skins] VALUES (?,?)";
        PreparedStatement stmt = con.prepareStatement(SQL);
        stmt.setInt(1, player_id);
        stmt.setInt(2, bird_id);
        stmt.executeUpdate();
    }
}
