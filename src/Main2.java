package Projet;

public class Main2 { 
	public static void main(String[] args) {
		AnneauEucliPol n=new AnneauEucliPol();
		double a[]={12,7,2,5,5};
		double b[]={-12,4,2};
		double c[]={5,6,7,1};
		double d[]={0};
		double e[]={1};
		
		Polynome p=new Polynome(5,a);
		Polynome p1=new Polynome(3,b);
		System.out.println(n.commutative(p1, p));
		 String s = Singleton.getInstance().afficherMessage();
		 System.out.println(s);
	
		
	}

}
