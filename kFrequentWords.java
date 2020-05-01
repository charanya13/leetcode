/* 
Given a list of reviews, a list of keywords and an integer k. Find the most popular k keywords in order of most to least frequently mentioned.

The comparison of strings is case-insensitive.
Multiple occurances of a keyword in a review should be considred as a single mention.
If keywords are mentioned an equal number of times in reviews, sort alphabetically.

Example 1:

Input:
k = 2
keywords = ["anacell", "cetracular", "betacellular"]
reviews = [
  "Anacell provides the best services in the city",
  "betacellular has awesome services",
  "Best services provided by anacell, everyone should use anacell",
]

Output:
["anacell", "betacellular"]

Explanation:
"anacell" is occuring in 2 different reviews and "betacellular" is only occuring in 1 review.
Example 2:

Input:
k = 2
keywords = ["anacell", "betacellular", "cetracular", "deltacellular", "eurocell"]
reviews = [
  "I love anacell Best services; Best services provided by anacell",
  "betacellular has great services",
  "deltacellular provides much better services than betacellular",
  "cetracular is worse than anacell",
  "Betacellular is better than deltacellular.",
]

Output:
["betacellular", "anacell"]

Explanation:
"betacellular" is occuring in 3 different reviews. "anacell" and "deltacellular" are occuring in 2 reviews, but "anacell" is lexicographically smaller.

Time complexty = Insertion into the heap takes O(log n) time. If we have "n" words in the keywords array, the time is O(n logn) 
Say we have "m" reviews in total, we would need O(m) time to iterate over all the reviews, assume each review has 
=> O(m + nlogn) 
*/ 

class Solution 
{
  private List<String> topKFrequentWords(int k, String[] keywords, String[] reviews)
  {
     List<String> result = new ArrayList<>(); 
     // add keywords to a set 
     Set<String> keySet = new HashSet<>(); 
     for(String keyword: keywords)
     {
        keySet.add(keyword); 
     }
     
     
     // For each review 
     HashMap<String, Integer> wordToCount = new HashMap<>(); 
     for(String reviewStr: reviews)
     {
        String[] reviewArr = reviewStr.split("\\W"); // splits each word in the string 
        for(String review: reviewArr) 
        {
          String reviewLower = review.toLowerCase(); 
          if(keySet.contains(reviewLower))
          {
            // keyword needs to be logged 
            wordToCount.put(reviewLower, wordToCount.getOrDefault(reviewLower, 0)+1);
          }
        }
     }
     
     PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>((a,b) -> a.getValue() == b.getValue() ? 
     a.getKey.compareTo(b.getKey()) : b.getValue() - a.getValue()); 
     
     // add all entrySet of hashmap to the queue 
     maxHeap.addAll(wordToCount.entrySet()); 
     while(!maxHeap.isEmpty() && k-- > 0) 
     {
        String key = maxHeap.poll().getKey(); 
        result.add(key); 
     }
     return result; 
  } 
} 
     
                
          
        
        







