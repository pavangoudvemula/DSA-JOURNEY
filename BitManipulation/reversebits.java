// LEETCODE PROBLEM  190. Reverse Bits
// APPROACH :  INITALLY I KEEP A ANSWER VARIABLE INITALISED WITH ZERO THAT MEANS ALL IT 32 BIT ARE ZEROS 
// NOW FOR THE GIVEN N I WILL ITERATE  THROUGH ALL ITS BITS AND CHECK WHETEHER THE POSITION AT THAT BIT IS  SET OR NOT 
// IF IT IS SET THAT MEANS  I WILL MAKE  ITS CORRESPONDING POSTION FORM LEFT TO BIT 1 BY (31-BIT) 
// LIKE THAT WE WILL DO FOR ALL BITS  EVENTUALLY WE WILL GET THE ANSWER WHICH IS OBTAINED BY REVERSING THE BIT OF N

class Solution {
    public int reverseBits(int n) {
        int ans=0;
        for(int bit=0;bit<32;bit++){
            int mask=(1<<bit);
            if((n&mask) !=0){
                int mask2=(1<<(31-bit));
                ans= ans| mask2;
            }

        }
        return ans;
        
    }
}