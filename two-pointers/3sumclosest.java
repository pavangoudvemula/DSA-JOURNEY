// 16. 3Sum Closest
// approach: FIRST WE WILL SORT THE ARRAY THEN  AT EVERY ITERATION WE KEEP ONE ELEMENT CONSTANT  AND WE FIND OTHER TWO PAIRS  WE CALCULATE CURRSUM THEN WE CHECK WHETHER CUURSUM OR PREV WHICH IS CLOSEST TO THE TARGET 
// BASED ON THAT WE TAKE THE CLOSEST. THEN MOVE  THE POINTERS BASED ON THE THEIR SUM TO GET CLOSER SUM WHICH CAN BE CLOSEST CAN BE GET FOR THAT ELEMENT AT INDEX I
// TIME COMPLEXITY: O(N*N)


class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        long prev=Integer.MAX_VALUE;

        for(int i=0;i<nums.length;i++){
            int left=i+1;
            int right=nums.length-1;
            while(right>left){

               long currsum=nums[left]+nums[right]+nums[i];
                if(Math.abs(currsum-target) < Math.abs(prev-target)){
                    prev=currsum;
                }
             
                if(nums[left]+nums[right]<(target-nums[i])){
                    left++;
                
                  

                }
                else if(nums[left]+nums[right] > target-nums[i]){
                    right--;
                }
                else{
                    return (int)prev;
                }

            }
           
        }
         return (int)prev;

        
    }
}