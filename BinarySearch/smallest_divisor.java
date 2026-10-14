//Leetcode: PROBLEM 1283: Find the Smallest Divisor Given a Threshold


//Find the smallest positive divisor such that the sum of the ceiling of each array element divided by that divisor is less than or equal to the given threshold.

// Approach: Binary Search on the Answer

// Search space: [1, max(nums)].
// Monotonicity: As the divisor increases, the sum of the rounded-up quotients never increases.
// Feasibility function: can(nums, mid, threshold) checks whether the sum for a candidate divisor is within the threshold.
// Binary search: If the candidate divisor is valid, save it and search the left half for a smaller valid answer. Otherwise, search the right half.

// Complexity

// Time: O(n log M), where M is the maximum array element.
// Auxiliary space: O(1).



class Solution {
    static boolean can(int [] nums,int ele,int thre){
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=(nums[i]+ele-1)/ele;

        }
        return sum<=thre;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int left=1;
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            maxi=Math.max(maxi,nums[i]);
        }
        int right=maxi;
        int ans=1;
        while(right>=left){
            int mid=left+(right-left)/2;

            if(can(nums,mid,threshold) ){
                ans=mid;

                right=mid-1;
            }
            else{
            left=mid+1;
            }
           
        }
        return ans;
        
    }
}