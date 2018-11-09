import java.io.IOException;

import Enum.Habitat;
import Enum.RegimeAlimentaire;


public abstract class Vertebre extends Espece {

    public Vertebre(String nom, String continents, int dureeVie,
                    RegimeAlimentaire regime, Habitat habitat, Photo photo) {
        super(nom, continents, dureeVie, regime, habitat, photo);
        // TODO Auto-generated constructor stub
    }

    public Vertebre(String nomfich) {
        super(nomfich);
    }


}
