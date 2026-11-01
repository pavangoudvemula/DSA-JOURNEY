// LEETCODE PROBLEM  645. Set Mismatch
// APPRAOCH: FIRST WE DID THE XOR OF ARR ELEMNTS AND AND 1 TO N  WE WILL GET XOR OF REPATED NUMBER AND MISSING NUMBER 
// THEN WE CREATE A MASK THAT HAVING THE RIGHT MOST SET BIT  ONLY BASED ON THAT WE GROUP ARR ELEMNTS AND 1 TO N BASED ON THAT 
// THEN WE VERIFY WHICH ONE IS REPEATING AND MISSING NUMBER 
// TIME COMPLEXITY : O(N);

class Solution {
    public int[] findErrorNums(int[] nums) {
        int ans=0;
        
        for(int x: nums){
            ans^=x;
        }
        for(int i=0;i<=nums.length;i++){
            ans ^=i;
        }
        
        int mask=ans & -ans;
       
        int a=0,b=0;
        for(int i=1;i<=nums.length;i++){
            if((i&mask) !=0){
                a^=i;
            }
            else{
                b^=i;
            }
        }
        for(int x: nums){
            if((x&mask) !=0){
                a^=x;
            }
            else{
                b^=x;
            }

        }
        boolean exist=false;
        for(int x: nums){
            if(x==a){
               exist=true;
               break;
            }
        }
        int [] temp=new int[2];
        if(exist){
            temp[0]=a;
            temp[1]=b;
        }
        else{
             temp[0]=b;
            temp[1]=a;
            
        }
        return temp;
        
    }
}