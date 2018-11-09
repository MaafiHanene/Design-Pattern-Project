package src_Problem01;

import java.util.ArrayList;
import java.util.Iterator;

import Enum.TypeEnclos;
import Exceptions.NonCompatible;

public class GestionEnclos_ {
	 private ArrayList<Enclos_> enclos = new ArrayList<Enclos_>();
	
	 
	 
	 public void ajouterEnclos(Enclos_ e) {
	        if (!enclos.contains(e)) {
	            enclos.add(e);
	        }
	    }
	 
	 public boolean affectAnimal(Animal_ a, Enclos_ e) throws NonCompatible {
	        boolean resultat = e.marche(a);
	        if (resultat) e.ajouterAnimal(a);
	        return resultat;
	    }

	    public boolean deplAnimal(Animal_ a, Enclos_ e1, Enclos_ e2) throws NonCompatible {
	        boolean resultat = e2.marche(a);
	        if (resultat) {
	            e1.supAnimal(a);
	            e2.ajouterAnimal(a);
	        }
	        return resultat;
	    }
	    public void supprimerEnclos(Enclos_ e) {
	        if (enclos.contains(e)) enclos.remove(e);
	    }
	    public int nbAnimaux(TypeEnclos t) {
	        int cpt = 0;
	        Enclos_ e;
	        Iterator<Enclos_> it = enclos.iterator();
	        while (it.hasNext()) {
	            e = it.next();
//				if (){
	            cpt++;
	            //}
	        }
	        return cpt;
	    }
	    Iterator<Enclos_> getEnclosIterator()
	    {
	    	return this.enclos.iterator();
	    }

	    public ArrayList<Enclos_> getEnclos() {
	        return this.enclos;
	    }

}
