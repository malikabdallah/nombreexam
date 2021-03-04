package exo3;

public class TestPolynome {

	public static void main(String[] args) {
		int coef[]= new int[3];
		coef[0]=2;
		coef[1]=3;
		coef[2]=4;
		Polynome poly = new Polynome(coef);
		if (poly == null) {
			System.err.println(
					"Remplacez la ligne **Polynome poly = null ;** de la methode main pour initialiser le polynome avec votre constructeur !");
			System.err.println("Utilisez le polynome donne en exemple sur le sujet : 2 + 3 x - 4 x^3");
			System.exit(0);
		}

		System.out.println("Le polynome est : " + poly.toString() + ".");
		for (int i = 0; i <=coef.length-1; i++) {
			System.out.println("Le coefficient de degre " + i + " est " + poly.coefficient(i) + ".");
		}

		/*Polynome poly2 = null;
		if (poly2 == null) {
			System.err.println(
					"Remplacez la ligne *Polynome poly2 = null ;* de la methode main pour initialiser le second polynome avec votre constructeur !");
			System.err.println("Utilisez le polynome donne en exemple sur le sujet : 3 - x + 4 x^2");
			System.exit(0);
		}
		System.out.println(
				"La somme de " + poly.toString() + " et " + poly2.toString() + " est " + poly.addition(poly2) + ".");

		for (int x = 0; x < 10; x++) {
			System.out.println("La valeur de " + poly.toString() + " pour x = " + x + " est " + poly.evaluer(x));
			System.out.println(
					"La valeur de " + poly.toString() + " pour x = " + (x + 0.5) + " est " + poly.evaluer(x + 0.5));
		}*/
	}

}
