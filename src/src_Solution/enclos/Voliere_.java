package src_Solution.enclos;

import Enum.*;
import src_Solution.*;
import src_Solution.espece.*;

import java.awt.*;
import java.util.Iterator;

public class Voliere_ extends Enclos_ {


    public Voliere_(int id, double lng, double lrg, int max, double hauteur) {
        super(id, lng, lrg, max);
        this.barriere = Barriere.Fer;
        this.hauteur = hauteur;
        // TODO Auto-generated constructor stub
    }

    private double hauteur;
    private Barriere barriere;

    public boolean marche(Animal_ a) {
        boolean resultat = false;
        if (a.getEspece() instanceof Oiseau_) resultat = true;
        Iterator<Animal_> it = animaux.iterator();
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
