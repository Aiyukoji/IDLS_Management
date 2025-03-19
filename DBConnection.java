import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
private static final String URL = "jdbc:sqlite:BDD/IDLS_M.db"; // chemin relatif vers le fichier

    public static Connection getConnection() {
        try {
            System.out.println("REUSSI");            
            return DriverManager.getConnection(URL);
        } catch (SQLException ex) {
            System.out.println("Erreur de connexion à la base de données : " + ex.getMessage());
            return null;
        }
    }
}