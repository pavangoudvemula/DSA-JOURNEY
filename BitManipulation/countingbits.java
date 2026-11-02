// LEETCODE PROBLEM 338 COUNTING BITS
// APPRAOCH FOR EACH I WE WILL COUNT NO OF SET BITS BY REMOVING RIGHT MOST SET BIT AT EVERY TIME TILL THAT I BECOMES ZERO 
// AFTER THAT WE WILL KEEP THAT ANSWER FOR THAT I IN ARRAY AND CONTINUE FOR REMAING ELEMENTS
class Solution {
    public int[] countBits(int n) {
        int [] ans=new int[n+1];
        for(int i=0;i<=n;i++){
            int count=0;
            int temp=i;
            while(temp!=0){
                temp=temp&(temp-1);
                count++;
            }
            ans[i]=count;
        }
        return ans;
        
    }
}