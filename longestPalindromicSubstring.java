/* 
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"

Idea: Iterate over the string, with each index i as the centre try to expand around the centre
Time Complexity = o(n2) 
Space Complexity = O(n) for the result 
*/ 

class Solution 
{
  String longestStr = ""; 
  int maxLen = Integer.MIN_VALUE; 
  
  private String longestPalindromicSubStr(String str)
  {
       // edge case
       if(str == null || str.length() == 0) {
          return longestStr; 
       }
       for(int i =0; i< str.length(); i++) 
       {
          // Expand around the centre at i for odd length palindromes 
          expand(i, i, str); 
          
          // Expand around centre at i, i+1 for even length palindromes 
          expand(i,i+1, str); 
       }
       return longestStr; 
   }
   
   private void expand(int start, int end, String str, String longestStr)
   {
      while(start >= 0 && end <str.length() && str.charAt(start) == str.charAt(end))
      {
          String palindrome = str.substring(start, end+1); 
          if(palindrome.length() > maxLen) 
          {
            maxLen = palindrome.length(); 
            longestStr = palindrome; 
          }
          start--; 
          end++; 
      }
   }
}     
       
       
        
