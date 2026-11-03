// LEETCODE 268 PROBLEM MISSING NUMBER
// APPRAOCH : SINCE XOR OF TWO SAME ELEMENTS IS ZERO  SINCE THE ARRAY CONTAINS 0 TO N NUMBERS ONLY ONE NUMBER IS MISSING 
// FIRST WE WILL DO XOR OF 0 TO N THEN WE DO XOR OF GIVEN ARRAY WE AUTOMATICALLY GET THE NUMBER WHICH IS MISSING
// TIME COMPLEXITY: O(N)

class Solution {
    public int missingNumber(int[] nums) {
        int ans=0;
        for(int i=0;i<=nums.length;i++){
            ans^=i;
        }
        for(int x: nums){
            ans ^=x;
        }
        return ans;
        
    }
}