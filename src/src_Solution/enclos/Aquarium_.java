package src_Solution.enclos;

import src_Solution.*;
import Enum.*;

import java.awt.*;
import java.util.Iterator;

public class Aquarium_ extends Enclos_ {


    public Aquarium_(int id, double lng, double lrg, int max, double contenance, TypeEau typeEau) {
        super(id, lng, lrg, max);
        this.contenance = contenance;
        this.typeEau = typeEau;
        // TODO Auto-generated constructor stub
    }

    private double contenance;
    private TypeEau typeEau;

    public boolean marche(Animal_ a) {
        boolean resultat = false;
        if (a.getEspece().getHabitat() == Habitat.eau) resultat = true;
        Iterator<Animal_> it = animaux.iterator();
        while (it.hasNext()) {
            if (!a.marche(it.next())) resultat = false;
        }
        return resultat;
    }

    @Override
    public void colorier() {
        PlanZoo.cases.get(this.getAdr()).setBackground(Color.BLUE);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Aquarium" + String.valueOf(identifiant);
    }

}
