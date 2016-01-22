import java.util.*;
import java.io.*;
import java.math.*;

public class Solution {

	public static BigInteger ksm(BigInteger A,BigInteger B,BigInteger N) {
		BigInteger ans = BigInteger.ONE;
		for (; !B.equals(BigInteger.ZERO); B = B.divide(BigInteger.valueOf(2))) {
			if (B.mod(BigInteger.valueOf(2)).equals(BigInteger.ONE)) {
				ans = ans.multiply(A);
				ans = ans.mod(N);
			}
			A = A.multiply(A);
			A = A.mod(N);
		}
		return ans;
	}
	
	public static void main(String[] args) {
		//File file = new File("limit.in");		
		Scanner in = new Scanner(System.in);
		int p = in.nextInt();
		int n = in.nextInt();
		BigInteger N = BigInteger.ONE;
		
		//System.out.println(N);
		
		//return;
		for (int i = 1; i <= n; i++)
			N = N.multiply(BigInteger.valueOf(i));
		BigInteger u = BigInteger.valueOf(p);
		while (true) {
			//break;
			if (ksm(BigInteger.valueOf(p),u,N).equals(u.mod(N))) break;
			u = u.multiply(BigInteger.valueOf(p));
		}
		
		System.out.println(u.mod(N));
	}
}
