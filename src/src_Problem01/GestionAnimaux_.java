package src_Problem01;

import java.util.ArrayList;
import java.util.Iterator;

import Enum.TypeAnimal;

public class GestionAnimaux_ {
	private ArrayList<Animal_> animaux = new ArrayList<Animal_>();
	
	 public int nbAnimaux(TypeAnimal t) {
	        int cpt = 0;
	        Animal_ a;
	        Iterator<Animal_> it = animaux.iterator();
	        while (it.hasNext()) {
	            a = it.next();
//				if(){
	            cpt++;
	            //}
	        }
	        return cpt;
	    }
	 public void ajouterAnimal()
	 {
		 
	 }
	 public void supprimerAnimal(Animal_ a)
	 {
		 
	 }
	 
	  
	    public ArrayList<Animal_> getAnimaux() {
	        return this.animaux;
	    }

}
