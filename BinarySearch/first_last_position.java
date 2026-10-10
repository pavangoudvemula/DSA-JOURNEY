// Leetcode 34 problem :Find First and Last Position of Element in Sorted Array
/* Thinking: we need to find first and last position of a character which satisfy the condition  greater than the target  
first we will find first  element which statisfy the condition 
so when element is in the left half the cuurent element in mid may be the answer 
so we will store the answer and we check its left part since we are finding the first occurance
like that we will do for last occurance but condition changes
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int indexl=-1;
        int indexr=-1;
        while(right>=left){
            int mid=left+(right-left)/2;
            if(nums[mid]>target){
                right=mid-1;
            }
            else if(nums[mid]<target){
                left=mid+1;
                
            }
            else{
                indexl=mid;
                right=mid-1;

            }
        }
         left=0;
        right=nums.length-1;
        while(right>=left){
            int mid=left+(right-left)/2;
            if(nums[mid]>target){
                right=mid-1;


            }
            else if(nums[mid]<target){
                left=mid+1;
            }
            else{
                indexr=mid;
                left=mid+1;
            }
        }
        int []arr={indexl,indexr};
        return arr;

        
    }
}