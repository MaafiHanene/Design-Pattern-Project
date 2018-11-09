package src_Solution.espece;

import Enum.*;
import src_Solution.Photo_;

public class Mollusque_ extends Invertebre_ {

    public Mollusque_(String nom, String continents, int dureeVie,
                     RegimeAlimentaire regime, Habitat habitat, Photo_ photo) {
        super(nom, continents, dureeVie, regime, habitat, photo);
        // TODO Auto-generated constructor stub
    }

    public Mollusque_(String nomfich) {
        super(nomfich);
    }
}
