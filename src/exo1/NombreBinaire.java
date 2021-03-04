package exo1;
import java.lang.Math;
public class NombreBinaire extends Number implements Comparable<NombreBinaire> {

	/**
	 * Ne pas tenir compte de cet attribut, qui est present pour assurer la
	 * compatibilite avec l'interface Serializable.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Les bits du nombre binaire. bits[0] represente le bit de poids faible, tandis
	 * que bits[bits.length - 1] represente le bit de poids fort.
	 */
	private boolean[] bits;

	/**
	 * Cree un nombre binaire de 32 bits, dont la valeur est le nombre entier 0.
	 */
	public NombreBinaire() {
		bits=new boolean[5];
		
	}

	/**
	 * Cree un nombre binaire avec un nombre de bits donne, dont la valeur est le
	 * nombre entier 0.
	 * 
	 * @param nbBits le nombre de bits du nombre binaire
	 */
	public NombreBinaire(int nbBits) {
		bits=new boolean[nbBits];
	}

	/**
	 * Cree un nombre binaire a partir d'un tableau de booleens qui representent les
	 * bits.
	 * 
	 * @param bits les bits du nombre binaire
	 */
	public NombreBinaire(boolean[] bits) {
		bits=new boolean[bits.length];
		for(int i=0; i<=bits.length-1; i++) {
			
		}
	}

	/**
	 * Cree un nombre binaire avec un nombre de bits donne, dont la valeur est
	 * donnee en parametre. Attention : si la valeur est trop grande pour etre
	 * representee sur le nombre de bits voulus, vous devez prevoir cela et creer un
	 * tableau plus grand.
	 * 
	 * @param nbBits le nombre de bits du nombre binaire
	 * @param val    la valeur entiere a representer
	 */
	public NombreBinaire(int nbBits, int val) {
		int nombredeBitsNecessaires=val<0?4:(32-Integer.numberOfLeadingZeros(val))/8+1;
		if(nbBits>=nombredeBitsNecessaires) {
		
			bits=new boolean[nbBits];
			for(int i=nbBits-1; i>=0; i--) {
				bits[i]= (val & (1 << i)) != 0;
			}
		}else {
			bits=new boolean[nombredeBitsNecessaires];
		}
	
	}

	@Override
	public int intValue() {
		double valeur=0;
		for(int i=0; i<=bits.length-1; i++) {
			if(i==0) {
				if(bits[i]!=false) {
					valeur=valeur+1;
				}else {
					valeur=valeur+0;

				}
				
			}else {
				if(bits[i]!=false) {
					valeur=valeur+Math.pow(2,i);
				}
			}
		}
		int v=(int) valeur;
		return v;
	}

	@Override
	public long longValue() {
		return (long)(this.intValue());
	}

	@Override
	public float floatValue() {
		return (float)this.intValue();
	}

	@Override
	public double doubleValue() {
		return (double)this.intValue();
	}

	/**
	 * Modifie le nombre entier pour representer l'entier suivant. Attention : si la
	 * nouvelle valeur est trop grande pour etre representee avec le nombre de bits
	 * actuel, vous devez prevoir cela et creer un tableau plus grand.
	 */
	public void incrementer() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public String toString() {
		String s="";
		for(int i=0; i<=bits.length-1; i++) {
			if(bits[i]==false) {
				s=s+0;
			}else {
				s=s+1;
			}
		}
		return s;
	}

	@Override
	public int compareTo(NombreBinaire n) {
		return this.intValue()-n.intValue();
	}

}
