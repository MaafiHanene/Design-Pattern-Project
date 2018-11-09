import java.io.IOException;

import Enum.Habitat;
import Enum.RegimeAlimentaire;


public class Mollusque extends Invertebre {

    public Mollusque(String nom, String continents, int dureeVie,
                     RegimeAlimentaire regime, Habitat habitat, Photo photo) {
        super(nom, continents, dureeVie, regime, habitat, photo);
        // TODO Auto-generated constructor stub
    }

    public Mollusque(String nomfich) {
        super(nomfich);
    }

}
