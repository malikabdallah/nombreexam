package exo2;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CommunauteAgglomeration {

	/**
	 * Villes de la CA.
	 */
	private List<String> villes;

	/**
	 * Representation du voisinnage entre villes.
	 */
	private Map<String, List<String>> voisines;

	/**
	 * Liste des noms des villes qui contiennent une ecole.
	 */
	private List<String> ecoles;

	/**
	 * Construit une communaute d'agglomeration sans ville ni route.
	 */
	public CommunauteAgglomeration() {
		villes = new ArrayList<String>();
		voisines = new HashMap<String, List<String>>();
		ecoles = new LinkedList<String>();
	}

	/**
	 * Ajoute une ville (qui contiendra une ecole), si elle n'existe pas deja.
	 * 
	 * @param nomVille le nom de la nouvelle ville
	 * @return true si la ville a ete ajoutee
	 */
	public boolean ajouteVille(String nomVille) {
		return ajouteVille(nomVille, true);
	}

	/**
	 * Ajoute une ville (qui contiendra une ecole), si elle n'existe pas deja.
	 * 
	 * @param nomVille      le nom de la nouvelle ville
	 * @param contientEcole indique si la ville contient une ecole ou non
	 * @return true si la ville a ete ajoutee
	 */
	public boolean ajouteVille(String nomVille, boolean contientEcole) {
		if (villes.contains(nomVille))
			return false;

		villes.add(nomVille);
		voisines.put(nomVille, new ArrayList<String>());
		if (contientEcole)
			ecoles.add(nomVille);
		return true;
	}

	/**
	 * Ajoute une route entre deux villes si c'est possible. Une exception est levee
	 * si un des noms de villes est incorrect.
	 * 
	 * @param ville1 le nom de la premiere ville
	 * @param ville2 le nom de la seconde ville
	 * @return true si la route a ete ajoutee
	 */
	public boolean ajouteRoute(String ville1, String ville2) {
		if (!villes.contains(ville1)) {
			throw new IllegalArgumentException("La ville " + ville1 + " n'existe pas.");
		}
		if (!villes.contains(ville2)) {
			throw new IllegalArgumentException("La ville " + ville2 + " n'existe pas.");
		}

		if (voisines.get(ville1).contains(ville2)) {
			return false;
		}

		voisines.get(ville1).add(ville2);
		voisines.get(ville2).add(ville1);

		return true;
	}

	/**
	 * Ajoute une ecole dans une ville, si c'est possible (c'est-a-dire si elle
	 * n'existe pas deja).
	 * 
	 * @param nomVille le nom de la ville
	 * @return true si l'ecole a ete ajoutee
	 */
	public boolean ajouteEcole(String nomVille) {
		if (ecoles.contains(nomVille))
			return false;

		ecoles.add(nomVille);
		return true;
	}

	/**
	 * Retire une ecole d'une ville, si c'est possible (c'est-a-dire si elle
	 * existait).
	 * 
	 * @param nomVille le nom de la ville
	 * @return true si l'ecole a ete retiree
	 */
	public boolean retireEcole(String nomVille) {
		if (!ecoles.contains(nomVille)) {
			return false;
		}

		ecoles.remove(nomVille);
		return true;
	}

	/**
	 * Determine si une ville satisfait la contrainte d'accessibilite, c'est-a-dire
	 * soit elle contient une ecole, soit une de ses voisines contient une ecole.
	 * 
	 * @param nomVille le nom de la ville
	 * @return true si nomVille satisfait la contraint d'accessibilite
	 */
	public boolean accessibilite(String nomVille) {
		if(!villes.contains(nomVille)) {
			return false;
		}
		if(ecoles.contains(nomVille)) {
			return true;
		}
		List<String>villesVoisines=voisines.get(nomVille);
		for(int i=0; i<=villesVoisines.size()-1; i++) {
			String ville=villesVoisines.get(i);
			if(ecoles.contains(ville)) {
				return true;
			}
		
		}
		
		return false;
		
	}

	/**
	 * Determine si la CA satisfait la contrainte d'accessibilite, c'est-a-dire
	 * chaque ville satisfait la contrainte.
	 * 
	 * @return true si la CA satisfait la contrainte d'accessibilite
	 */
	public boolean accessibilite() {
		for(int i=0; i<=villes.size()-1; i++) {
			boolean accessible=this.accessibilite(villes.get(i));
			if(accessible==true) {
				return true;
			}
		
		}
		return false;
	}
	
	public void sauvegarder(String nomFichier) {
		try {
			
			File f=new File("sauvegardes");
			PrintWriter fichier1 = new PrintWriter(new FileWriter("sauvegarde"));
			for(int i=0; i<= villes.size()-1; i++) {
				fichier1.println("ville("+villes.get(i)+")");
			}
			for(String ville:voisines.keySet()) {
				List<String> villesVoisines=voisines.get(ville);
				for(int i=0; i<=villesVoisines.size()-1; i++) {
					fichier1.println("route("+ville+","+villesVoisines.get(i)+")");

				}
				
			}
			for(int i=0; i<= ecoles.size()-1; i++) {
				fichier1.println("ecole("+ecoles.get(i)+")");
			}
			fichier1.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
