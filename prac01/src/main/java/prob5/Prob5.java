package prob5;

public class Prob5 {
	public static void main(String[] args) {
		int n = 1;
		
		while(n < 100) {
			String str = "";
			String nStr = Integer.toString(n);
			if(nStr.contains("3") || nStr.contains("6") || nStr.contains("9")) {
				for(int i = 0 ; i < nStr.length() ; i++) {
					char c = nStr.charAt(i);
					if(c == '3' || c == '6' || c == '9') {
						str += "짝";
					}
				}
				System.out.println(n + " " + str);
			}
			n++;
		}
	}
}
