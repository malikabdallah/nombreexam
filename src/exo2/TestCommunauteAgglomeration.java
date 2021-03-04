package exo2;

public class TestCommunauteAgglomeration {

	public static void main(String[] args) {
		CommunauteAgglomeration ca = new CommunauteAgglomeration();
		String[] nomsVilles = { "Paris", "Marseille", "Lille", "Rennes", "Strasbourg" };

		for (String nomVille : nomsVilles) {
			ca.ajouteVille(nomVille);
		}

		ca.ajouteRoute("Paris", "Marseille");
		ca.ajouteRoute("Paris", "Lille");
		ca.ajouteRoute("Paris", "Rennes");
		ca.ajouteRoute("Paris", "Strasbourg");

		ca.retireEcole("Paris");

		// Modifiez la ligne suivante pour indiquer où vous voulez enregistrer le
		// fichier.
		ca.sauvegarder("/chemin/vers/le/fichier/sauvegarde_ca.txt");

		ca.retireEcole("Lille");
		if (ca.accessibilite("Lille")) {
			System.out.println("Lille a acces a une ecole.");
		} else {
			System.out.println("Lille n'a pas acces a une ecole.");
		}

		if (ca.accessibilite()) {
			System.out.println("La contrainte d'accessibilite est satisfaite.");
		} else {
			System.out.println("La contrainte d'accessibilite n'est pas satisfaite.");
		}

		ca.ajouteEcole("Lille");
		if (ca.accessibilite("Lille")) {
			System.out.println("Lille a acces a une ecole.");
		} else {
			System.out.println("Lille n'a pas acces a une ecole.");
		}

		if (ca.accessibilite()) {
			System.out.println("La contrainte d'accessibilite est satisfaite.");
		} else {
			System.out.println("La contrainte d'accessibilite n'est pas satisfaite.");
		}

	}
}
