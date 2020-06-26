import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CapitalesGame3 {

	static int t = 0, nb_tours, points = 0, test = 0;
	static int high, mid;
	
	static ArrayList<Integer> stock = new ArrayList<Integer>() ;
	
	static String[] pays = {"Allemagne", "Autriche", "Belgique", "Bulgarie", "Chypre", "Croatie", "Danemark", "Espagne", "Estonie", "Finlande",
			"France", "Gr�ce", "Hongrie", "Irlande", "Italie", "Letonnie", "Lituanie", "Luxembourg", "Malte", "Royaume-Uni", "Slovaquie",
			"Slov�nie", "Su�de"};
	static String[] capitale = {"Berlin", "Vienne", "Bruxelles", "Sofia", "Nicosie", "Zagreb", "Copenhague", "Madrid", "Tallinn", "Helsinki",
			"Paris", "Ath�nes", "Budapest", "Dublin", "Rome", "Riga", "Vilnius", "Luxembourg", "La Valette", "Londres", "Bratislava",
			"Ljubljana", "Stockholm"};
	
	static final int NB_PAYS = pays.length;
	static Random random = new Random();
	static Scanner clavier = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		difficult�();
		run();
		texte();
		clavier.close();
		
	}
	
	public static void difficult�() {
			
			System.out.println("Choisissez votre niveau de difficult� :\n1 : Facile | 2 : Moyen | 3 : Difficile | 4 : Expert");
			int choix = clavier.nextInt();
			clavier.nextLine();							//ligne empechant un bug li� � nextLine
			if( choix == 1) {
				nb_tours = 5;
				high = 3;								//high = pallier � partir duquel le joueur re�oit le texte "Bon Score!"
				mid = 3;								//mid = pallier en dessous duquel le joueur re�oit le texte "Il va falloir r�viser!"
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
			int nb = random.nextInt(NB_PAYS);			//g�n�ration d'un nb al�atoire entre 0 et 22 compris
			
			while(stock.contains(nb)) {				//on v�rifie que pour tous les �l�ments de stock, le pays[nb] n'en fasse pas partie
//				test++;
//				System.out.println("La boucle while vient d'�tre lanc�e : "+ test +" fois");
				if(t < nb_tours) {
					nb = random.nextInt(NB_PAYS);			//g�n�ration d'un nb al�atoire entre 0 et 22 compris
				}
			}
				stock.add(nb);			//on stocke le pays dans la derni�re case de stock
			
			
				
			System.out.printf("Quelle est la capitale de ce pays : %s ?", pays[nb]);
			
			String answer = clavier.nextLine();
			
			if(answer.equalsIgnoreCase(capitale[nb])) {
				System.out.println("Bravo");
				points++;
			}else {
				System.out.println("Faux!\nLa capitale de ce pays �tait : " + capitale[nb] + ".");
			}
			t++;
		}	
	}
	public static void texte() {
		
		if(points == t) {
			System.out.println(t+"\nTotal de " + points + " points ! Score parfait, f�licitations !");
		}else if (points >= high && points < t) {
			System.out.println(t+"\nTotal de " + points + " points. Bon score !");
		}else if (points >= mid && points < high) {
			System.out.println(t+"\nTotal de " + points + " points. Score correct.");
		}else if (points > 0 && points < mid) {
			System.out.println(t+"\nTotal de " + points + " points. Il va falloir r�viser...");
		}else {
			System.out.println(t+"\nTotal de " + points + " points. Aucune bonne r�ponse...");
		}
	}
}
