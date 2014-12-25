import java.util.ArrayList;
import java.util.List;


public class PalindromePartition {
	public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<List<String>>();
		
		if(s.length() == 0) {
			return result;
		}
		
		for(int i=0;i<s.length();i++) {
			String pre = s.substring(0, i+1);
			
			if(isPalindrome(pre)) {
				List<List<String>> post = partition(s.substring(i+1));
				for(int j=0;j<post.size();j++) {
					post.get(j).add(0, pre);
				}
				result.addAll(post);
			}
			
		}
		
		return result;
		
	}
	
	private boolean isPalindrome(String s) {
		boolean result = true;
		if(!s.isEmpty()){
			int left = 0,
				 right = s.length()-1;
			while(left <= right) {				
				if(s.charAt(left) != s.charAt(right)) {
					result = false;
					break;
				}
				left++;
				right--;
			}
			
		}
		return result;
	}
	
}
