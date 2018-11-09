package src_Problem01;

import java.util.ArrayList;

public class GestionRestaurants_ {
	 
	 
	  private ArrayList<Restaurant_> restos = new ArrayList<Restaurant_>();
	  
	  public void ajouterResto(Restaurant_ r) {
	        if (!restos.contains(r)) restos.add(r);
	    }
	  
	  public void supprimerResto(Restaurant_ r) {
	        if (restos.contains(r)) restos.remove(r);
	    }
	  
	 

	    public ArrayList<Restaurant_> getRestos() {
	        return this.restos;
	    }



	 
}
