import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:sqlite:BDD/IDLS_M.db"; // chemin relatif vers le fichier

    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(URL);
            System.out.println("Connexion réussie");
            return conn;
        } catch (SQLException ex) {
            System.out.println("Erreur de connexion à la base de données : " + ex.getMessage());
            return null;
        }
    }
}
