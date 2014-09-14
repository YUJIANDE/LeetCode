import java.util.ArrayList;
import java.util.List;


/*
 * https://oj.leetcode.com/problems/restore-ip-addresses/
 */
public class RestoreIPAddress {
	public List<String> restoreIpAddresses(String s) {
		List<String> result = new ArrayList<String>();
		
		resolve(s, "", 0, result);
		
		return result;
    }
	
	/**
	 * number start with 0 with multiple digits is not a valid number. e.g."01" as "1" is not valid.
	 * @param s
	 * @return
	 */
	private int getNumber(String s) {
		if(s.length() > 1 && s.startsWith("0")) {
			return -1;
		}else {
			return Integer.parseInt(s);
		}
	}
	
	/**
	 * recursive way
	 * @param src the "pattern"
	 * @param result a possible result
	 * @param index current parsing index
	 * @param all result to the final
	 */
	private void resolve(String src, String result, int index, List<String> all) {
		if(index == 3) {
			if(src.length() <=3) {
				int num = getNumber(src);
				if(num >=0 && num <=255) {
					result += "." + num;
					all.add(result);
				}
			}
			return;
		}
		for(int i=1;i<=3 && src.length() > i;i++) {
			int num = getNumber(src.substring(0, i));
			if(num>=0 && num<=255) {
				resolve(src.substring(i), result + ((index==0) ? "" : ".") + num, index+1, all);
			}
		}
	}
	
}
