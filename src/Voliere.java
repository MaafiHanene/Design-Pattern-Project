import java.awt.Color;
import java.util.Iterator;

import Enum.Barriere;
import Enum.Habitat;


public class Voliere extends Enclos {

    public Voliere(int id, double lng, double lrg, int max, double hauteur) {
        super(id, lng, lrg, max);
        this.barriere = Barriere.Fer;
        this.hauteur = hauteur;
        // TODO Auto-generated constructor stub
    }

    private double hauteur;
    private Barriere barriere;

    public boolean marche(Animal a) {
        boolean resultat = false;
        if (a.getEspece() instanceof Oiseau) resultat = true;
        Iterator<Animal> it = animaux.iterator();
        while (it.hasNext()) {
            if (!a.marche(it.next())) resultat = false;
        }
        return resultat;
    }

    @Override
    public void colorier() {
        PlanZoo.cases.get(this.getAdr()).setBackground(Color.YELLOW);

    }

    public String toString() {
        // TODO Auto-generated method stub
        return "Voliere" + String.valueOf(identifiant);
    }

}
