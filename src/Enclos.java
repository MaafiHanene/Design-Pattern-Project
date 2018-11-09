import java.util.*;

import Enum.Habitat;
import Exceptions.NonCompatible;

public abstract class Enclos implements Comparable {
    protected Set<Animal> animaux;
    protected int identifiant;
    private double longueur;
    private double largeur;
    protected int max;
    private int adr;

    public Enclos(int id, double lng, double lrg, int max) {
        animaux = new HashSet<Animal>();
        this.identifiant = id;
        this.longueur = lng;
        this.largeur = lrg;
        this.max = max;
    }



    public abstract String toString();
    public abstract void colorier();
    public abstract boolean marche(Animal a);

    public boolean ajouterAnimal(Animal a) throws NonCompatible {
        if (this.marche(a))
            return animaux.add(a);
        else {
            throw new NonCompatible();
        }
    }
    public boolean supAnimal(Animal a) {
        return animaux.remove(a);
    }

    public int compareTo(Object ob) {

        int resultat = 0;
        if (this instanceof Cage) {
            resultat = -5;
        } else if (ob instanceof Cage) {
            resultat = 5;
        } else if (this instanceof Voliere) {
            resultat = -4;
        } else if (ob instanceof Voliere) {
            resultat = 4;
        } else if (this instanceof Aquarium) {
            resultat = -3;
        } else if (ob instanceof Aquarium) {
            resultat = 3;
        } else if (this instanceof Insectarium) {
            resultat = -2;
        } else if (ob instanceof Insectarium) {
            resultat = 2;
        } else if (this instanceof Paludarium) {
            resultat = -1;
        } else if (ob instanceof Paludarium) {
            resultat = -1;
        }

        return resultat;
    }

    public boolean contient(Espece e) {
        return this.getEspeces().contains(e);
    }

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
    public int nbAnimaux(Espece e) {
        return animaux.size();
    }
    public int nbAnim() {
        return animaux.size();
    }
    public Set<Espece> getEspeces() {
        Set<Espece> res = new HashSet<Espece>();
        Iterator<Animal> it = animaux.iterator();
        Animal a;
        while (it.hasNext()) {
            a = it.next();
            res.add(a.getEspece());
        }
        return res;
    }


    public void afficher() {
    }
}
