package Projet;

public abstract class Ring <T>{
	
	abstract public boolean commutative(T a,T b);
	abstract public boolean associative(T a ,T b,T c);
	abstract public boolean distributive(T a,T b,T c);
	abstract public boolean elementneautreadd(T a,T e);
	abstract public boolean unitaire(T a,T e);
	abstract public void integre(T a,T e);
	abstract public boolean muniDivEuc(T a,T e);
	

	
	public int gcd(int a, int b){
		int tmp=0;
		
		if(b>a){	
		}
		else {
			tmp=a;
			a=b;
			b=tmp;
		}
		while (b%a!=0){
			tmp=b;
			b=a%b;
			a=tmp;
		}
		return Math.abs(a);
	

}
}