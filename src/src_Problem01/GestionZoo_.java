package src_Problem01;

import java.util.ArrayList;
import java.util.Iterator;

import Enum.TypeAnimal;
import Enum.TypeEnclos;
import Exceptions.NonCompatible;

public class GestionZoo_ {
	
	private Zoo_ zoo;
	 static GestionEnclos_ gestionEnclos = new GestionEnclos_();
	 static GestionAnimaux_ gestionAnimaux  = new GestionAnimaux_();
	 static GestionRestaurants_ gestionRestaurant_ = new GestionRestaurants_();;
	 static GestionPortes_ gestionPortes = new GestionPortes_();;
	public GestionEnclos_ getGestionEnclos() {
		return gestionEnclos;
	}
	public void setGestionEnclos(GestionEnclos_ gestionEnclos) {
		this.gestionEnclos = gestionEnclos;
	}
	public GestionAnimaux_ getGestionAnimaux() {
		return gestionAnimaux;
	}
	public void setGestionAnimaux(GestionAnimaux_ gestionAnimaux) {
		this.gestionAnimaux = gestionAnimaux;
	}
	public GestionRestaurants_ getGestionRestaurant_() {
		return gestionRestaurant_;
	}
	public void setGestionRestaurant_(GestionRestaurants_ gestionRestaurant_) {
		this.gestionRestaurant_ = gestionRestaurant_;
	}
	public GestionPortes_ getGestionPortes() {
		return gestionPortes;
	}
	public void setGestionPortes(GestionPortes_ gestionPortes) {
		this.gestionPortes = gestionPortes;
	}
	public Zoo_ getZoo() {
		return zoo;
	}
	public void setZoo(Zoo_ zoo) {
		this.zoo = zoo;
	}
	 public String getNom() {
	        return this.zoo.getNom();
	    }

	    public String getVille() {
	        return this.zoo.getVille();
	    }

	    public String getDate() {
	        return this.zoo.getDate();
	    }
	    
	    public  double getSuperficie() {
	        return this.zoo.getSuperficie();
	    }
	    
		 public void ajouterEnclos(Enclos_ e) {
		       this.gestionEnclos.ajouterEnclos(e);
		    }
		 
		 public boolean affectAnimal(Animal_ a, Enclos_ e) throws NonCompatible {
		      
		        return this.gestionEnclos.affectAnimal(a, e);
		    }

		    public boolean deplAnimal(Animal_ a, Enclos_ e1, Enclos_ e2) throws NonCompatible {
		        
		        return this.gestionEnclos.deplAnimal(a, e1, e2);
		    }
		    public void supprimerEnclos(Enclos_ e) {
		        this.gestionEnclos.supprimerEnclos(e);
		    }
		    public int nbAnimaux(TypeEnclos t) {
		       return this.gestionEnclos.nbAnimaux(t);
		    }
		    Iterator<Enclos_> getEnclosIterator()
		    {
		    	return this.gestionEnclos.getEnclosIterator();
		    }

		    public ArrayList<Enclos_> getEnclos() {
		        return this.gestionEnclos.getEnclos();
		    }
		    
		    
		    public void ajouterResto(Restaurant_ r) {
		    	this.gestionRestaurant_.ajouterResto(r);
		    }
		  
		  public void supprimerResto(Restaurant_ r) {
			  this.gestionRestaurant_.supprimerResto(r);
		    }
		  
		 

		    public ArrayList<Restaurant_> getRestos() {
		        return this.gestionRestaurant_.getRestos();
		    }
		    
		    public void ajouterPorte()
			 {
				 this.gestionPortes.ajouterPorte();
			 }
			 
			 public void supprimerPorte(Porte_ porte)
			 {
				 this.gestionPortes.supprimerPorte(porte);
			 }
			 
			 public ArrayList<Porte_> getPortes() {
			        return this.gestionPortes.getPortes();
			    }
			 
			 public int nbAnimaux(TypeAnimal t) {
			        
			        return this.gestionAnimaux.nbAnimaux(t);
			    }
			 public void ajouterAnimal()
			 {
				 this.gestionAnimaux.ajouterAnimal();
			 }
			 public void supprimerAnimal(Animal_ a)
			 {
				 this.gestionAnimaux.supprimerAnimal(a);
			 }
			 
			  
			    public ArrayList<Animal_> getAnimaux() {
			        return this.gestionAnimaux.getAnimaux();
			    }


}
