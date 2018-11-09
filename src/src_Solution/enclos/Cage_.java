package src_Solution.enclos;

import Enum.*;
import src_Solution.*;
import src_Solution.espece.*;


import java.awt.*;
import java.util.Iterator;

public class Cage_ extends Enclos_ {

    private TypeSol typeSol;

    public Cage_(int id, double lng, double lrg, int max, TypeSol typesol) {
        super(id, lng, lrg, max);
        this.typeSol = typesol;
        // TODO Auto-generated constructor stub
    }


    public boolean marche(Animal_ a) {
        boolean resultat = false;
        if (a.getEspece() instanceof Vertebre_) {
            resultat = true;
        }
        Iterator<Animal_> it = animaux.iterator();
        while (it.hasNext()) {
            if (!a.marche(it.next())) resultat = false;
        }
        return resultat;
    }

    @Override
    public void colorier() {
        PlanZoo.cases.get(this.getAdr()).setBackground(new Color(139, 69, 19));

    }

    public String toString() {
        // TODO Auto-generated method stub
        return "Cage" + String.valueOf(identifiant);
    }
}
