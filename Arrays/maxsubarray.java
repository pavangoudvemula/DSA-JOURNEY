//LEETCODE PROBLEM : 53 MAXIMUM SUBARRAY SUM
// APPROACH : KDANE'S ALGORITHM
//TIME COMPLEXITY: O(n)
class Solution {
    public int maxSubArray(int[] nums) {
        int sum=nums[0];
        int maxi=sum;
        for(int i=1;i<nums.length;i++){
           
            if(sum>maxi){
                maxi=sum;
            }



        }
        return maxi;

        
    }
}
