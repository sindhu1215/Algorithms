import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public class Solution {

	private long repeatedString(String s, long n) {
		long count = 0;
		long initialCount = 0;
		if (!s.contains("a"))
			return 0;
		char[] sCharAr = s.toCharArray();

		for (int c = 0; c < s.length(); c++) {
			if (sCharAr[c] == 'a') {
				initialCount++;
			}
		}

		long multiplier = n / s.length();
		count += multiplier * initialCount;

		long remainder = n % s.length();
		for (int i = 0; i < remainder; i++) {
			if (sCharAr[i] == 'a') {
				count++;
			}
		}
		return count;
	}
	
	private void stringTokens(String s) {
		s = s.trim();
		String[] words = s.split("[!,?.*_'@\\\\ ]+");
		List<String> result = new ArrayList<>();
		for(String word: words) {
			if(word.matches("[A-Za-z !,?._'@]+,")) {
				result.add(word);
			}
			
		}
		System.out.println(result.size());
		for(String word: result) {
			System.out.println(word);
		}
	}
	
	private int romanNumeral(String s) {	
		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		int l = s.length();
		int result = 0;
		
		for (int i = 0; i < l ; i++) {
			int c1 = map.get(s.charAt(i));
			if(i+1 < l) {
			int c2 = map.get(s.charAt(i + 1));
			if ( c1 >= c2) {
				result += c1;
			} else {
				result += c2 - c1;
				i++;
			}
			}
			else {
				result += c1;
				i++;
			}

		}
		return result;
	}
	
	
	private boolean containsUniqueCharacters(String str) {
		boolean result = false;
		Set<Character> set = new HashSet<>();
		for(Character c: str.toCharArray()) {
			set.add(c);
			if(set.size() == str.length()) {
				result = true;
			}
			else {
				result = false;
			}
		}
		return result;
	}

	private int validPair(List<Integer> numList, int n) {
		int count = 0;
		Set<Integer> numSet = new HashSet<Integer>(numList);
		for (int i : numSet) {
			if (numSet.contains(i + n))
				count++;
		}
		return count;

	}

	private static String longestSubstring(String str, int k) {
		String result = null;
		List<String> wordList = new ArrayList<>();
		Set<Character> wordSet = null;
		List<String> resultList = new ArrayList<>();
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				result = str.substring(i, j);
				wordList.add(result);
			}
		}
		for (String word : wordList) {
			wordSet = new HashSet<>();
			for (Character c : word.toCharArray()) {
				wordSet.add(c);
			}
			if (wordSet.size() == k && !resultList.contains(word)) {
				resultList.add(word);
			}
		}
		int maxLength = 0;
		for (String s : resultList) {

			if (s.length() > maxLength) {
				maxLength = s.length();
				result = s;
			}
		}
		return result;
	}

	public static int maximumToys(int[] prices, int k) {
		int count = 0;
		int sum = 0;
		Arrays.sort(prices);
		for (int i = 0; i < prices.length; i++) {		
			if (sum + prices[i] <= k) {
				sum = sum + prices[i];
					count++;

			}
		}
		return count;

	}

	public static int sockMerchant(int n, int[] ar) {
		Arrays.sort(ar);
		int count = 0;
		for (int i = 0; i < n - 1; i++) {
			if (i < n && ar[i] == ar[i + 1]) {
				count++;
				i = i + 1;
			}

		}
		return count;

	}
	
	public static boolean editString(String s1, String s2) {
		int l1=s1.length();
		int l2=s2.length();
		int difference = Math.abs(l1-l2);
		int count =0;
		String longerString = null;
		String shorterString = null;
		if(l1>l2) {
			longerString = s1;
		shorterString = s2;
		}
		else { longerString = s2;shorterString = s1;}
		
		if(difference > 1) return false;
		
		else {
	
			for(char c: longerString.toCharArray()) {
				if(longerString.indexOf(c) != shorterString.indexOf(c)) {
					count++;
				}
				
				
			}

			
			if(count==1) {
				return true;
			}
		}
		
		
		
		return false;
	}

	static int[] examineStockPrices(int[] stockPrices, int[] days) {
		int resultDays[] = new int[days.length];
		for (int i = 0; i < days.length; i++) {
			int currentDay = days[i];
			resultDays[i] = -1;
			for (int k = currentDay - 1, j = currentDay - 1; j < stockPrices.length; k--, j++) {
				if (k - 1 >= 0 && stockPrices[k - 1] < stockPrices[currentDay - 1]) {
					resultDays[i] = k;
					break;
				} else if (j + 1 < stockPrices.length
						&& stockPrices[j + 1] < stockPrices[currentDay - 1]) {
					resultDays[i] = j + 1 + 1;
					break;
				}
			}

		}
		return resultDays;
	}

	
	public static int[] leftRotate(int arr[], int d) {
		int n = arr.length;
		for (int i = 0; i < d; i++) {
			int j, temp;
			temp = arr[0];
			for (j = 0; j < n - 1; j++)
				arr[j] = arr[j + 1];
			arr[j] = temp;
		}
		return arr;
	}

	public static boolean isPermutation(String s1,String s2) {
		boolean result = true;
		char[] arr1 = s1.toCharArray();
		char[] arr2 = s2.toCharArray();
		if(arr1.length != arr2.length) return false;
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		for(int i=0;i<arr1.length;i++) {
				if(arr1[i] != arr2[i]) {
					result = false;
				}
		}
		return result;
	}
	
	public static boolean isPalindrome(String s) {
		char[] arr = s.toCharArray();
		int n = arr.length/2;
		int l = arr.length;
		for(int i=0;i<n ;i++) {
			if(arr[i] != arr[l-(i+1)])
				return false;
			
			}
		
		return true;
	}
	
	public boolean palindromePermutation(String str) {
		str = str.toLowerCase();
		int l = str.length();
		if (l == 0)
			return false;
		int[] charset = new int[128];
		for (char c1 : str.toCharArray()) {
			charset[c1]++;
		}

		int count = 0;
		for (char c1 : str.toCharArray()) {
			if (l / 2 == 0 && charset[c1] != 2) {
				return false;
			} else if (l / 2 != 0 && charset[c1] != 2) {
				count++;
			}

		}
		return count == 1 ? true : false;
		
	}
	
	public boolean isPalindromePermutation(String s) {
		 Set < Character > set = new HashSet < > ();
	        for (int i = 0; i < s.length(); i++) {
	            if (!set.add(s.charAt(i)))
	                set.remove(s.charAt(i));
	        }
	        return set.size() <= 1;
	}
	public static boolean oneedit(String s1, String s2) {
	int m = s1.length(), n = s2.length(); 
	  
    // If difference between lengths is  
    // more than 1, then strings can't  
    // be at one distance 
    if (Math.abs(m - n) > 1) 
        return false; 
  
    int count = 0; // Count of edits 
  
    int i = 0, j = 0; 
    while (i < m && j < n) 
    { 
        // If current characters don't match 
        if (s1.charAt(i) != s2.charAt(j)) 
        { 
            if (count == 1) 
                return false; 
  
            // If length of one string is 
            // more, then only possible edit 
            // is to remove a character 
            if (m > n) 
                i++; 
            else if (m< n) 
                j++; 
            else // Iflengths of both strings 
                // is same 
            { 
                i++; 
                j++; 
            } 
              
            // Increment count of edits  
            count++; 
        } 
  
        else // If current characters match 
        { 
            i++; 
            j++; 
        } 
    } 
  
    // If last character is extra  
    // in any string 
    if (i < m || j < n) 
        count++; 
  
    return count == 1; 
} 
	

	public boolean rotateStrings(String s1, String s2) {
		if(s1.length() != s2.length())
			return false;
		List<String> wordList = new ArrayList<String>();
		String subString = null;
		String expectedString = s1.concat(s1);
//		for (int i = 0; i < expectedString.length(); i++) {
//			for (int j = i + 1; j <= expectedString.length(); j++) {
//				subString = expectedString.substring(i, j);
//				wordList.add(subString);
//			}
//		}
//		
//		for(String word : wordList) {
//		if(s2.equals(word))
//			return true;
//		}
		
		if(expectedString.indexOf(s2) != -1) {
			return true;
		}
		return false;
	}
	
	public void regexCheck(String regex) {
		try {
		Pattern p = Pattern.compile(regex);
		}catch(Exception e) {
		e.printStackTrace();	
		}
	}
	
	public int[] maxNumbers(int[] arr) {
		Arrays.sort(arr);
		int l = arr.length;
		int[] result = new int[2];
		result[0] = arr[l-1];
		result[1] = arr[l-2];
		
		while(result[0] == result[1] && l>0) {
			l--;
			result[1] = arr[l-2];
		}
		
		return result;
	}
	
	public boolean reverseString(String s){
        int l = s.length();
        StringBuilder str = new StringBuilder();
        for(int i=l-1;i>=0;i--){
            str.append(s.charAt(i));
        }
        
        if(str.toString().equals(s)){
            return true;
        }
        return false;
    }
	
	public boolean isAnagram(String a, String b) {
        int l1 = a.length();
        int l2= b.length();
        if(l1 != l2) return false;
        int[] charset = new int[128];
       a =  a.toLowerCase();
        for(int i=0;i<=l1-1;i++){
        	int c1 = a.charAt(i);
           charset[c1]++;
        }
        
       b = b.toLowerCase();
        for(int i=0;i<=l2-1;i++){
        	int c1 = b.charAt(i);
          charset[c1]--;
           if(charset[c1]<0) return false;
        }
        return true;

    }
	
	public String urlify(String str) {
		StringBuilder sb = new StringBuilder();
		char[] arr = str.toCharArray();
		for(char c : arr) {
			if(c==' ') {
				sb.append("%20");
			} else {
			sb.append(c);
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		Arrays.asList(1,2,3,4,5,6,7,8);
		int[] ar = { 0, 1, 1, 0,0 };
		int n = 50;
		
		
		int result = solution.romanNumeral("MCMXCIV");
		System.out.print( result);

	}

}

