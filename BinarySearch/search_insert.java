// LEET CODE PROBLEM 35
// SEARCH INSERT POSITION
 
// APPROACH: USING BINARY SEARCH 
// THINKING : FINDING FIRST INDEX WHICH SATISFY ELEMENT>=TARGET SIMPLY LOWER BOUND
// TIME COMPLEXITY:O(nlog(n))

class Solution {
    public int searchInsert(int[] nums, int target) {

        int index=nums.length;
        int left=0;

        int right=nums.length-1;
        while(right>=left){
            int mid=left+(right-left)/2;
            if(nums[mid]<target){
                left=mid+1;
            }
            else if(nums[mid]>target){
                index=mid;
                right=mid-1;

            }
            else{
                index=mid;
                return index;
            }
        }

        return index;


        
    }
}