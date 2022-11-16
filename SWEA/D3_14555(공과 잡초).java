
import java.io.*;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
        
        for (int num = 1; num <= n; num++) {
        	String str = br.readLine();
        	
        	int count = 0;
        	boolean[] visited = new boolean[str.length()];
        	for (int i = 0; i < str.length(); i++) {
        		if (i < str.length()-1 && str.charAt(i) == '(' && 
        				(str.charAt(i+1) == '|' || str.charAt(i+1) == ')')
        				&& !visited[i + 1]) {
        			count++;
        			visited[i + 1] = true;
        		} else if (i > 0 && str.charAt(i) == ')' && str.charAt(i-1) == '|'
        				&& !visited[i - 1]) {
        			count++;
        			visited[i - 1] = true;
        		}
        	}
        	System.out.println("#" + num + " " + count);
        }
	}
}
