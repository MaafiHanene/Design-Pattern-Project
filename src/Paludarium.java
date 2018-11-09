import java.awt.Color;
import java.util.Iterator;

import Enum.Habitat;
import Enum.TypeSol;


public class Paludarium extends Enclos {

    public Paludarium(int id, double lng, double lrg, int max, TypeSol type, double sur) {
        super(id, lng, lrg, max);
        this.typeSol = type;
        this.surface_eau = sur;
    }

    private TypeSol typeSol;
    private double surface_eau;

    public boolean marche(Animal a) {
        boolean resultat = false;
        if (a.getEspece().getHabitat() == Habitat.terre_eau) resultat = true;
        Iterator<Animal> it = animaux.iterator();
        while (it.hasNext()) {
            if (!a.marche(it.next())) resultat = false;
        }
        return resultat;
    }

    @Override
    public void colorier() {
        PlanZoo.cases.get(this.getAdr()).setBackground(Color.GREEN);

    }

    public String toString() {
        // TODO Auto-generated method stub
        return "Paludarium" + String.valueOf(identifiant);
    }
}
