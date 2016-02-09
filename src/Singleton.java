package Projet;
import java.util.Date;
//import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Singleton {
	private static Singleton uniqueinstance;// stockage de l'unique instance
	private String message; // chaine de caractere representant les message d'erruer
	private Singleton(){
		message=new String();
	}
	public static synchronized Singleton getInstance(){
		if(uniqueinstance==null){
			uniqueinstance=new Singleton();
		}
		
			return uniqueinstance;
	}
	
	public void ajouterMessage(String message){
	//	// On ajoute également la date du message.
      Date d = new Date();
		
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH'h'mm");
        this.message+="["+dateFormat.format(d)+"] "+message+"\n";
	}
	public String afficherMessage(){
		return message;
	}
	public static void main(String[] args) {
		Singleton h=new Singleton();
		h.ajouterMessage("diao");
		System.out.println(h.afficherMessage());
	}


}
