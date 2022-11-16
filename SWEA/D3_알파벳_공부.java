
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
        	for (int i = 0; i < str.length(); i++) {
        		if (i == (str.charAt(i) - 'a')) {
        			count++;
        		} else {
        			break;
        		}
        	}
        	System.out.println("#" + num + " " + count);
        }
	}
}
