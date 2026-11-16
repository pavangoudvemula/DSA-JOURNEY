// LEETCODE PROBLEM 169 Majority Element

// Approach: USING BOYER-MOORE VOTING ALGORITHM 
// APPRAOCH 2: SORT THE ARRAY THEN ANSWER  WILL BE THE ELEMENT AT MID INDEX SINCE PROBLEM EXPLICITLY SAY THAT MAJORITY ELEMENT FREQUENCY >N/2 


class Solution {
    public int majorityElement(int[] nums) {
     int curr=nums[0];
     int count=1;
     for(int i=1;i<nums.length;i++){
        if(curr==nums[i]){
            count++;
        }
        else{
            count--;
            if(count==0){
                curr=nums[i];
                count=1;
            }
        }
     }
     return curr;

    }
}