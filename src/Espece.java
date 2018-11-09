import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import Enum.Habitat;
import Enum.RegimeAlimentaire;

public class Espece {
    private String nom;
    private String continents;
    private int dureeVie;
    private RegimeAlimentaire regime;
    private Habitat habitat;
    private Photo photo;
    private static int nbIndividus;

    public static void main(String[] args) {
        Espece a = new Espece("lion.esp");
    }

    public Espece(String nomfich) {
        BufferedReader in = null;
        String ligne;
        int cpt = 0;
        try {
            in = new BufferedReader(new FileReader(nomfich));
            while ((ligne = in.readLine()) != null) {
                cpt++;
                StringTokenizer tok = new StringTokenizer(ligne, ":");
                int nb = tok.countTokens();
                for (int i = 0; i < nb; i++) {
                    String champ = tok.nextToken();
                    if (i == 1) {
                        switch (cpt) {
                            case 1:
                                this.nom = champ;
                                break;
                            case 4:
                                this.continents = Continents(champ);
                                break;
                            case 5:
                                this.habitat = Habitat(champ);
                                break;
                            case 6:
                                this.dureeVie = Integer.parseInt(champ);
                                break;
                            case 7:
                                this.regime = MakeRegime(champ);
                                break;


                        }

                    }


                }
            }
        } catch (FileNotFoundException e) {

            System.out.println("fichier non existant");
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (in != null)
                try {
                    in.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

        }

    }


    public Espece(String nom, String continents, int dureeVie, RegimeAlimentaire regime, Habitat habitat, Photo photo) {
        this.nbIndividus++;
        this.nom = nom;
        this.continents = continents;
        this.dureeVie = dureeVie;
        this.regime = regime;
        this.habitat = habitat;
        this.photo = photo;
    }

    public String getNom() {
        return this.nom;
    }

    public String getContinents() {
        return this.continents;
    }

    public int getDuree() {
        return this.dureeVie;
    }

    public RegimeAlimentaire getRegime() {
        return this.regime;
    }

    public Habitat getHabitat() {
        return this.habitat;
    }

    public int nbIndividus() {
        return this.nbIndividus();
    }

    public Set<Enclos> enclosResidants() {
        return null;
    }

    public String toString() {
        return this.nom;
    }

    public int comparer(Espece other) {

        return (this.nom).compareTo(other.getNom());
    }

    public boolean eg(Object ob) {
        return this.hashCode() == ob.hashCode();
    }

    public int hashCode() {
        return this.nom.hashCode();
    }

    public String Continents(String s) {
        StringTokenizer tok = new StringTokenizer(s, ",");
        String resultat = "";
        int nb = tok.countTokens();
        for (int i = 0; i < nb; i++) {
            String cont = tok.nextToken();
            switch (cont) {
                case "0":
                    resultat = resultat + "Afrique ";
                    break;
                case "1":
                    resultat = resultat + "Europe ";
                    break;
                case "2":
                    resultat = resultat + "Antartique ";
                    break;
                case "3":
                    resultat = resultat + "Asie ";
                    break;
                case "4":
                    resultat = resultat + "Amerique ";
                    break;
                case "5":
                    resultat = resultat + "Oceanie ";
                    break;

            }
        }
        return resultat;
    }

    public Habitat Habitat(String s) {
        Habitat resultat = null;
        switch (s) {
            case "0":
                resultat = Habitat.eau;
                break;
            case "1":
                resultat = Habitat.terre;
                break;
            case "2":
                resultat = Habitat.air;
                break;
            case "1,0":
                resultat = Habitat.terre_eau;
                break;
            case "0,1":
                resultat = Habitat.terre_eau;
                break;
        }
        return resultat;
    }

    private RegimeAlimentaire MakeRegime(String s) {
        RegimeAlimentaire resultat = null;
        switch (s) {
            case "0":
                resultat = RegimeAlimentaire.Carnivore;
                break;
            case "1":
                resultat = RegimeAlimentaire.Herbivore;
                break;
            case "2":
                resultat = RegimeAlimentaire.Omnivore;
                break;
        }
        return resultat;
    }

}


