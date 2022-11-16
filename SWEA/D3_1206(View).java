
import java.io.*;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        
        for (int num = 1; num <= 10; num++) {
        	int n = Integer.parseInt(br.readLine());
        	String[] str = br.readLine().split(" ");
        	int[] buildings = new int[n];
        	int count = 0;
        	
        	for (int i = 0; i < n; i++) {
        		buildings[i] = Integer.parseInt(str[i]);
        	}
        	for (int i = 2; i< buildings.length - 2; i++) {
        		int max = Math.max(Math.max(buildings[i-2], buildings[i-1]), Math.max(buildings[i+2], buildings[i+1]));
        		if (buildings[i] - max > 0) {
        			count += buildings[i] - max;
        		}
        	}
        	System.out.println("#" + num + " " + count);
        }
	}
	public static int getViewCount(int idx, int[] buildings) {
		int size = buildings.length;
		int left = 0;
		int right = 0;
		if (idx > 2 && idx < size - 2) {
			left = Math.max(buildings[idx-1], buildings[idx-2]);
			right = Math.max(buildings[idx+1], buildings[idx+2]);
		}
		else if (idx == 0 && size > idx+2) {
			right = Math.max(buildings[idx+1], buildings[idx+2]);
		}
		else if (idx == 1) {
			left = buildings[0];
			right = Math.max(buildings[idx+1], buildings[idx+2]);
		}
		else if (idx == size -1) {
			left = Math.max(buildings[idx-1], buildings[idx-2]); 
		}
		else if (idx == size - 2) {
			right = buildings[size - 1];
			left = Math.max(buildings[idx-1], buildings[idx-2]); 
		}
		int max = Math.max(left, right);
		
		int answer = buildings[idx] - max; 
		if (answer < 0) return -1;
		return answer;
	}
}
