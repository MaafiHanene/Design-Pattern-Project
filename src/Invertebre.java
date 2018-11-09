import java.io.IOException;

import Enum.Habitat;
import Enum.RegimeAlimentaire;


public abstract class Invertebre extends Espece {

    public Invertebre(String nom, String continents, int dureeVie,
                      RegimeAlimentaire regime, Habitat habitat, Photo photo) {
        super(nom, continents, dureeVie, regime, habitat, photo);
        // TODO Auto-generated constructor stub
    }

    public Invertebre(String nomfich) {
        super(nomfich);
    }

}
