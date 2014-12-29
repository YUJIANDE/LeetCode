
public class DecodeWays {
	public int numDecodings(String s) {
		int[] ways = new int[s.length()];
		
		if(s.length() == 0) {
			return 0;
		}else{
			int v = s.charAt(0) - '0';
			if(v <=0 || v >9) {
				return 0;
			}
			ways[0] = 1;
			
			if(s.length()>=2) {
				if(isSingleDigit(s.charAt(1))) {
					if(isDoubleDigits(s.charAt(0), s.charAt(1))) {
						ways[1] = 2;
					}else {
						ways[1] = 1;
					}
				}else {
					if(isDoubleDigits(s.charAt(0), s.charAt(1))) {
						ways[1] = 1;
					}else {
						ways[1] = 0;
					}
				}
				for(int i=2;i<s.length(); i++) {
					 int r = 0;
					 if(isSingleDigit(s.charAt(i))) {
						 r += ways[i-1];
					 }
					 if(isDoubleDigits(s.charAt(i-1), s.charAt(i))) {
						 r += ways[i-2];
					 }
					 ways[i] = r;
				}
				return ways[ways.length-1];
			}else {
				return 1;
			}
		}
		
    }
	
	private boolean isSingleDigit(char a) {
		int r = a - '0';
		return r>0 && r<=9;
	}
	
	private boolean isDoubleDigits(char a1, char a2) {
		int r1 = a1 - '0',
				r2 = a2 - '0',
				r = r1 *10 + r2;
		return r1>=1 && r1<=2 && r2>=0 && r2<=9 && r>=10 && r<=26;
	}
	
}
