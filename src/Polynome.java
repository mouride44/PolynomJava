package Projet;

import java.util.ArrayList;

import java.util.Arrays;

public class Polynome {
	protected ArrayList<Double> coeff =new ArrayList<Double>();
	int degre;
	private int[] vec;
	public Polynome (int taille){

		for(int i=0;i<taille;i++)
			coeff.add(0.0);
	}
	public Polynome (int taille,double [] d){

		for(int i=0;i<taille;i++)
			coeff.add(d[i]);
		this.degre=degre();

	}
	public Polynome (int taille,ArrayList<Double> d){
		for(int i=0;i<taille;i++)
			coeff.add(d.get(i));
		//this.degre=coeff.size();
	}
	
	public int degre(){
		int c=0;
		for(int i=0;i<coeff.size();i++)
			if(coeff.get(i)!=0)
				c=i;
		return c;

	}
	public String toString(){
		if(degre==0) return ""+coeff.get(0);
		if(degre==1) return coeff.get(1)+"x+"+coeff.get(0);
		String s=coeff.get(degre)+"x^"+degre;
		for(int i=degre-1;i>=0;i--){
			if(coeff.get(i)==0 ) continue;
			if(coeff.get(i)>0) s=s+"+"+(coeff.get(i));
			else if(coeff.get(i)<0) s=s+"-"+(-coeff.get(i));
				//if(i== 1) s=s+"x";
			if(i>0) s=s+"x^"+i;
		}
		return s;

	}

	public Polynome addition(String diao){
		Polynome p=new Polynome(diao);
		Polynome p1=new Polynome(p.coeff.size());
		if (p1.coeff.size()<coeff.size()){
			for(int i=0;i<p1.coeff.size();i++)
				p1.coeff.set(i, coeff.get(i)+p.coeff.get(i));
			for(int i=p1.coeff.size();i<coeff.size();i++)
				p1.coeff.add(coeff.get(i));
		}

		else {
			for(int i=0;i<p1.coeff.size();i++)
				p1.coeff.set(i, coeff.get(i)+p.coeff.get(i));
		}
		p1.degre=degre();
		return p1;
	}

	public Polynome soustraction(String diao){
		Polynome p=new Polynome(diao);
		Polynome p1=new Polynome(p.coeff.size());
		if (p1.coeff.size()<coeff.size()){
			for(int i=0;i<p1.coeff.size();i++)
				p1.coeff.set(i, coeff.get(i)-p.coeff.get(i));
			for(int i=p1.coeff.size();i<coeff.size();i++)
				p1.coeff.add(coeff.get(i));
		}

		else {
			for(int i=0;i<p1.coeff.size();i++)
				p1.coeff.set(i, coeff.get(i)-p.coeff.get(i));
		}
		p1.degre=degre();
		return p1;
	}

	public Polynome additionx(String chain){
		Polynome p=new Polynome(chain);
		p=addition(chain);
		return p;

	}
//Constructeur qui genere un polynome si un utilisateur saisi un polynme de la
//forme 2x^2+3
	public Polynome (String diao) {

		String sr="+";
		char x=diao.charAt(1);
		char g=sr.charAt(0);
		String s3=reglestring(diao);
		ArrayList<Double>d=new ArrayList<Double>();
		ArrayList<Double>h=new ArrayList<Double>();
		for(int i=0;i<s3.length();i++){	
			if(s3.charAt(i)==x ){
				d.add( Double.parseDouble(Character.toString(s3.charAt(i+2))));
			}	

		}
		for(int i=0;i<s3.length();i++){	
			if(s3.charAt(i)==g  && s3.charAt(i)!=x){
				h.add( Double.parseDouble(Character.toString(s3.charAt(i+1))));
			}	
			else if(s3.charAt(i)=='-'  && s3.charAt(i)!=x){
				h.add(- Double.parseDouble(Character.toString(s3.charAt(i+1))));
			}
		}
		
		regletab(d,h);
		vec= new int [d.size()];
		for(int i=0;i<d.size();i++){

			double f=d.get(i);
			int v=(int)f;
			setd(i,v);

		}
	
		double[] tab3=  fillNewTab(vec,h);
		System.out.println(Arrays.toString(tab3));
		for(int i=0;i<tab3.length;i++)
			coeff.add(tab3[i]);
		degre=degre();

	}
	private void setd(int a,int b){
		vec[a]=b;
	}
	private int getd(int a){
		int d=vec[a];
		return d;

	}

	public Polynome derive(){

		Polynome der=new Polynome(coeff.size());
		der.degre=degre-1;
		for(int i=0;i<coeff.size()-1;i++){
			der.coeff.set(i, (i+1)*coeff.get(i+1));
		}
		return der;



	}	
	private static int getMaxValue(int[] tab1) {
		int toReturn = 0;
		for (int i = 0; i < tab1.length; i++) {
			if(toReturn < tab1[i]){
				toReturn = tab1[i];
			}
		}
		return toReturn;
	}
	private static double [] fillNewTab(int[] tab1, ArrayList<Double>tab2) {
		int maxValue = getMaxValue(tab1);
		double[] tab3 = new double[maxValue+1];
		System.out.println();
		for (int i = 0; i < tab1.length; i++) {
			tab3[tab1[i]]= tab2.get(i);
		}
		return tab3;
	}
	private void regletab(ArrayList<Double>tab, ArrayList<Double>tabe){
		if(tab.size()<tabe.size())
			tab.add(0.);	

	}
	private String reglestring(String chaine){
		String sr="+1";
		String se="+";
		String s2="+0";
		String s="";
		if(chaine.length()==3){
			s=sr.concat(chaine).concat(s2);		
		}

		else if(chaine.length()==4){
			s=se.concat(chaine).concat(s2);		
		}
		if(chaine.charAt(0)=='-'){
			s=chaine;
			
		}
		else 
			s=se.concat(chaine);
		return s;
	}

