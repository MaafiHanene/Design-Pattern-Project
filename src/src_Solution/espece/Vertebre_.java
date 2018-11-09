package src_Solution.espece;

import Enum.*;
import src_Solution.Photo_;

public abstract class Vertebre_ extends Espece_{

    public Vertebre_(String nom, String continents, int dureeVie,
                    RegimeAlimentaire regime, Habitat habitat, Photo_ photo) {
        super(nom, continents, dureeVie, regime, habitat, photo);
        // TODO Auto-generated constructor stub
    }

    public Vertebre_(String nomfich) {
        super(nomfich);
    }
}
