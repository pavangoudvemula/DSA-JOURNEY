/*  Approach: HashMap (Value  Most Recent Index)

1. Create a HashMap to store each element and its most recent index.
2. Traverse the array from left to right.
3. If the current element already exists in the HashMap, retrieve its previous index.
4. Calculate the index difference. If i - prev <= k, a duplicate exists within the allowed distance, so return true.
5. Otherwise, update the element's index to the current index.
6. If the element is not present, insert it into the HashMap.
7. If the traversal finishes without finding a valid pair, return false.

Key Observation:
Maintaining the most recent index of each element is sufficient because it gives the smallest distance between the current occurrence and any previous occurrence of that element.

Complexity Analysis:
- Time Complexity: O(N) average.
- Space Complexity: O(N).
*/
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int prev=map.get(nums[i]);
                if(i-prev<=k){
                    return true;
                }
                map.put(nums[i],i);
            }
            else{
                map.put(nums[i],i);
            }
            
        }
        return false;

        
    }
}