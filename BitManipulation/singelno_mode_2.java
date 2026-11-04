// LEETCODE PROBLEM Single Number II 137 
// APPRAOCH : AT EACH POSITION WE WILL COUNT OF NO OF SET BITS 
// THEN WE DO MODULO 3 SO THAT NUMBERS WHICH ARE REPEATED IF THEY HAVE BIT AS SET AT THAT POSITION
//  THEN ITS OTHER 2 NUMBERS WILL ALSO INVOLVE COUNT , SO WE REMOVE THE REPEATING NUMBER COMBINATION FROM COUNT 
// THEN WE CHECK WHETEHER STILL COUNT IS 1 IF IT IS ONE THE THE NUMBER WHICH IS UNIQUE WILL HAVE BIT AS SET AT THAT POSITION  LIKE THAT WE WILL BUILD THE BINARY  
// THEN AFTER THE LOOP THE BINARY REPRESNTAION IS THE REPRESNTAION OF UNIQUE NUMBER
class Solution {
    public int singleNumber(int[] nums) {
        int ans=0;
        for(int bit=0;bit<32;bit++){
            int count=0;
            for(int i=0;i<nums.length;i++){
                if((nums[i] & (1<<bit)) !=0){
                    count++;
                }

            }
            if(count%3 ==1){
                ans = ans| (1<<bit);            }
        }
        return ans;
        
    }
}