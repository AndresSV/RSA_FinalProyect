import java.util.Random;

public class AlgorithmRSA { 
	
	private static final int[] primos = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 
			31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 
			73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 
			127, 131, 137, 139, 149, 151, 157, 163, 167, 173 };

	private long p,
	q,
	n,
	phi,
	e,
	d;
	
	public PublicKey publicKey;

	public AlgorithmRSA() {
		this.setP();
		this.setQ();
		this.setN();
		this.setPhi();
		this.setE();
		this.setD();
		publicKey = new PublicKey(getN(), getE(), getD());
	}

	private long getP() {
		return this.p;
	}

	private long getQ() {
		return this.q;
	}

	private long getN() {
		return this.n;
	}

	private long getPhi() {
		return this.phi;
	}

	private long getE() {
		return this.e;
	}
	
	private long getD() {
		return this.d;
	}

	private void setP() {
		int min = 0,
				max = primos.length - 1;
		this.p = primos[(int) random(min,max)];
	}

	private void setQ() {
		int min = 0,
				max = primos.length - 1;
		this.q = primos[(int) random(min,max)];
	}

	private void setN() {
		n = this.getP() * this.getQ();
		if (n < 128 || n > 1000 ) {
			setQ();
			setN();
		}
	}

	private void setPhi() {
		this.phi = (this.getP()-1) * (this.getQ()-1);
	}

	private void setE() {
		long tmp = random(1, (int) (phi));
		long rn = Tools.mcd(tmp,getPhi());
		int n = 0;
		while ( rn != 1 ) {
			tmp = random(1, (int) (phi));
			rn = Tools.mcd(tmp,getPhi());
			n++;
		}
		this.e = tmp;
	}
	
	private void setD() {
		this.d = Tools.modInverse(getE(), getPhi());
	}

	private static long random(int min, int max) {
		return min + (long)(Math.random() * ((max - min) + 1));
	}
	
	public String toString() {
		return "p : " + this.p + ", q :" + this.q + " n :" + 
				this.n + " phi :" + this.phi + " e :" + this.e + " d :" + this.d +
				"\nPK:" + this.publicKey;
	}

	public static void main(String[] args) {
		AlgorithmRSA rsa = new AlgorithmRSA();
		System.out.println(rsa);
	}
}