import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String DB_URL = "jdbc:mariadb://localhost:3307/joueurDatabase"; // Nom de la base de données
    private static final String USER = "NEYA Moussa"; // Nom d'utilisateur
    private static final String PASSWORD = "(Prince*@*2003)"; // Mot de passe
    private static Connection connection = null;

    // Méthode pour obtenir la connexion à la base de données
    public static Connection getConnection() {
        if (connection == null) { // Vérifie si la connexion n'a pas encore été établie
            try {
                Class.forName("org.mariadb.jdbc.Driver"); // Charger le pilote MariaDB
                connection = DriverManager.getConnection(DB_URL, USER, PASSWORD); // Établir la connexion
                System.out.println("Connexion réussie à la base de données joueurDatabase !");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                System.out.println("Pilote MariaDB non trouvé.");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Échec de la connexion à la base de données.");
            }
        }
        return connection; // Retourne la connexion
    }
}

