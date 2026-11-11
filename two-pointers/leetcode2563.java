// Problem 2563: Count the Number of Fair Pairs

/*Approach: Sorting + Two Pointers + Counting

1. Sort the given array in ascending order. This allows us to use the sorted property to count multiple pairs efficiently.

2. Instead of directly counting pairs whose sum lies between `lower` and `upper`, divide the problem into two parts:

   count1: Count pairs whose sum is less than or equal to upper.
   count2: Count pairs whose sum is strictly less than lower.

3. The final answer is:

   Answer = count1 - count2

4. To calculate the number of pairs with sum less than or equal to a target:
   - Initialize left = 0` and right = n - 1.
   - If nums[left] + nums[right] <= target`, all elements between `left + 1` and `right` can form valid pairs with nums[left].
   - Add right - left to the count and increment left.
   - Otherwise, decrement right.

5. Apply the same two-pointer logic for counting pairs with sum strictly less than `lower`.

6. Subtract the second count from the first count to obtain the number of fair pairs.

Time Complexity: O(n log n), where sorting takes O(n log n) and both two-pointer traversals take O(n).

Space Complexity: O(1) auxiliary space for the counting logic, excluding sorting implementation details.

Key Observation:Sorting allows us to count multiple valid pairs in one step instead of checking every pair individually.*/
class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        int left=0,right=nums.length-1;
        long count1=0;
        while(right>left){
            long sum=nums[left]+nums[right];
            if(sum<=upper){
                count1+=(right-left);
                left++;
            }
            else{
                right--;
            }
            


        }
        long count2=0;
        left=0;
        right=nums.length-1;
        while(right>left){
            long sum=nums[left]+nums[right];
            if(sum<lower){
                count2+=(right-left);
                left++;
            }
            else{
                right--;

            }
        }
       long val=(count1-count2 >0)? count1-count2: 0;
        return val;
       
       

        }

        
        
    }
