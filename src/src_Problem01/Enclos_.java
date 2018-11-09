package src_Problem01;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import Exceptions.NonCompatible;

public abstract class Enclos_ implements Comparable {
    protected Set<Animal_> animaux;
    protected int identifiant;
    private double longueur;
    private double largeur;
    protected int max;
    private int adr;

    public Enclos_(int id, double lng, double lrg, int max) {
        animaux = new HashSet<Animal_>();
        this.identifiant = id;
        this.longueur = lng;
        this.largeur = lrg;
        this.max = max;
    }



    public abstract String toString();
    public abstract void colorier();
    public abstract boolean marche(Animal_ a);

    public boolean ajouterAnimal(Animal_ a) throws NonCompatible {
        if (this.marche(a))
            return animaux.add(a);
        else {
            throw new NonCompatible();
        }
    }
    public boolean supAnimal(Animal_ a) {
        return animaux.remove(a);
    }

  

    public boolean contient(Espece_ e) {
        return this.getEspeces().contains(e);
    }

    protected abstract Set<Animal_> getEspeces();



	public int getId() {
        return this.identifiant;
    }
    public int getMax() {
        return this.max;
    }
    public int getAdr() {
        return this.adr;
    }
    public void setAdr(int adr) {
        this.adr = adr;
    }
    public int nbAnimaux(Espece_ e) {
        return animaux.size();
    }
    public int nbAnim() {
        return animaux.size();
    }
    
}
