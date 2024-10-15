/*public class Statistiques {
    private int nombrePoints;
    private int nombrePasses;
    private int nombreFautes;
    private int tempsDeJeu;

    public Statistiques(int nombrePoints, int nombrePasses, int nombreFautes, int tempsDeJeu) {
        this.nombrePoints = nombrePoints;
        this.nombrePasses = nombrePasses;
        this.nombreFautes = nombreFautes;
        this.tempsDeJeu = tempsDeJeu;
    }

    public int getNombrePoints() {
        return nombrePoints;
    }

    public int getNombrePasses() {
        return nombrePasses;
    }

    public int getNombreFautes() {
        return nombreFautes;
    }

    public int getTempsDeJeu() {
        return tempsDeJeu;
    }

    

import java.awt.datatransfer.StringSelection;
*/

public class Statistiques {
    private String joueurNom;
    private int nombrePoints;
    private int nombrePasses;
    private int nombreFautes;
    private int tempsDeJeu;

    public Statistiques(String joueurNom, int nombrePoints, int nombrePasses, int nombreFautes, int tempsDeJeu) {
        this.joueurNom = joueurNom;
        this.nombrePoints = nombrePoints;
        this.nombrePasses = nombrePasses;
        this.nombreFautes = nombreFautes;
        this.tempsDeJeu = tempsDeJeu;

    }

    @Override

    /*
     * public String toString() {
     * return Nom:"+ joueurNom +", Points: " + nombrePoints + ", Passes: "
     * + nombrePasses + ", Fautes: " + nombreFautes
     * + ", Temps de jeu: " + tempsDeJeu + " min";
     * }
     */
    public String toString() {
        return "Nom: " + joueurNom + ", Points: " + nombrePoints + ", Passes: " + nombrePasses +
                ", Fautes: " + nombreFautes + ", Temps de jeu: " + tempsDeJeu + " min";
    }
}
