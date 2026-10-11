// Leetcode 153 Problem   Find Minimum in Rotated Sorted Array
// Thinking: first we need to find which side is sorted (which side  rotation is occured) then we need to move on to that roation side because we are finding smaller element that is present in the rotaion side(because at rotation side smaller elements and larget element will be there) 
/*
if nums[mid]<=nums[right] then rotaion is ocuured on left side so min can mid or smaller elemt han mid so we store that value and searcher for smaller element than mid
 
else then  rotation is occured on right side , here mid cant be the smallest because form left part upto mid which is sorted so mid is not the answer , we will move towards right 
 
like that we continue this procees till loop condition satisfied eventually we find min element

 */

class Solution {
    public int findMin(int[] nums) {
        int left=0;
        int right=nums.length-1;
        int mini=Integer.MAX_VALUE;
        while(right>=left){
            int mid=left+(right-left)/2;
            if(nums[mid]>nums[right]){
                left=mid+1;

            }
            else{
               mini=Math.min(mini,nums[mid]);
               right=mid-1;
            }
        
        }
        return mini;

        
    }
}