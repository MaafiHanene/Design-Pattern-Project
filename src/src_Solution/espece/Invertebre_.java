package src_Solution.espece;

import Enum.*;
import src_Solution.Photo_;

public abstract class Invertebre_ extends Espece_{

    public Invertebre_(String nom, String continents, int dureeVie,
                      RegimeAlimentaire regime, Habitat habitat, Photo_ photo) {
        super(nom, continents, dureeVie, regime, habitat, photo);
        // TODO Auto-generated constructor stub
    }

    public Invertebre_(String nomfich) {
        super(nomfich);
    }
}
