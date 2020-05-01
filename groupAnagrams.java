/* Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.
*/ 

// Time complexity - We iterate over each word in the list in O(n) operation, sort each word in O(mlogm). 
// O(mlogm * n), 
// m = average length of each word in the list, n = number of words in the list 
// Space Complexity - O(n) for the hashMap 

// Idea is to iterate over each word in the input, sort the word and store it in a hashMap. The sorted word is the key while the original 
// word is the value. At the end, the list of all values in the hashMap would be our expected result. 

class Solution 
{
  private List<String> groupAnagrams(List<String> wordList) 
  {
      List<List<String>> result = new ArrayList<>();
      
      // edge case 
      if(wordList == null || wordList.length == 0) {
          return result; 
      }
      
      HashMap<String, List<String>> wordMap = new HashMap<>(); 
      // iterate over each word in the wordList 
      for(String word: wordList)
      {
        char[] charArr = word.toCharArray(); 
        Arrays.sort(charArr); 
        String sortedStr = new String(charArr); 
        if(wordMap.containsKey(sortedStr)) {
           List<String> list = wordMap.get(sortedStr); 
           list.add(word); 
           wordMap.put(sortedStr, list);
        } else {
          List<String> list = new ArrayList<>(); 
          list.add(word); 
          wordMap.put(sortedStr, list); 
        }
      }
      
      // get the values of map, add it to the list 
      for(Map.Entry entry: wordMap.entrySet())
      {
            List<String> value = (List<String>) entry.getValue(); 
            result.add(value); 
      }
      return result;  
  }
}
