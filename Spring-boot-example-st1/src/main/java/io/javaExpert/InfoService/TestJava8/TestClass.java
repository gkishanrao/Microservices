package io.javaExpert.InfoService.TestJava8;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import net.bytebuddy.asm.Advice.Return;

public class TestClass {
	/* Returns length of LCS for X[0..m-1], Y[0..n-1] */
    int lcs(char[] X, char[] Y, int n, int m)
    {
        if (m == 0 || n == 0)
            return 0;
        if (X[n - 1] == Y[m - 1])
            return  lcs(X, Y, m - 1, n - 1)+1;
        else
            return max(lcs(X, Y, m, n - 1), lcs(X, Y, m - 1, n));
    }
  
    private int max(int lcs, int lcs2) {
		// TODO Auto-generated method stub
		return (lcs >lcs2) ? lcs:lcs2;
	}

	/* Utility function to get max of 2 integers */
   
  
    public static void main(String[] args)
    {
        TestClass lcs = new TestClass();
        String s1 = "ABC";
        String s2 = "ABC";
  
        char[] X = s1.toCharArray();
        char[] Y = s2.toCharArray();
        int m = X.length;
        int n = Y.length;
  
        System.out.println("Length of LCS is"
                + " " + lcs.lcs(X, Y, m, n));  	 

		//Example 1:
/*
		Input: text1 = "abcde", text2 = "ace" 
		Output: 3  
		Explanation: The longest common subsequence is "ace" and its length is 3.
		Example 2:

		Input: text1 = "abc", text2 = "abc"
		Output: 3
		Explanation: The longest common subsequence is "abc" and its length is 3.
		Example 3:

		Input: text1 = "abc", text2 = "def"
		Output: 0
		Explanation: There is no such common subsequence, so the result is 0.
		public int longestCommonSubsequence(String text1, String text2) {*/
		
		
		
		
		        
		    }

		
		
		
	
}
