import javax.swing.*;
import java.sql.*;

public class databaseConnector {
    Connection connection;
    Statement statement;

    public databaseConnector() {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://" + DatabaseLoginData.DBURL + ":" + DatabaseLoginData.port + "/" + DatabaseLoginData.DBname +
                            "? allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC", DatabaseLoginData.user, DatabaseLoginData.password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to connect to database", "Failed",JOptionPane.WARNING_MESSAGE);
        }
    }

    public String getDatabaseContent() {
        String result = "";
        String SQLQuery = "SELECT * FROM as30highscores ORDER BY Score DESC LIMIT 5";
        try {
            ResultSet resultSet = statement.executeQuery(SQLQuery);
            while (resultSet.next()) {
                result += "Score: " + resultSet.getInt("Score") + ", Player: " + resultSet.getString("name") + "\n";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to get content", "Failed",JOptionPane.WARNING_MESSAGE);
        }
        return result;
    }

    public void insertNewScore(String HighscoreName, int currentScore) {
        String SQLQuery = "INSERT INTO as30highscores(name, Score) VALUES ('" + HighscoreName + "', '" + currentScore + "')";
        try {
            statement.executeUpdate(SQLQuery);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to update content", "Failed",JOptionPane.WARNING_MESSAGE);
        }
    }
}