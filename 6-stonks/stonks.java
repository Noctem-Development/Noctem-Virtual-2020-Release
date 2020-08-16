import java.util.*;
import java.io.*;

public class stonks {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new FileReader("stonks.in"));
		int n = Integer.parseInt(in.readLine());
		stonk[] sorted = new stonk[n];
		for(int i = 0; i < n; i++) {
			int stonk = Integer.parseInt(in.readLine());
			sorted[i] = new stonk(stonk, i);
		}
		in.close();
		Arrays.sort(sorted);
		int[] bit = new int[n + 1];
		int max = 0;
		int maxindex = 0;
		for(int i = 0; i < n; i++) {
			update(bit, sorted[i].index, 1);
			int gooddays = sum(bit, n - 1) - sum(bit, sorted[i].index);
			if(gooddays > max) {
				max = gooddays;
				maxindex = sorted[i].index;
			}
		}
		PrintWriter out = new PrintWriter("stonks.out");
		out.println(maxindex + 1);
		out.close();
	}
	static void update(int[] bit, int index, int add) {
		index += 1;
		while(index < bit.length) {
			bit[index] += add;
			index += index & -index;
		}
	}
	static int sum(int[] bit, int index) {
		index += 1;
		int res = 0;
		while(index > 0) {
			res += bit[index];
			index -= index & -index;
		}
		return res;
	}
	static class stonk implements Comparable<stonk> {
		int value, index;
		stonk(int v, int i) {
			value = v;
			index = i;
		}
		@Override
		public int compareTo(stonk o) {
			if(value < o.value) return 1;
			else if(o.value < value) return -1;
			else {
				if(index < o.index) return 1;
				else if(o.index < index) return -1;
				else return 0;
			}
		}
	}
}
