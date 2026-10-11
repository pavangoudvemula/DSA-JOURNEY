// Leetcode 33 Problem  Search in Rotated Sorted Array
// Thinking: First we need to find which side is sorted i.e(rotaion occured in which side) then we check whther the target contins in that sorted range if yes we move to to sortde part elsewe move to other
// Time Complexity: O(logn)
//Space Complexity: O(1)

class Solution {
    public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(right>=left){
            int mid=left+(right-left)/2;
            if(nums[mid]<nums[right]){
                if(nums[mid]<target){
                    if(nums[right] >=target){
                        left=mid+1;
                    }
                    else{
                        right=mid-1;
                    }
                }
                else if(nums[mid]>target){
                    right=mid-1;
                }
                else{
                    return mid;
                }
            }
            else{
                if(nums[mid]<target){
                    left=mid+1;
                }
                else if(nums[mid]>target){
                    if(target>=nums[left]){
                        right=mid-1;
                    }
                    else{
                        left=mid+1;
                    }
                }
                else{
                    return mid;
                }
            }
        }
        return -1;
        
    }
}