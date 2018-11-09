package src_Problem01;


import Enum.EtatSante;
import Enum.RegimeAlimentaire;

public class Animal_ {
	
	private int identifiant;
    private static int nb;
    private String dateNaissance;
    private double poids;
    private EtatSante etatSante;
    private String[] parents;
    private boolean present;
    private Espece_ espece;
    private Enclos_ enclos;
    private String race;

    public Animal_(Espece_ espece) {
        nb++;
        this.espece = espece;
    }

    public Animal_(String dateNaissance, double poids, EtatSante etat, Espece_ espece, String race) {
        nb++;
        this.dateNaissance = dateNaissance;
        this.identifiant = nb;
        this.poids = poids;
        this.etatSante = etat;
        this.espece = espece;
        this.race = race;
    }

    public Animal_() {

    }

    public Espece_ getEspece() {
        return this.espece;
    }
    public void setSante(EtatSante e) {
        this.etatSante = e;
    }
    public double getPoids() {
        return poids;
    }
    public void setRace(String text) {
        this.race = text;

    }
    public void setDate(String text) {
        this.dateNaissance = text;

    }
    public void setEspece(Espece_ esp1) {
        this.espece = esp1;
    }
    public void setPoids(int parseInt) {
        this.poids = parseInt;

    }



    public boolean marche(Animal_ a) {
        boolean resultat = false;
        if (a.getEspece() == this.espece || (a.getEspece().getRegime() == RegimeAlimentaire.Herbivore
                && this.getEspece().getRegime() == RegimeAlimentaire.Herbivore))
            resultat = true;
        return resultat;
    }



    


}
