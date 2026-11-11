
/*  
# Problem 904: Fruit Into Baskets

**Approach: Variable Size Sliding Window + HashMap**

1. Use two pointers, `left` and `right`, to maintain a sliding window.
2. Use a HashMap to store each fruit type and its frequency in the current window.
3. Expand the window by moving `right` forward and update the frequency of the current fruit in the HashMap.
4. The window can contain at most **two distinct fruit types**.
5. If the HashMap contains more than two distinct fruit types:
   - Shrink the window from the left using `left++`.
   - Decrease the frequency of the fruit being removed.
   - If its frequency becomes zero, remove that fruit from the HashMap.
   - Continue shrinking until the window contains at most two distinct fruit types.
6. After maintaining a valid window, calculate its length using `right - left + 1`.
7. Update the maximum window length.
8. Return the maximum length.

**Time Complexity:** O(n) – Each element is visited at most twice.

**Space Complexity:** O(1) – The HashMap stores at most three distinct fruit types temporarily.

**Key Observation:** The problem asks for the longest contiguous subarray containing at most two distinct elements. Instead of checking every subarray, maintain a valid window using Sliding Window and HashMap.
*/
class Solution {
    public int totalFruit(int[] fruits) {
        int left=0;
        int right=0;
        int occured=0;
        int maxi=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        while(right<fruits.length){
            
           
            if(map.containsKey(fruits[right])){

                 maxi=Math.max(maxi,right-left+1);
                 map.put(fruits[right],map.get(fruits[right])+1);
                
                right++;

            }
            else{
                  
                
                if(occured<2){
                    occured++;
                    map.put(fruits[right],1);
                     maxi=Math.max(maxi,right-left+1);
                    right++;

                   

                }
                else{
                    
                    while(occured>=2){
                        int val=map.get(fruits[left]);
                        val--;
                    if(val==0){
                        map.remove(fruits[left]);
                        occured--;
                    }
                    else{
                        map.put(fruits[left],val);
                    }
                   

                    left++;
                    }
                    occured++;

                    map.put(fruits[right],1);
                    right++;
                    
                   
                }
               
            }
           
            

        }
        return maxi;
        
    }
}