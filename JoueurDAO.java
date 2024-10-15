import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class JoueurDAO {
    public void ajouterJoueur(Joueur joueur) {
        Connection connection = DatabaseConnection.getConnection();
        if (connection != null) {
            try {
                String query = "INSERT INTO joueur (nom, prenom, poste, equipe, numeroMaillot) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, joueur.getNom());
                preparedStatement.setString(2, joueur.getPrenom());
                preparedStatement.setString(3, joueur.getPoste());
                preparedStatement.setString(4, joueur.getEquipe());
                preparedStatement.setInt(5, joueur.getNumeroMaillot());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Connexion à la base de données échouée.");
        }
    }
}


