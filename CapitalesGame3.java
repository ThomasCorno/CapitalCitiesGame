import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CapitalesGame3 {

	static int t = 0, nb_tours, points = 0, test = 0;
	static int high, mid;
	
	static ArrayList<Integer> stock = new ArrayList<Integer>() ;
	
	static String[] pays = {"Allemagne", "Autriche", "Belgique", "Bulgarie", "Chypre", "Croatie", "Danemark", "Espagne", "Estonie", "Finlande",
			"France", "Grèce", "Hongrie", "Irlande", "Italie", "Letonnie", "Lituanie", "Luxembourg", "Malte", "Royaume-Uni", "Slovaquie",
			"Slovénie", "Suède"};
	static String[] capitale = {"Berlin", "Vienne", "Bruxelles", "Sofia", "Nicosie", "Zagreb", "Copenhague", "Madrid", "Tallinn", "Helsinki",
			"Paris", "Athènes", "Budapest", "Dublin", "Rome", "Riga", "Vilnius", "Luxembourg", "La Valette", "Londres", "Bratislava",
			"Ljubljana", "Stockholm"};
	
	static final int NB_PAYS = pays.length;
	static Random random = new Random();
	static Scanner clavier = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		difficulté();
		run();
		texte();
		clavier.close();
		
	}
	
	public static void difficulté() {
			
			System.out.println("Choisissez votre niveau de difficulté :\n1 : Facile | 2 : Moyen | 3 : Difficile | 4 : Expert");
			int choix = clavier.nextInt();
			clavier.nextLine();							//ligne empechant un bug lié à nextLine
			if( choix == 1) {
				nb_tours = 5;
				high = 3;								//high = pallier à partir duquel le joueur reçoit le texte "Bon Score!"
				mid = 3;								//mid = pallier en dessous duquel le joueur reçoit le texte "Il va falloir réviser!"
			}
			else if( choix == 2) {
				nb_tours = 10;
				high = 7;
				mid = 4;
			}
			else if( choix == 3) {
				nb_tours = 15;
				high = 11;
				mid = 6;
			}
			else if(choix == 4) {
				nb_tours = 20;
				high = 14;
				mid = 8;
			}
		}

	public static void run() {
		
		while(t < nb_tours) {
			System.out.println(t+"/"+nb_tours);
//			System.out.println(stock);
			int nb = random.nextInt(NB_PAYS);			//génération d'un nb aléatoire entre 0 et 22 compris
			
			while(stock.contains(nb)) {				//on vérifie que pour tous les éléments de stock, le pays[nb] n'en fasse pas partie
//				test++;
//				System.out.println("La boucle while vient d'être lancée : "+ test +" fois");
				if(t < nb_tours) {
					nb = random.nextInt(NB_PAYS);			//génération d'un nb aléatoire entre 0 et 22 compris
				}
			}
				stock.add(nb);			//on stocke le pays dans la dernière case de stock
			
			
				
			System.out.printf("Quelle est la capitale de ce pays : %s ?", pays[nb]);
			
			String answer = clavier.nextLine();
			
			if(answer.equalsIgnoreCase(capitale[nb])) {
				System.out.println("Bravo");
				points++;
			}else {
				System.out.println("Faux!\nLa capitale de ce pays était : " + capitale[nb] + ".");
			}
			t++;
		}	
	}
	public static void texte() {
		
		if(points == t) {
			System.out.println(t+"\nTotal de " + points + " points ! Score parfait, félicitations !");
		}else if (points >= high && points < t) {
			System.out.println(t+"\nTotal de " + points + " points. Bon score !");
		}else if (points >= mid && points < high) {
			System.out.println(t+"\nTotal de " + points + " points. Score correct.");
		}else if (points > 0 && points < mid) {
			System.out.println(t+"\nTotal de " + points + " points. Il va falloir réviser...");
		}else {
			System.out.println(t+"\nTotal de " + points + " points. Aucune bonne réponse...");
		}
	}
}
