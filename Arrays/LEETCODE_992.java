// Approach: Sliding Window + HashMap


// Exactly K distinct = At Most K distinct - At Most (K-1) distinct

// 1. Count subarrays having at most K distinct elements.
//    - Use a sliding window with left and right pointers.
//    - Maintain element frequencies using a HashMap.
//    - Expand the window by moving right.
//    - If distinct elements exceed K, shrink the window by moving left.
//    - Whenever the window is valid, add (right - left + 1) to the count.
//      This counts all valid subarrays ending at the current right index.

// 2. Count subarrays having at most K-1 distinct elements.
//    - Apply the same sliding window technique.
//    - Maintain at most K-1 distinct elements.

// 3. Calculate the final answer.
//    - Subtract the second count from the first.
//    - Exactly K = At Most K - At Most (K-1)


/* Complexity Analysis
- **Time Complexity:** O(N) – Each element enters and leaves the sliding window at most once.
- **Space Complexity:** O(N) – HashMap can store up to N distinct elements.

### Key Learning
When a problem asks for exactly K, try converting it into:

`Exactly K = At Most K - At Most (K-1)`

This is a useful technique for sliding-window counting problems.
*/
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        
        int count1=0;
       int left=0;
       int right=0;
       HashMap<Integer,Integer> map=new HashMap<>();
       while(right<nums.length){

        map.put(nums[right],map.getOrDefault(nums[right],0)+1);
        if(map.size()<=k){
            count1+=(right-left+1);
            right++;
        }
        else{
            int size=map.size();
            while(size>k){
                int val=map.get(nums[left]);
                if(val==1){
                    map.remove(nums[left]);
                    size--;
                }
                else{
                    map.put(nums[left],val-1);
                }
                left++;



                
            }
            count1+=(right-left+1);
            right++;
        }



       }
       int count2=0;
       left=0;
       right=0;
       map.clear();
       while(right<nums.length){
        map.put(nums[right],map.getOrDefault(nums[right],0)+1);
        if(map.size()<=k-1){
            count2+=(right-left+1);
            right++;
        }
        else{
            int size=map.size();
            while(size>=k){
                int val=map.get(nums[left]);
                if(val==1){
                    map.remove(nums[left]);
                    size--;
                }
                else{
                    map.put(nums[left],val-1);

                }
                left++;
            }
            count2+=(right-left+1);
            right++;
        }
        
       }

        
       
        return count1-count2;
        
    }
}