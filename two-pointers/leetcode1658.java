/* Problem 1658: Minimum Operations to Reduce X to Zero

 Approach 1: Prefix Sum + Suffix Sum + HashMap

1. Construct two arrays:
   - `prefix[]`: Stores cumulative sums from the beginning of the array.
   - `suffix[]`: Stores cumulative sums from the end of the array.

2. First, check whether removing elements only from the left or only from the right produces the required sum `x`.

3. Use a HashMap to store prefix sums as keys and the number of elements required to obtain those sums as values.

4. Iterate through the suffix array and calculate the remaining sum required from the prefix:
   
   `remaining = x - suffix[i]`

5. Check whether this remaining sum exists in the HashMap.

6. If it exists, combine the number of prefix and suffix elements, ensuring that the two selected portions do not overlap.

7. Maintain the minimum number of operations throughout the process.

8. If no valid combination exists, return `-1`.

**Time Complexity:** O(n)

**Space Complexity:** O(n)

---

Approach 2: Sliding Window (Optimal Space)

**Key Observation:**

Instead of removing elements from both ends, think about the elements that remain in the middle.

Let:

`totalSum = sum of all elements`

We need to remove elements whose sum is `x`.

Therefore, the sum of the remaining subarray must be:

`target = totalSum - x`

Now the problem becomes:

**Find the longest contiguous subarray whose sum equals `target`.**

Since all array elements are positive, we can use the Sliding Window technique.

### Steps

1. Calculate the total sum of the array.
2. Calculate `target = totalSum - x`.
3. Initialize two pointers `left = 0`, `right = 0`, and a variable `sum = 0`.
4. Expand the window by adding `nums[right]` to the current sum.
5. If the current sum exceeds the target, shrink the window by moving `left` forward and subtracting the removed elements.
6. Whenever the current sum equals the target, update the maximum window length.
7. The minimum operations required are:

   `Answer = n - maximumLength`

8. If no valid subarray exists, return `-1`.

**Time Complexity:** O(n)

**Space Complexity:** O(1)

---

## Comparison

| Feature | Prefix + Suffix + HashMap | Sliding Window |
|---|---|---|
| Technique | Prefix/Suffix Sum | Two Pointers |
| HashMap | Required | Not required |
| Time Complexity | O(n) | O(n) |
| Space Complexity | O(n) | O(1) |
| Main Idea | Combine prefix and suffix sums | Find the longest middle subarray |

**Key Learning:**

Sometimes, instead of directly solving a problem, try reversing the perspective.

Here, removing elements from both ends becomes finding the longest subarray that remains in the middle.
*/
class Solution {
    public int minOperations(int[] nums, int x) {
        int [] prefix=new int[nums.length];
        int [] sufix=new int[nums.length];
        prefix[0]=nums[0];
        sufix[nums.length-1]=nums[nums.length-1];
        for(int i=1;i<nums.length;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }
        for(int i=nums.length-2;i>=0;i--){
            sufix[i]=sufix[i+1]+nums[i];
        }
        int ans1=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(x==prefix[i]){
              ans1=Math.min(ans1,i+1);
            }
        }
       
        for(int i=0;i<nums.length;i++){
            if(x==sufix[i]){
               ans1=Math.min(ans1,nums.length-i);
            }
        }
        HashMap<Integer,Integer> map1=new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            map1.put(prefix[i],i+1);
        }
        for(int i=0;i<nums.length;i++){
        if(map1.containsKey(x-sufix[i])){
            
            if(map1.get(x-sufix[i])+nums.length-i<=nums.length){
                ans1=Math.min(ans1,((nums.length-i)+map1.get(x-sufix[i])));
            }
            
            }
        }
        if(ans1==Integer.MAX_VALUE){
            return -1;
        }
        return ans1;
       
        
        



        
    }
}