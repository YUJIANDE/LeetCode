public class ReverseWords {
    public static String reverseWords(String s) {
    	char[] str = s.toCharArray();
    	StringBuffer result = new StringBuffer();
    	int len = str.length;
    	//1. reverse the entire string
    	for(int i=0;i<len/2;i++){
    		char temp = str[i];
    		str[i] = str[len-1-i];
    		str[len-1-i] = temp;
    	}
    	//2. reverse each word.
    	for(int i=0;i<len;i++){
    		if(str[i] == ' '){
    			continue;
    		}
    		int begin = i, end = i;
    		while(i < len && str[i] != ' '){
    			i++;
    			end++;
    		}
    		int wordLen = end-begin;
    		for(int j=0; j< wordLen; j++){
    			result.append(str[begin+wordLen-1-j]);
    		}
    		result.append(' ');
    	}
    	return result.toString().trim();
    }
}