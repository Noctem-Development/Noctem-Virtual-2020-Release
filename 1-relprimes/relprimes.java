import java.io.*;
import java.util.*;

public class relprimes {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("relprimes.in"));
		long a = in.nextLong();
		long b = in.nextLong();
		in.close();
		boolean isRel = true;
		for(long i = 2; i < Math.sqrt(Math.max(a, b)); i++){
			if(a % i == 0 && b % i == 0){
				isRel = false;
				break;
			}
		}

		PrintWriter out = new PrintWriter(new File("relprimes.out"));
		if(isRel){
			System.out.println(1);
			out.println(1);
		}else{
			System.out.println(0);
			out.println(0);
		}
		out.close();
	}
}
