package Projet;

public class Main {
	public static void main(String[] args) {
		AnneauEucli e=new AnneauEucli();
	e.unitaire(4, 2);
		e.integre(1, 0);
		e.elementneautreadd(1,4);
		e.muniDivEuc(4,2);
		System.out.println(e.gcd(4,2));
		 String s = Singleton.getInstance().afficherMessage();
		 System.out.println(s);
	}
}
