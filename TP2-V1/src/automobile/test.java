package automobile;

public class test {

	public static void main(String[] args) {
		Compteur compteur = new Compteur();
		compteur.setPartiel(1000);
		System.out.println(compteur);
		compteur.resetPartiel();
		System.out.println(compteur);
		
		Vehicule vehicule = new Vehicule(1);
		System.out.println(vehicule);
		vehicule.faireLePlein();
		System.out.println(vehicule);
		vehicule.rouler(10);
		System.out.println(vehicule);
		vehicule.rouler(10);
		System.out.println(vehicule);
	}

}
