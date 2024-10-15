
import java.util.Date;
import java.util.List;

public class Match {
    private Date dateMatch;
    private String nomAdversaire;
    private int scoreEquipe;
    private int scoreAdversaire;
    private List<Joueur> listeJoueurs;

    public Match(Date dateMatch, String nomAdversaire, int scoreEquipe, int scoreAdversaire,
            List<Joueur> listeJoueurs) {
        this.dateMatch = dateMatch;
        this.nomAdversaire = nomAdversaire;
        this.scoreEquipe = scoreEquipe;
        this.scoreAdversaire = scoreAdversaire;
        this.listeJoueurs = listeJoueurs;
    }

    public Date getDateMatch() {
        return dateMatch;
    }

    public void setDateMatch(Date dateMatch) {
        this.dateMatch = dateMatch;
    }

    public String getNomAdversaire() {
        return nomAdversaire;
    }

    public void setNomAdversaire(String nomAdversaire) {
        this.nomAdversaire = nomAdversaire;
    }

    public int getScoreEquipe() {
        return scoreEquipe;
    }

    public void setScoreEquipe(int scoreEquipe) {
        this.scoreEquipe = scoreEquipe;
    }

    public int getScoreAdversaire() {
        return scoreAdversaire;
    }

    public void setScoreAdversaire(int scoreAdversaire) {
        this.scoreAdversaire = scoreAdversaire;
    }

    public List<Joueur> getListeJoueurs() {
        return listeJoueurs;
    }

    @Override
    public String toString() {
        return "Match contre: " + nomAdversaire + " - Score: " + scoreEquipe + " - " + scoreAdversaire;
    }
}

/*
 * import java.util.Date;
 * import java.util.List;
 * 
 * public class Match {
 * private Date date;
 * private String equipeAdverse;
 * private int scoreEquipeLocale;
 * private int scoreEquipeAdverse;
 * private List<Joueur> joueursParticipants;
 * 
 * public Match(Date date, String equipeAdverse, int scoreEquipeLocale, int
 * scoreEquipeAdverse, List<Joueur> joueursParticipants) {
 * this.date = date;
 * this.equipeAdverse = equipeAdverse;
 * this.scoreEquipeLocale = scoreEquipeLocale;
 * this.scoreEquipeAdverse = scoreEquipeAdverse;
 * this.joueursParticipants = joueursParticipants;
 * }
 * 
 * @Override
 * public String toString() {
 * return "Match vs " + equipeAdverse + " le " + date;
 * }
 * }
 */
