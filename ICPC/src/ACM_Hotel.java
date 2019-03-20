import java.util.*;

public class ACM_Hotel {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		
		for (int i = 0; i < T; i++) {
			int H = s.nextInt();
			int W = s.nextInt();
			int N = s.nextInt();
			
			System.out.println(((N-1)%H*100+100)+((N-1)/H+1));
		}
		
		
	}

}
