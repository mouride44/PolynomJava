package Projet;

public class AnneauEucliPol extends Ring<Polynome> {

	
	public boolean commutative(Polynome a, Polynome b) {
		if(a.degre!=b.degre)
			Singleton.getInstance().ajouterMessage("les deux polynomes sont de degrés differents ");
		else
			Singleton.getInstance().ajouterMessage("les deux polynomes sont de méme degrés");
		return (a.multiply(b)==b.multiply(a));
	}

	
	public boolean associative(Polynome a, Polynome b, Polynome c) {
		if(a.degre!=b.degre && b.degre!=c.degre)
			Singleton.getInstance().ajouterMessage("les trois polynomes ne sont pas de méme degres ");
		else if(a.degre==b.degre && b.degre==c.degre)
			Singleton.getInstance().ajouterMessage("les polynome sont de méme degrés ");
		return (a.multiply(b.multiply(c))==c.multiply(a.multiply(b)));
	}

	
	public boolean distributive(Polynome a, Polynome b, Polynome c) {
		if(a.degre!=b.degre && b.degre!=c.degre)
			Singleton.getInstance().ajouterMessage("les  polynomes ne sont tous pas de méme degres ");
		else if(a.degre==b.degre && b.degre==c.degre)
			Singleton.getInstance().ajouterMessage("les polynome sont de méme degrés ");
	
		return (a.multiply(b.addition(c))==a.multiply(b).addition(a.multiply(c)));
	}

	@Override
	public boolean elementneautreadd(Polynome a, Polynome e) {
		if(e!=null)
			Singleton.getInstance().ajouterMessage(""+e+" n'est pas l'element neutre ");
		return ((a.addition(e)==e.addition(a) && e.addition(a)==a));
	}

	@Override
	public boolean unitaire(Polynome a, Polynome e) {
		if(e.coeff.size()!=1 && e.coeff.get(e.coeff.size()-1)==0)
				Singleton.getInstance().ajouterMessage(""+e+" n'est pas l'element neutre ");
		
		return (a.multiply(e)==e.multiply(a) && e.multiply(a)==a);
	}

	@Override
	public void integre(Polynome a, Polynome b) {
		if(a.multiply(b)==null)
			Singleton.getInstance().ajouterMessage(""+a+", "+b+" l'un polynome vaut zero ");
		else 
			Singleton.getInstance().ajouterMessage("la mutiplication des deux polynome ne vaut pas 0 ");
		
	}
	
	public boolean muniDivEuc(Polynome a, Polynome b) {
	
		if(a.degre!=b.degre)
			Singleton.getInstance().ajouterMessage("les deux polynomes sont de degrés differents ");
		else
			Singleton.getInstance().ajouterMessage("les deux polynomes sont de méme degrés");
		return (a==b.multiply(a.DivisionEuclidienne(b).addition(a.resteDivisionEuclidienne(b))));
	}

}
