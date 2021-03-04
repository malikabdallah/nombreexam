package exo1;

public class TestNombreBinaire {

	public static void main(String[] args) {
		NombreBinaire nb = new NombreBinaire(4, 11);
		System.out.println(nb.toString() + " en binaire vaut " + nb.intValue() + " en base decimal.");

		/*for (int i = 0; i < 10; i++) {
			nb.incrementer();
			System.out.println(nb.toString() + " en binaire vaut " + nb.intValue() + " en base decimal.");
		}*/

		NombreBinaire nb2 = new NombreBinaire(4, 10);
		if (nb.compareTo(nb2) > 0) {
			System.out.println(nb.toString() + " est plus grand que " + nb2.toString());
		} else if (nb.compareTo(nb2) < 0) {
			System.out.println(nb.toString() + " est plus petit que " + nb2.toString());
		} else {
			System.out.println(nb.toString() + " est egal a " + nb2.toString());
		}
	}

}
