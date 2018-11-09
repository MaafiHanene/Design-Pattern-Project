import java.io.Serializable;
import java.util.*;

import Enum.TypeAnimal;
import Enum.TypeEnclos;
import Exceptions.NonCompatible;

public class Zoo implements Serializable {

    private String nom;
    private String dateOuverture;
    private String ville;
    private ArrayList<Porte> portes;
    private ArrayList<Enclos> enclos = new ArrayList<Enclos>();
    private ArrayList<Restaurant> restos = new ArrayList<Restaurant>();
    private ArrayList<Animal> animaux = new ArrayList<Animal>();
    private static double surface = 5000;
    private static double sur;


    public Zoo(String nom, String date, double surface, String ville, ArrayList<Porte> portes) {
        this.nom = nom;
        this.dateOuverture = date;
        this.surface = surface;
        this.ville = ville;
        this.portes = portes;
    }

    public String getNom() {
        return this.nom;
    }

    public String getVille() {
        return this.ville;
    }

    public String getDate() {
        return this.dateOuverture;
    }

    public ArrayList<Enclos> getEnclos() {
        return this.enclos;
    }

    public ArrayList<Restaurant> getRestos() {
        return this.restos;
    }

    public ArrayList<Animal> getAnimaux() {
        return this.animaux;
    }

    public static double getSuperficie() {
        return surface;
    }

    public static double getWinLa79a() {
        return sur;
    }

    public static void setWinLa79a(double v) {
        sur = v;
    }

    public void ajouterEnclos(Enclos e) {
        if (!enclos.contains(e)) {
            enclos.add(e);
        }
    }

    public void ajouterResto(Restaurant r) {
        if (!restos.contains(r)) restos.add(r);
    }

    public void supprimerEnclos(Enclos e) {
        if (enclos.contains(e)) enclos.remove(e);
    }

    public void supprimerResto(Restaurant r) {
        if (restos.contains(r)) restos.remove(r);
    }

    public Enclos MeilleurEnclos(Animal a) {
        return null;
    }

    public boolean affectAnimal(Animal a, Enclos e) throws NonCompatible {
        boolean resultat = e.marche(a);
        if (resultat) e.ajouterAnimal(a);
        return resultat;
    }

    public boolean deplAnimal(Animal a, Enclos e1, Enclos e2) throws NonCompatible {
        boolean resultat = e2.marche(a);
        if (resultat) {
            e1.supAnimal(a);
            e2.ajouterAnimal(a);
        }
        return resultat;
    }

    public void sauvegarder() {
    }

    public void charger(String nomfich) {
    }

    public int nbAnimaux(TypeEnclos t) {
        int cpt = 0;
        Enclos e;
        Iterator<Enclos> it = enclos.iterator();
        while (it.hasNext()) {
            e = it.next();
//			if (){
            cpt++;
            //}
        }
        return cpt;
    }

    public int nbAnimaux(TypeAnimal t) {
        int cpt = 0;
        Animal a;
        Iterator<Animal> it = animaux.iterator();
        while (it.hasNext()) {
            a = it.next();
//			if(){
            cpt++;
            //}
        }
        return cpt;
    }
}
