
/*public class Joueur {
    private String nom;
    private String prenom;
    private String position;
    private int numeroMaillot;
    private int pointsCumules;
    private int passesCumulees;
    private int fautesCumulees;
    private int minutesCumulees;

    public Joueur(String nom, String prenom, String position, int numeroMaillot) {
        this.nom = nom;
        this.prenom = prenom;
        this.position = position;
        this.numeroMaillot = numeroMaillot;
        this.pointsCumules = 0;
        this.passesCumulees = 0;
        this.fautesCumulees = 0;
        this.minutesCumulees = 0;
    }

    public void ajouterStatistiques(int points, int passes, int fautes, int minutes) {
        this.pointsCumules += points;
        this.passesCumulees += passes;
        this.fautesCumulees += fautes;
        this.minutesCumulees += minutes;
    }

    public int getPointsCumules() {
        return pointsCumules;
    }

    public int getPassesCumulees() {
        return passesCumulees;
    }

    public int getFautesCumulees() {
        return fautesCumulees;
    }

    public int getMinutesCumulees() {
        return minutesCumulees;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return nom + " " + prenom + " - " + position + " (#" + numeroMaillot + ")";
    }
}


public class Joueur {
    private String nom;
    private String prenom;
    private String poste;
    private String equipe; // Exemple d'attribut supplémentaire
    private int age;

    // Constructeur attendu
    public Joueur(String nom, String prenom, String poste, String equipe, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.poste = poste;
        this.equipe = equipe;
        this.age = age;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return nom + " - " + prenom + "-" + poste + " - " + equipe + " - "
                + " N“" + age;
    }
}

 */

public class Joueur {
    private String nom;
    private String prenom;
    private String poste;
    private String equipe;
    private int numeroMaillot;

    // Constructeur
    public Joueur(String nom, String prenom, String poste, String equipe, int numeroMaillot) {
        this.nom = nom;
        this.prenom = prenom;
        this.poste = poste;
        this.equipe = equipe;
        this.numeroMaillot = numeroMaillot;
    }

    // Getters
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getPoste() {
        return poste;
    }

    public String getEquipe() {
        return equipe;
    }

    public int getNumeroMaillot() {
        return numeroMaillot;
    }

    // Setters (optionnel si vous voulez modifier les valeurs)
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }

    public void setNumeroMaillot(int numeroMaillot) {
        this.numeroMaillot = numeroMaillot;
    }
}

