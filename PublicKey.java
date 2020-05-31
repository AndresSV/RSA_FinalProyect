
public class PublicKey {

	private long n, 
				 e,
				 d;
	
	public PublicKey(long n, long e, long d) {
		// TODO Auto-generated constructor stub
		this.n = n;
		this.e = e;
		this.d = d;
	}
	
	public long getN() {
		return this.n;
	}
	
	public long getE() {
		return this.e;
	}
	
	public String toString() {
		return "n: " + this.n + ", e: " + this.e;
	}
	
	public long getD() {
		return this.d;
	}
}
