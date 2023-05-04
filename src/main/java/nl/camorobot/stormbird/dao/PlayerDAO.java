package nl.camorobot.stormbird.dao;

import nl.camorobot.stormbird.objects.coins.Coin;
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

    public void buyBird(Connection con, int player_id, int bird_id, int coins) throws SQLException {
        // buy bird
        String SQLBird = "INSERT INTO [player_skins] VALUES (?,?)";
        PreparedStatement stmtBird = con.prepareStatement(SQLBird);
        stmtBird.setInt(1, player_id);
        stmtBird.setInt(2, bird_id);
        stmtBird.executeUpdate();

        //decrease coins
        String SQLCoins = "UPDATE [players] SET coins = ? WHERE player_id = ?";
        PreparedStatement stmtCoins = con.prepareStatement(SQLCoins);
        stmtCoins.setInt(1, coins);
        stmtCoins.setInt(2, player_id);
        stmtCoins.executeUpdate();
    }

    public void updateCoins(Connection con, int player_id, int score) throws SQLException{
        int _coins = score;
        String getCurrentCoinsSQL = "SELECT coins FROM [players] where player_id = ?";
        PreparedStatement stmtGetCoins= con.prepareStatement(getCurrentCoinsSQL);
        stmtGetCoins.setInt(1, player_id);
        ResultSet rs = stmtGetCoins.executeQuery();
        while (rs.next()){
            _coins += rs.getInt("coins");
        }

        String setCoinsSQL = "UPDATE [players] set coins = ? where player_id = ?";
        PreparedStatement stmtSetCoins = con.prepareStatement(setCoinsSQL);
        stmtSetCoins.setInt(1, _coins);
        stmtSetCoins.setInt(2, player_id);
        System.out.println("updateCoins: "+ _coins);
        stmtSetCoins.executeUpdate();
    }
}
