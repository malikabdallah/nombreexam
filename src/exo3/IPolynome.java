package exo3;

/**
 * Cette interface decrit les methodes qui doivent etre fournies par une classe
 * qui represente un polynome.
 * 
 * @author Jean-Guy Mailly
 *
 */
public interface IPolynome {

	/**
	 * Permet d'obtenir le coefficient associe a un certain degre dans le polynome.
	 * 
	 * @param degre le degre
	 * @return le coefficient associe au degre.
	 */
	public int coefficient(int degre);

	/**
	 * Cree un nouvel objet qui correspond a l'addition du polynome courant et de
	 * celui passe en parametre.
	 * 
	 * @param p le polynome qui est additione au polynome courant.
	 * @return un nouvel objet qui represent la somme du polynome courant et de p
	 */
	public IPolynome addition(IPolynome p);
	
	/**
	 * Evalue le polynome pour une valeur precise de la variable x.
	 * @param x la valeur de la variable
	 * @return la valeur du polynome en x
	 */
	public double evaluer(double x);

}
