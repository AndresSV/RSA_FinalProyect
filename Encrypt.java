import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

public class Encrypt {

	public static BigInteger[] encrypt(String message, PublicKey publicKey) {
		return Tools.fastExponentiation(message, publicKey.getE(), publicKey.getN());
	}



	public static void main(String[] args) {
		//System.out.println(encrypt("Hola", 26));
		PublicKey publicKey = new PublicKey(33, 3,7);
		//System.out.println(Arrays.toString(atoi("4")));
		System.out.println(Arrays.toString(encrypt("4", publicKey)));
		//encrypt("4", publicKey);
		//System.out.println("413130191675859211796859746472546052775870464");
	}
}
