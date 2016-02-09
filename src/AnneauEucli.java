package Projet;

import java.util.Random;

public class AnneauEucli extends Ring<Integer> {
	

	public boolean commutative(Integer a, Integer b) {
		
		if(a==0 && b!=0){
			Singleton.getInstance().ajouterMessage("On mutiplie par Zero");
		}
		else if(b==0 && a!=0){
			Singleton.getInstance().ajouterMessage("On mutiplie par Zero");
		}
		else if(a==0 && b==0){
			Singleton.getInstance().ajouterMessage("les deux entiers sont des zeros");
		}
		else if(a!=0 && b!=0){
			Singleton.getInstance().ajouterMessage("On a deux entiers non nuls");
		}
     	return (a*b==b*a); 
	}


	public boolean associative(Integer a, Integer b, Integer c) {
		if(a==0 || b==0 || c==0){
			Singleton.getInstance().ajouterMessage("l'un des entiers est nul");
		}
		else
			Singleton.getInstance().ajouterMessage("les entiers sont non nuls");
		
		return (a*(b*c)==(a*b)*c);
	}


	public boolean distributive(Integer a, Integer b, Integer c) {
		if(a==0 && b!=0 && c!=0)
			Singleton.getInstance().ajouterMessage("l'entier qu'on mutilpie avec la somme des deux autre entier vaut zero");
		else if(a!=0 && b==0 || c==0)
			Singleton.getInstance().ajouterMessage("l'un des entiers dans la somme vaut zero");
		return (a*(b+c)==a*b+a*c);
	}

	
	public boolean elementneautreadd(Integer a, Integer e) {
		if(e!=0)
			Singleton.getInstance().ajouterMessage(""+e+" n'est pas l'element neutre ");
		else if(a==0 && e==0)
			Singleton.getInstance().ajouterMessage("on a une somme deux zeros");
		return (a+e==e+a && e+a==a);
	}

	@Override
	public boolean unitaire(Integer a, Integer e) {
		if(e!=1 && a!=0)
			Singleton.getInstance().ajouterMessage(""+e+" n'est pas l'element neutre ");
		else if(a==0 && e!=1)
				Singleton.getInstance().ajouterMessage("on mutiliplie par zero");
		else if(a==0 && e==0)
				Singleton.getInstance().ajouterMessage( "Les deux entiers sont des zeros");
		return (a*e==e*a && e*a==a);
	}

	@Override
	public void integre(Integer a, Integer b) {
		if (a*b==0){
			Singleton.getInstance().ajouterMessage(""+a+", "+b+" l'un des entiers vaut zero ");
		}

		else {
			Singleton.getInstance().ajouterMessage("la mutiplication des deux entiers ne vaut pas 0 ");
		}
	}


	public boolean muniDivEuc(Integer a, Integer b) {
		if(b==0 ){
			Singleton.getInstance().ajouterMessage("On divise par 0 ");		
		}
		else if(a==0)
			Singleton.getInstance().ajouterMessage("la dividende vaut 0");	
		else
			Singleton.getInstance().ajouterMessage("les entiers sont non nuls");	
			return(a==b*(a/b)+(a%b));
		
		
		
		
	}
	
	

}
