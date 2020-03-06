import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

public class Algorithm {

	private static boolean isValidList(List<Integer> list, int k) {
		int size = list.size();
		if (size == 0 || list.isEmpty()) {
			return false;
		}
		int temp = 0;
		for (int value : list) {
			temp = k - value;
			if (list.contains(temp)) {
				return true;
			}

		}
		return false;
	}

	private static int[] productList(int[] numArray) {
		int[] productArray = new int[numArray.length];
		int productOfNums = 1;
		for (int i : numArray) {
			productOfNums *= i;
		}
		for (int i = 0; i < numArray.length; i++) {
			productArray[i] = productOfNums / numArray[i];
		}
		return productArray;
	}

	private static int findInteger(int[] numArray) {
		int length = numArray.length;
		int result = 0;
		Arrays.sort(numArray);
		for (int i = 0; i < length - 1; i++) {
			if (numArray[i] > 0 && numArray[1] < 1) {
				return 1;
			}
			if (numArray[i] > 1 && numArray[i + 1] != numArray[i]
					&& numArray[i + 1] != numArray[i] + 1) {
				result = numArray[i] + 1;
			}
		}
		if (result == 0)
			result = numArray[length - 1] + 1;
		return result;
	}

	private static boolean isPrimeNumber(int num) {
		if (num <= 1)
			return false;

		for (int i = 2; i < num; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

	private static int findWays(String input) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		for (char c = 'a'; c <= 'z'; ++c) {
			map.put(Math.abs(c - 'a' + 1), String.valueOf(c));
		}
		List<String> decodedWays = new ArrayList<String>();
		List<String> ways = new ArrayList<String>();
		for (int i = 1; i <= input.length(); i++) {
			String temp = input.substring(0, i);
			if (StringUtils.isNotBlank(temp)) {
				decodedWays.add(temp);
			}
		}
		for (String s : decodedWays) {
			int decodedInt = Integer.valueOf(s);
			if (decodedInt != 0 && decodedInt <= 26) {
				String resultedString = map.get(decodedInt);
				ways.add(resultedString);
			}
		}
		return ways.size();

	}

	private static int calculateMaxSum(int[] numArr) {
		int element = numArr[0];
		int temp = 0;
		int result = 0;
		for (int i = 1; i < numArr.length; i++) {
			result = (element > temp) ? element : temp;

			element = temp + numArr[i];
			temp = result;
		}
		return (element > temp) ? element : temp;
	}

	public static int[] examineStockPrices(int[] stockPrices, int[] days) {
		int[] result = new int[days.length];
		if (stockPrices.length <= 0 || days.length <= 0) {
			return null;
		}
		for (int x = 0; x < days.length; x++) {
			int day = days[x];
			int dayPrice = stockPrices[day - 1];
			for (int y = 0; y < stockPrices.length; y++) {
				if (dayPrice < stockPrices[y]) {
					result[x] = -1;
				}
				if (stockPrices[y] < dayPrice) {
					result[x] = y + 1;
					break;
				}
				continue;
			}
		}
		return result;
	}
	
	static int minimumAbsoluteDifference(int[] arr) {
		List<Integer> arrList =  new ArrayList<>();
		Arrays.parallelSort(arr);
		for(int i=0;i<arr.length-1;i++) {
			arrList.add(Math.abs(arr[i]-arr[i+1]));

		}
		Collections.sort(arrList);
		return arrList.get(0);
		
    }


	public void checkMagazine(String[] magazine, String[] ransom) {
		if (ransom.length > magazine.length) {
			System.out.println("No");
			return;
		}
		Hashtable<String, Integer> helper = new Hashtable<>();
		for (String s : magazine) {
			if (!helper.containsKey(s)) {
				helper.put(s, 1);
			} else {
				helper.put(s, helper.get(s) + 1);
			}
		}
		for (String s : ransom) {
			if (helper.containsKey(s)) {
				helper.put(s, helper.get(s) - 1);
				if (helper.get(s) < 0) {
					System.out.println("No");
					return;
				}
			} else {
				System.out.println("No");
				return;
			}
		}
		System.out.println("Yes");
	}
	
	public int[] bubbleSort(int[] a) {
		 int i,j,temp =0;
		 int count=0;
	        for(i=0;i<a.length;i++){
	            for(j=i+1;j<a.length;j++){
	            	while(a[i] > a[j]) {
	                temp = a[i];
	                a[i] = a[j];
	                a[j]=temp;
	                count ++;
	                }
	            }
	        }
	        return a;
	}
	
	public String twoStrings(String s1, String s2) {
		
		int l1=s1.length();
		int l2=s2.length();
		String longerString = null;
		String shorterString = null;
		if(l1>l2) {
			longerString = s1;
		shorterString = s2;
		}
		else { longerString = s2;shorterString = s1;}
		for(char c: longerString.toCharArray()) {
		if(longerString.indexOf(c) > -1 && shorterString.indexOf(c) > -1) {
			return "YES";
		}
		}
		return "NO";
	}
	
	public static void main(String[] args) {
	int[] arr1 = { 1, -3, 71, 68, 17};
		String[] arr2 = { "ive", "got", "ive","coconuts"};
		Algorithm algo = new Algorithm();
		int result = algo.minimumAbsoluteDifference(arr1);
		System.out.println(result);
	}

}

