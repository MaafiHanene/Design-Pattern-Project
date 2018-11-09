package src_Problem01;
import java.io.Serializable;
import java.util.*;

import Enum.TypeAnimal;
import Enum.TypeEnclos;
import Exceptions.NonCompatible;

public class Zoo_ implements Serializable {

    private String nom;
    private String dateOuverture;
    private String ville;
  
    private static double surface = 5000;
    private static double sur;


    public Zoo_(String nom, String date, double surface, String ville) {
        this.nom = nom;
        this.dateOuverture = date;
        this.surface = surface;
        this.ville = ville;
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

 

    public static double getSuperficie() {
        return surface;
    }

    /*public static double getWinLa79a() {
        return sur;
    }

    public static void setWinLa79a(double v) {
        sur = v;
    }*/

   
   
   

   
   

    

   

    

   
}

