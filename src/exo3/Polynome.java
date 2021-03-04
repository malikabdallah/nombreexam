package exo3;

public class Polynome implements IPolynome {
	
	int coef[];
	
	public Polynome(int coef[]) {
		this.coef=new int[coef.length];
		for(int i=0; i<=coef.length-1; i++) {
			this.coef[i]=coef[i];
		}
	}
	
	public Polynome(int coef[], int degre[]) {
		this.coef=new int[degre.length];
		for(int i=0; i<=degre.length-1;i++) {
			if(degre[i]<0) {
				throw new IllegalArgumentException("pas de degre negatif");
			}
			this.coef[i]=coef[i];
		}
	}

	@Override
	public int coefficient(int degre) {
		if(degre<0) {
			throw new IllegalArgumentException("pas de degre negatif");

		}
		if(degre>=coef.length) {
			throw new IllegalArgumentException("degre trop grand");

		}
		return coef[degre];
	}

	@Override
	public IPolynome addition(IPolynome p) {
		for(int i=0; i<=coef.length-1; i++) {
			int coeffP=p.coefficient(i);
			coef[i]=coef[i]+coeffP;
					
		}
		
		return new Polynome(coef);
	}

	@Override
	public double evaluer(double x) {
		double v=0;
		for(int i=0; i<=coef.length-1; i++) {
			v=v+Math.pow(x, i);
		}
		return v;
	}
	
	@Override
	public String toString() {
		String s="";
		for(int i=0; i<=coef.length-1; i++) {
			s=s+coef[i]+"x^"+i+" ";
			
		}
		return s;

	}

}
