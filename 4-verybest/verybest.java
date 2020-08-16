import java.util.*;
import java.io.*;

public class verybest {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new FileReader("verybest.in"));
		StringTokenizer line = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(line.nextToken());
		int m = Integer.parseInt(line.nextToken());
		int[] chickens = new int[n];
		for(int i = 0; i < n; i++) {
			chickens[i] = Integer.parseInt(in.readLine());
		}
		in.close();
		
		//Binary Search
		long lbound = 0;
		long rbound = (long)Math.pow(10, 14);
		long res = 0;
		while(lbound <= rbound) {
			long average = (lbound + rbound) / 2;
			if(catchable(average, chickens, m)) {
				res = average;
				rbound = average - 1;
			}else {
				lbound = average + 1;
			}
		}
		PrintWriter out = new PrintWriter("verybest.out");
		out.println(res);
		out.close();
	}
	
	//Returns whether or not it is possible to catch all the chickens given a K
	static boolean catchable(long k, int[] chickens, int m) {
		int index = 0;
		int ballsused = 0;
		while(index < chickens.length) {
			if(ballsused >= m) {
				return false;
			}
			long cursize = chickens[index];
			if(cursize > k) {
				return false;
			}
			index++;
			while(index < chickens.length && cursize + chickens[index] <= k) {
				cursize += chickens[index];
				index++;
			}
			ballsused++;
		}
		return true;
	}
}
