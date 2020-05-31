import java.math.BigInteger;
import java.util.Arrays;

public class Decrypt  {
	
	public static String decrypt(BigInteger[] message, long d, long mod) {
		String res = "";
		BigInteger[] temp = Tools.fastExponentiation(message, d, mod);
		for (int i = 0; i < temp.length; i++) {
			res += String.valueOf(temp[i]);
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(encrypt("Hola", 26));
		PublicKey publicKey = new PublicKey(161, 3,7);
		//System.out.println(Arrays.toString(atoi("4")));
		System.out.println(Arrays.toString(Encrypt.encrypt("4", publicKey)));
		//encrypt("4", publicKey);
		//System.out.println("413130191675859211796859746472546052775870464");
		System.out.println(decrypt(Encrypt.encrypt("4", publicKey), 54, 161));

	}

}
