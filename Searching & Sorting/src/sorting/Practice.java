package sorting;

import java.util.*;

public class Practice {

	static int[][] memo = new int[100][100];
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter First String : ");
		String str1 = sc.next();
		System.out.print("Enter Second String : ");
		String str2 = sc.next();
		int m = str1.length();
		int n = str2.length();
		Practice p = new Practice();
		
		for(int i = 0; i <= m; i++)
		  {
		    for(int j = 0; j <= n; j++)
		      memo[i][j] = -1;
		  }
		
		int res1 = p.lcs(str1, str2, m, n);
		
	    System.out.println("\nLength of longest subsequence using Memoization is " + res1 + "\n");
	    
	    int res2 = p.lcstring(str1, str2);
	    System.out.println("Length of longest subsequence using tabulation is " + res2 + "\n");
	    
	}
	
	int lcs(String str1, String str2, int m, int n)
	{
		if(memo[m][n] != -1)
		  return memo[m][n];
		if(m == 0 || n == 0)
			memo[m][n] = 0;
		else
		{
			if(compare((str1.charAt(m - 1)), str2.charAt(n - 1)))
			    memo[m][n] = 1 + lcs(str1, str2, m - 1, n - 1);
			else
				memo[m][n] = max((lcs(str1, str2, m - 1, n)), (lcs(str1, str2, m , n - 1)));
		}
		return memo[m][n];
		
	}
	
	int max(int a, int b)
	{
		if(a > b)
			return a;
		else
			return b;
	}
	
	boolean compare(char ch1, char ch2)
	{
		Character c1 = new Character(ch1); 
        Character c2 = new Character(ch2); 
        if(c1.equals(c2))
        	return true;
        else
        	return false;
	}
	
	int lcstring(String str1, String str2)
	{
		int m = str1.length();
		int n = str2.length();
		
		int[][] array = new int[m + 1][n + 1];
		
		for(int i = 0; i <= m; i++)
			array[i][0] = 0;
		for(int i = 0; i <= n; i++)
			array[0][i] = 0;
		
		for(int i = 1; i <= m; i++)
		{
			for(int j = 1; j <= n; j++)
			{
				if(compare((str1.charAt(i - 1)), str2.charAt(j - 1)))
					array[i][j] = 1 + array[i - 1][j - 1];
				else
				{
					array[i][j] = max(array[i- 1][j], array[i][j - 1]);
				}
			}
		}
		return array[m][n];
	}

}
