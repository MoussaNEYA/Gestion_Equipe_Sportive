
import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class GestionEquipeSportive extends JFrame {
    private ArrayList<Joueur> joueurs;
    private ArrayList<Match> matchs;
    private ArrayList<Statistiques> statistiques;
    private DefaultListModel<Joueur> modelJoueurs;
    private DefaultListModel<Match> modelMatchs;
    private DefaultListModel<Statistiques> modelStatistiques;

    public GestionEquipeSportive() {
        joueurs = new ArrayList<>();
        matchs = new ArrayList<>();
        statistiques = new ArrayList<>();
        modelJoueurs = new DefaultListModel<>();
        modelMatchs = new DefaultListModel<>();
        modelStatistiques = new DefaultListModel<>();

        // Configuration de la fenêtre principale
        setTitle("---------------GESTION D'UNE ÉQUIPE SPORTIVE---------------");
        setSize(800, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Personnalisation de l'interface graphique
        /*jLabel1.setFont(new java.awt.Font("Serif", 3, 24)); // NOI18N
        jLabel1.setText("                                                GESTION D'UNE EQUIPE SPORTIVE");*/
        UIManager.put("Button.font", new Font("Serif", Font.ITALIC, 18));
        UIManager.put("Panel.background", Color.decode("#dbadad"));//#f0f0f0
        UIManager.put("Button.background", Color.decode("#0d0909"));//#4CAF50
        UIManager.put("Button.foreground", Color.WHITE);

        // Création du panneau de menu
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(9, 6, 15, 10));
        menuPanel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));

        // Boutons d'actions
        JButton btnAjouterJoueur = new JButton("Ajouter un Joueur");
        JButton btnAfficherJoueurs = new JButton("Afficher les Joueurs");
        JButton btnAjouterMatch = new JButton("Ajouter un Match");
        JButton btnAfficherMatchs = new JButton("Afficher les Matchs");
        JButton btnAjouterStatistiques = new JButton("Ajouter des Statistiques");
        JButton btnAfficherStatistiques = new JButton("Afficher les Statistiques");

        // Ajout des boutons au panneau de menu
        menuPanel.add(btnAjouterJoueur);
        menuPanel.add(btnAfficherJoueurs);
        menuPanel.add(btnAjouterMatch);
        menuPanel.add(btnAfficherMatchs);
        menuPanel.add(btnAjouterStatistiques);
        menuPanel.add(btnAfficherStatistiques);

        // Ajout du panneau de menu à la fenêtre
        add(menuPanel, BorderLayout.WEST);

        // Gestion des actions des boutons
        btnAjouterJoueur.addActionListener(e -> ajouterJoueur());
        btnAfficherJoueurs.addActionListener(e -> afficherJoueurs());
        btnAjouterMatch.addActionListener(e -> ajouterMatch());
        btnAfficherMatchs.addActionListener(e -> afficherMatchs());
        btnAjouterStatistiques.addActionListener(e -> ajouterStatistiques());
        btnAfficherStatistiques.addActionListener(e -> afficherStatistiques());

        // Rendre la fenêtre visible
        setVisible(true);
    }

    // Méthode pour ajouter un joueur
    private void ajouterJoueur() {
        String nom = JOptionPane.showInputDialog(this, "Entrez le nom du joueur:");
        String prenom = JOptionPane.showInputDialog(this, "Entrez le prénom du joueur:");
        String poste = JOptionPane.showInputDialog(this, "Entrez le poste du joueur:");
        String equipe = JOptionPane.showInputDialog(this, "Entrez l'équipe du joueur:");
        String numeroMaillotstr = JOptionPane.showInputDialog(this, "Entrez le dossard du joueur:");

        try {
            int numeroMaillot = Integer.parseInt(numeroMaillotstr);
            if (nom != null && prenom != null && poste != null && equipe != null && !nom.isEmpty() && !prenom.isEmpty()
                    && !poste.isEmpty() && !equipe.isEmpty()) {
                Joueur joueur = new Joueur(nom, prenom, poste, equipe, numeroMaillot);
                joueurs.add(joueur); // Ajout au modèle local (liste)
                modelJoueurs.addElement(joueur);

                // Appel à la méthode pour ajouter à la base de données
                JoueurDAO joueurDAO = new JoueurDAO();
                joueurDAO.ajouterJoueur(joueur);

                JOptionPane.showMessageDialog(this, "Joueur ajouté avec succès !");
            } else {
                JOptionPane.showMessageDialog(this, "Informations invalides !");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Dossard invalide !");
        }
    }


    // Méthode pour afficher la liste des joueurs
    private void afficherJoueurs() {
        JList<Joueur> listJoueurs = new JList<>(modelJoueurs);
        JOptionPane.showMessageDialog(this, new JScrollPane(listJoueurs), "Liste des Joueurs",
                JOptionPane.INFORMATION_MESSAGE);
    }

    // Méthode pour ajouter un match
    private void ajouterMatch() {
        String equipeAdverse = JOptionPane.showInputDialog(this, "Entrez le nom de l'équipe adverse:");
        String dateStr = JOptionPane.showInputDialog(this, "Entrez la date du match (jj/mm/aaaa):");
        String scoreLocaleStr = JOptionPane.showInputDialog(this, "Entrez le score de l'équipe locale:");
        String scoreAdverseStr = JOptionPane.showInputDialog(this, "Entrez le score de l'équipe adverse:");

        try {
            int scoreLocale = Integer.parseInt(scoreLocaleStr);
            int scoreAdverse = Integer.parseInt(scoreAdverseStr);
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateStr);

            if (equipeAdverse != null && !equipeAdverse.isEmpty()) {
                // Exemple d'ajout de joueurs participants (ici, la liste des joueurs actuels)
                Match match = new Match(date, equipeAdverse, scoreLocale, scoreAdverse, joueurs); // Ajustez ici selon
                // votre constructeur
                matchs.add(match);
                modelMatchs.addElement(match);
                JOptionPane.showMessageDialog(this, "Match ajouté avec succès !");
            } else {
                JOptionPane.showMessageDialog(this, "Informations invalides !");
            }
        } catch (NumberFormatException | ParseException e) {
            JOptionPane.showMessageDialog(this, "Entrées invalides !");
        }
    }

    // Méthode pour afficher la liste des matchs
    private void afficherMatchs() {
        JList<Match> listMatchs = new JList<>(modelMatchs);
        JOptionPane.showMessageDialog(this, new JScrollPane(listMatchs), "Liste des Matchs",
                JOptionPane.INFORMATION_MESSAGE);
    }

    // Méthode pour ajouter des statistiques

    private void ajouterStatistiques() {
        String joueurNom = JOptionPane.showInputDialog(this, "Entrez le nom du joueur:");
        String points = JOptionPane.showInputDialog(this, "Entrez le nombre de points:");
        String passes = JOptionPane.showInputDialog(this, "Entrez le nombre de passes:");
        String fautes = JOptionPane.showInputDialog(this, "Entrez le nombre de fautes:");
        String tempsJeu = JOptionPane.showInputDialog(this, "Entrez le temps de jeu (en minutes):");

        try {
            int nbPoints = Integer.parseInt(points);
            int nbPasses = Integer.parseInt(passes);
            int nbFautes = Integer.parseInt(fautes);
            int temps = Integer.parseInt(tempsJeu);

            // Récupération du joueur par son nom
            Joueur joueur = joueurs.stream()
                    .filter(j -> j.getNom().equalsIgnoreCase(joueurNom)) // Assurez-vous que getNom() existe
                    .findFirst()
                    .orElse(null);

            if (joueur != null) {
                // Création de l'objet statistiques
                Statistiques stats = new Statistiques(joueurNom, nbPoints, nbPasses, nbFautes, temps);
                statistiques.add(stats);
                modelStatistiques.addElement(stats);

                // Ajout des statistiques dans la base de données
                try (Connection conn = DatabaseConnection.getConnection();
                     PreparedStatement stmt = conn.prepareStatement(
                             "INSERT INTO statistiques (joueur_nom, nombrePoints, nombrePasses, nombreFautes, tempsDeJeu) VALUES (?, ?, ?, ?, ?)")) {

                    stmt.setString(1, joueurNom);
                    stmt.setInt(2, nbPoints);
                    stmt.setInt(3, nbPasses);
                    stmt.setInt(4, nbFautes);
                    stmt.setInt(5, temps);

                    int rowsInserted = stmt.executeUpdate();

                    if (rowsInserted > 0) {
                        JOptionPane.showMessageDialog(this, "Statistiques ajoutées avec succès !");
                    } else {
                        JOptionPane.showMessageDialog(this, "Erreur lors de l'ajout des statistiques.");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Erreur de connexion à la base de données.");
                }

            } else {
                JOptionPane.showMessageDialog(this, "Joueur non trouvé !");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Entrées numériques invalides !");
        }
    }

// Méthode pour afficher les statistiques
private void afficherStatistiques() {
    JList<Statistiques> listStats = new JList<>(modelStatistiques);
    JOptionPane.showMessageDialog(this, new JScrollPane(listStats), "Liste des Statistiques",
            JOptionPane.INFORMATION_MESSAGE);
}

// Méthode pour calculer les statistiques cumulées

public static void main(String[] args) {
    SwingUtilities.invokeLater(GestionEquipeSportive::new);
}
}