	public Polynome multiply (String pol){
		Polynome p=new Polynome(pol);
		Polynome res=new Polynome(coeff.size()+p.coeff.size()-1);
		for(int i=0;i<coeff.size();i++)
			for(int j=0;j<p.coeff.size();j++)
				res.coeff.set(i+j,res.coeff.get(i+j)
						+coeff.get(i)*p.coeff.get(j));
		res.degre=degre+p.degre;

		return res;		

	}
	public Polynome mutiplyX(String pol){
		Polynome p=new Polynome(pol);
		p=multiply(pol);
		return p;
	}
	public Polynome  multiplyfloat(float d){
		Polynome p=new Polynome(coeff.size());
		for(int i=0;i<coeff.size();i++)
			p.coeff.set(i, coeff.get(i)*d);
		p.degre=degre;
		System.out.println(coeff);
		System.out.println(p.degre);
		return p;

	}

	public void multiplieParX(){
		coeff.add(coeff.get(coeff.size()-1));
		for(int i=coeff.size()-1;i>0;i--)
			coeff.set(i,coeff.get(i-1));
		coeff.set(0, 0.);
	}
	public boolean egalite(Polynome p){
		if(degre!=p.degre)
			return false;
		for(int i=0 ;i<coeff.size();i++){
			if(coeff.get(i)!=p.coeff.get(i)){
				return false;
			}
		}
		return true;
	}
	public boolean egalite(String diao){
		Polynome p=new Polynome(diao);
		if(coeff.size()!=p.coeff.size())
			return false;
		
		for(int i=0 ;i<coeff.size();i++)
			if(coeff.get(i)!=p.coeff.get(i))
				return false;
		
	
		return true;
	}
	public Polynome multiply (Polynome p){
		Polynome res=new Polynome(coeff.size()+p.coeff.size()-1);
		for(int i=0;i<coeff.size();i++)
			for(int j=0;j<p.coeff.size();j++)
				res.coeff.set(i+j,res.coeff.get(i+j)
						+coeff.get(i)*p.coeff.get(j));
		res.degre=degre();
		return res;
	}
	public Polynome addition(Polynome p){
		Polynome p1=new Polynome(p.coeff.size());
		if (p1.coeff.size()<coeff.size()){
			for(int i=0;i<p1.coeff.size();i++)
				p1.coeff.set(i, coeff.get(i)+p.coeff.get(i));
			for(int i=p1.coeff.size();i<coeff.size();i++)
				p1.coeff.add(coeff.get(i));
			
		}

		else {
			for(int i=0;i<p1.coeff.size();i++)
				p1.coeff.set(i, coeff.get(i)+p.coeff.get(i));
		}
		p1.degre=degre();
		return p1;
	}
	public Polynome soustraction(Polynome p){
		Polynome p1=new Polynome(p.coeff.size());
		if (p1.coeff.size()<coeff.size()){
			for(int i=0;i<p1.coeff.size();i++)
				p1.coeff.set(i, coeff.get(i)-p.coeff.get(i));
			for(int i=p1.coeff.size();i<coeff.size();i++)
				p1.coeff.add(coeff.get(i));
		}

		else {
			for(int i=0;i<p1.coeff.size();i++)
				p1.coeff.set(i, coeff.get(i)-p.coeff.get(i));
		}
		p1.degre=degre();
		return p1;
	}
	
	public Polynome(Polynome p) {
		super();
		degre = p.degre;
			coeff=p.coeff;
	}

	
	
	public Polynome resteDivisionEuclidienne(Polynome b) {
		Polynome q = new Polynome(coeff.size());
		Polynome r=new Polynome(this);
		Polynome m;
	while(r.degre>=b.degre){
	m=new Polynome(r.coeff.size()-b.coeff.size());
	m.coeff.add(r.degre-b.degre, r.coeff.get(r.degre)/b.coeff.get(b.degre));
		q = q.addition(m);
		r = r.soustraction(b.multiply(m));
		
	}
	r.degre=degre();
			return r; 
		
		}
	public Polynome DivisionEuclidienne(Polynome b) {
		Polynome q = new Polynome(coeff.size());
		Polynome r=new Polynome(this);
		Polynome m;
	while(r.degre>=b.degre){
	m=new Polynome(r.coeff.size()-b.coeff.size());
	m.coeff.add(r.degre-b.degre, r.coeff.get(r.degre)/b.coeff.get(b.degre));
		q = q.addition(m);
		r = r.soustraction(b.multiply(m));
		
	}
	q.degre=degre();
			return q; 
		
		}
		
	public Polynome pgcdEuclide(Polynome p) {
		Polynome r1 = new Polynome(this);
		Polynome r2 = new Polynome(p);
		Polynome aux;
		while (r2.degre > 0) {
			aux = r2;
			r2 = r1.resteDivisionEuclidienne(r2);
			r1 = aux;
		}
		r1.degre=degre();
		return r1;
	}

		
	
	

	public static void  main(String[] args){



		double a[]={12,7,2,5,5};
		double b[]={-12,4,2};
		Polynome p=new Polynome("2x^3+3x^2+5");
		Polynome p1=new Polynome(3,b);
	



		System.out.println(p);;
	}
}


