package tda;

import java.util.Random;

public class ProgrammeExemple {

	public static Random rand = new Random();
	
	public static void main(String[] args) {

		//exPile();
		//exFile();
		exListe();
		
	}

	
	public static void exPile() {
		
		Pile pile = new Pile<Integer>(100);
		
		for(int i=0;i<5;i++) {
			int valeur = rand.nextInt(100);
			pile.empiler(valeur);
			System.out.println(valeur);
		}
		
		System.out.println();
		
		while(!pile.estVide()) {
			System.out.println(pile.depiler());
		}
		
	}
	
	

	public static void exFile() {

		File file = new File<Integer>(100);

		for(int i=0;i<5;i++) {
			int valeur = rand.nextInt(100);
			file.enfiler(valeur);
			System.out.println(valeur);
		}
		
		System.out.println();
		
		while(!file.estVide()) {
			System.out.println(file.defiler());
		}
		
	}
	
	

	@SuppressWarnings("unchecked")
	public static void exListe() {

		Liste liste = new Liste<Integer>(100);

		liste.ajouter(3, 0);
		liste.ajouter(4, 1);
		liste.ajouter(5, 2);
		liste.ajouter(1, 0);
		liste.ajouter(2, 1);

		while(!liste.estVide()) {
			System.out.println(liste.enlever(0));
		}
		
	}
	
}
