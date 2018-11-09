package src_Solution.enclos;

import src_Solution.*;
import Enum.*;
import src_Solution.espece.*;

import java.awt.*;
import java.util.Iterator;

public class Insectarium_ extends Enclos_ {

    private Barriere barriere;

    public Insectarium_(int id, double lng, double lrg, int max) {
        super(id, lng, lrg, max);
        this.barriere = Barriere.Verre;
    }


    public boolean marche(Animal_ a) {
        boolean resultat = false;
        if (a.getEspece() instanceof Invertebre_ && a.getEspece().getHabitat() != Habitat.eau) resultat = true;
        Iterator<Animal_> it = animaux.iterator();
        while (it.hasNext()) {
            if (!a.marche(it.next())) resultat = false;
        }
        return resultat;
    }

    @Override
    public void colorier() {
        PlanZoo.cases.get(this.getAdr()).setBackground(Color.ORANGE);

    }

    public String toString() {
        // TODO Auto-generated method stub
        return "Insectarium" + String.valueOf(identifiant);
    }
}
