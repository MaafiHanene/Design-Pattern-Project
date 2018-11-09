package src_Solution.espece;

import Enum.*;
import src_Solution.Photo_;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Reptile_ extends Vertebre_ {

    public Reptile_(String nom, String continents, int dureeVie,
                   RegimeAlimentaire regime, Habitat habitat, Photo_ photo) {
        super(nom, continents, dureeVie, regime, habitat, photo);
        // TODO Auto-generated constructor stub
    }

    public Reptile_(String nomfich) {
        super(nomfich);

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
                        if (cpt == 10) {
                            this.dangereux = (Integer.parseInt(champ) == 1);
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

    private boolean dangereux;

    public boolean getDangereux() {
        return this.dangereux;
    }

}
