// Leetcode Problem  852  Peak Index in a Mountain Array

/* Thinking: For this Problem the values in the array are in like same moontain behaviour(i.e intially the values in increaing order then after that it is decreasing)
 now we need to calculate the mid value and check the it adjacent elements like mid-1,mid+1 , 
 since we finding max element and ther array is like mountain behaviour so one part is increasing and 
 other part is decreasing  we check the mid with adjacent 
 if any adjacent is greater than  mid  then max element is can found in that part 
 if no adjacent is grater than the mid element the max element is mid
 */

 //Time Complexity: O(logn)
 // Space Complexity: O(1)

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left=0;
        int right=arr.length-1;
        while(right>=left){
            int mid=left+(right-left)/2;
            if(mid>0 &&  arr[mid-1] >arr[mid]){
                right=mid-1;

            }
            else if(mid<arr.length-1 && arr[mid+1] >arr[mid]){
                left=mid+1;
            }
            else{
                return mid;
            }


        }
        return -1;
        
    }
}