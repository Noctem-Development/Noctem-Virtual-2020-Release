import java.io.*;

public class spring {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new FileReader("spring.in"));
		int n = Integer.parseInt(in.readLine());
		int[] rolls = new int[n];
		for(int i = 0; i < n; i++) {
			rolls[i] = Integer.parseInt(in.readLine());
		}
		in.close();
		long res = 0;
		long[] dp = new long[n];
		for(int i = 0; i < n; i++) {
			dp[i] = rolls[i];
			for(int j = 0; j < i; j++) {
				if(rolls[i] >= rolls[j]) {
					dp[i] = Math.max(dp[i], dp[j] + rolls[i]);
				}
			}
			res = Math.max(res, dp[i]);
		}
		PrintWriter out = new PrintWriter("spring.out");
		out.println(res);
		out.close();
	}
}
