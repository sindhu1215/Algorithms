import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.w3c.dom.Node;

public class GayleArrays {
	
	public boolean uniqueString(String str) {
		if(str.length() > 128) return false;
		boolean[] charArray = new boolean[128];
		
		for(int i=0;i< str.length();i++) {
			int val = str.charAt(i);
			if(charArray[val]) return false;
			charArray[val] = true;
		} 
		return true;
	}
	
	public boolean isPermutation(String s1, String s2) {
		int l1= s1.length();
		int l2=s2.length();
		if(l1 != l2) return false;
		
		char[] arr1 = s1.toCharArray();
		char[] arr2 = s2.toCharArray();
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		return Arrays.equals(arr1, arr2);
		
//		int[] characters = new int[128];
//		for(char c : s1.toCharArray()) {
//			characters[c]++;
//		}
//		
//		for(char c: s2.toCharArray()) {
//			characters[c]--;
//			if(characters[c] < 0) return false;
		}
	
	public String stringCompression(String s) {
		int l = s.length();
		StringBuilder result = new StringBuilder();
		int count = 1;
		char temp;
		for (int i = 0; i < l-1; i++) {

			temp = s.charAt(i+1);
			
			if (s.charAt(i) == temp) {
				count++;
			} else if (s.charAt(i) != temp) {
				char p = s.charAt(i);
				result.append(p + String.valueOf(count));
				count = 1;
				
			}

		}
		if(count > 1) {
			result.append(s.charAt(l-1)+String.valueOf(count));
		}if (result.length() >= l)
			return s;
		
		return result.toString();
	}
		
	public boolean oneEditAway(String s1, String s2) {
		int l1 = s1.length();
		int l2 = s2.length();
		int count =0;
		if(Math.abs(l1-l2) > 1) return false;
		int i=0,j=0;
		while(i<l1 && j<l2) {
			if(s1.charAt(i)!= s2.charAt(j)) {
				
				if(l1>l2) {
					i++;
				} else if(l2>l1) {
					j++;
				} else {
					i++;
					j++;
				}
				
				count++;
			}
		
		else {
			i++;
			j++;
		}
		}
		if(i<l1||j<l2) {
			count++;
		}
		
		return count==1;
	}
	
	 public int findMaxSum(int[][] arr){
		 int R=arr.length;
		 int C = arr[0].length;
		 
		 if(R<4 || C<4) {
			 return -1;
		 }
		 
		 int maxSum = 0;
		 for(int row=0;row< 4 ;row++) {
			 for(int col=0;col<4;col++){
				 int sum  = arr[row][col]+arr[row][col+1]+arr[row][col+2]+
						 arr[row+1][col+1]+arr[row+2][col]+arr[row+2][col+1]+arr[row+2][col+2];
				 maxSum = Math.max(sum, maxSum);
			 }
		
		 }
		 return maxSum;
	 }
		
	
	 public int[][] rotateMatrix(int[][] arr){
		 int rows = arr.length;
		 int cols = arr[0].length;
		 if(rows == 0 || rows != cols) return arr;
		 for(int layer=0;layer<rows/2;layer++) {
			 int first = layer;
			 int last = rows-1-layer;
			 for(int i=0;i<last;i++) {
				 int offset = i-first;
				 int top = arr[first][i];
				 //left->top
				 arr[first][i] = arr[last-offset][first];
				 //bottom->left
				 arr[last-offset][first] = arr[last][last-offset];
				 //right-> bottom
				 arr[last][last-offset] = arr[i][last];
				 //top->right
				 arr[i][last] = top;
			 }
		 }
		 return arr;
	 }
	 
	 public int[][] zeroMatrix(int[][] arr){
		 boolean[] rows = new boolean[arr.length];
		 boolean[] cols = new boolean[arr[0].length];
		 
		 for(int i=0;i<rows.length;i++) {
			 for(int j=0;j<cols.length;j++) {
				 if(arr[i][j] == 0) {
					 rows[i] = true;
					 cols[j]=true;
				 }
			 }
		 }
		 
		 //nullify rows
		 for(int row=0;row<rows.length;row++) {
			 if(rows[row]) {
				 for(int j=0;j<cols.length;j++) {
					 arr[row][j]=0;
				 }
			 }
		 }
		 
		 for(int col=0;col<cols.length;col++) {
			 if(cols[col]) {
				 for(int i=0;i<rows.length;i++) {
					 arr[i][col]=0;
				 }
			 }
		 }
		return arr;
		 
		 
	 }
	
	
	public static void main(String[] args) {
		GayleArrays arrays = new GayleArrays();
		LinkedList<Integer> nums = new LinkedList<Integer>(Arrays.asList(1,1,1,3,3,4,5,2,7));
		//System.out.println(result.toString());
	}

}
