

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Test {

	private static final Scanner scanner = new Scanner(System.in);
	public static int B;
	public static int H;
	public static boolean flag;
	
	private static int sockMerchant(int n, int[] ar) {
		int count =0;
        for(int i=0;i<n-1; i++){
            	if(i<n&& ar[i] == ar[i+1]) {
            		count++;
            		i = i + 1;
            	}

        }
		return count;

    }
	
	public static String findDay(int month, int day, int year) throws ParseException {
        String dateString = String.valueOf(month) +"-"+ String.valueOf(day)+"-" + String.valueOf(year);
        Date date = new SimpleDateFormat("MM-dd-yyyy").parse(dateString);
        return String.valueOf(date.getDay());
    }
	
	public static int jumpingOnClouds(int[] c) {
		int jumps = 0;
        List<Integer> resList = new ArrayList<>();
        for(int i=0;i<c.length-1; i++){
            if(c[i]==1){
            	resList.add(i);
            }
        }
		return jumps;

    }
	
	public static int alternatingCharacters(String s) {
        int count = 0;
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i) == s.charAt(i+1)){
                count++;
            }
        }
        return count;
    }
	
	public String twoStrings(String s1, String s2) {
		List<String> wordList1 = new ArrayList<String>();
		List<String> wordList2 = new ArrayList<String>();
		String subString1 = null;
		String subString2 = null;
		int l1= s1.length();
		int l2= s2.length();
		for(int i=0;i<l1;i++) {
			for(int j=i+1;j<=l1;j++) {
				subString1 = s1.substring(i,j);
				wordList1.add(subString1);
			}
		}
		
		for(int i=0;i<l2;i++) {
			for(int j=i+1;j<=l2;j++) {
				subString2 = s2.substring(i,j);
				wordList2.add(subString2);
			}
		}
		for(String str1 : wordList1) {
	        boolean found = false;
	        for(String str2 : wordList2) {
	            if(str1.equals(str2)) {
	                found = true;
	                break;
	            }
	        }
	        if (found) {
	            return "YES";
	        }
	    }    
	    return "NO";
	}
	
	public static String twoStringss(String s1, String s2) {
		int[] cache = new int[256];

        for (int i = 0; i < s1.length(); i++) {
            cache[(int)s1.charAt(i)]++;
        }

        for (int i = 0; i < s2.length(); i++) {
            if ((int)cache[s2.charAt(i)] != 0) {
                return "YES";
            }
        }

        return "NO";
    }
	
	
	public static int numberNeeded(String first, String second) {
        int[] freqFirst = new int[26];
        int[] freqSecond = new int[26];
        int deletions = 0;
        
        for(int i = 0; i < first.length(); i++)
            freqFirst[first.charAt(i)-'a'] = freqFirst[first.charAt(i)-'a'] + 1; //Increment frequency of char at i
        for(int i = 0; i < second.length(); i++)
            freqSecond[second.charAt(i)-'a'] = freqSecond[second.charAt(i)-'a'] + 1; //Increment frequency of char at i
        
        for(int i = 0; i < 26; i++)
            deletions += Math.abs(freqFirst[i] - freqSecond[i]); //Track the total deletions needed
        
        return deletions;
    }

	public static void main(String[] args) {
        Test test = new Test();
        String s = "test1";
        s.concat("test2");
        int[] ar = {1,2,3,4,5};
        String a = "cde";
        String b = "dcf";
        int d=4;
        String result = test.twoStringss("party", "qos");
        System.out.println(result);
    }
}
