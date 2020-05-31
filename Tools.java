import java.math.BigInteger;
import java.util.Arrays;

public class Tools {

	public static long mcd(long p, long q) {
		if (q == 0) {
			return p;
		}
		return mcd(q, p % q);
	}

	public static int modInverse(long a, long m) { 
		a = a % m; 
		for (int x = 1; x < m; x++) 
			if ((a * x) % m == 1) 
				return x; 
		return 1; 
	} 

	// n es para el modulo, e es para la exp
	
	
	public static BigInteger[] fastExponentiation(String message, long exp, long mod) {
		String binary = Long.toBinaryString(exp);
		BigInteger[] tmp = atoi(message),
					 ans = atoi(message);
		for (int i = 0; i < binary.length() ; i++) {
			char c = binary.charAt(i);
			for (int j = 0; j < ans.length; j++) {
				if (c == '1' && i!=0) {
					ans[j] = ans[j].pow(2);
					ans[j] = ans[j].multiply(tmp[j]);
				} else if (c == '0' && i!=0){
					ans[j] = ans[j].pow(2);
				}
			}
		}
		for (int i = 0; i < ans.length; i++) {
			ans[i] = ans[i].mod(new BigInteger(mod+""));
		}
		return ans;
	}

	public static BigInteger[] fastExponentiation(BigInteger[] message, long exp, long mod) {
		String binary = Long.toBinaryString(exp);
		BigInteger[] ans = Arrays.copyOf(message, message.length);
		for (int i = 0; i < binary.length() ; i++) {
			char c = binary.charAt(i);
			for (int j = 0; j < ans.length; j++) {
				if (c == '1' && i!=0) {
					ans[j] = ans[j].pow(2);
					ans[j] = ans[j].multiply(message[j]);
				} else if (c == '0' && i!=0){
					ans[j] = ans[j].pow(2);
				}
			}
		}
		for (int i = 0; i < ans.length; i++) {
			ans[i] = ans[i].mod(new BigInteger(mod+""));
		}
		return ans;
	}
	
	
	//ASCII to Int valueOf
	
	public static BigInteger[] atoi(String str) {
		BigInteger[] ans = new BigInteger[str.length()];
		for (int i = 0; i < str.length(); i++) {
			long tmp = str.charAt(i);
			ans[i] = new BigInteger(Long.toString(tmp));
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(atoi("4")));
	}
	
}
