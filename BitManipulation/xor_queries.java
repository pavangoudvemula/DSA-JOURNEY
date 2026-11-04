// LEETCODE PROBLEM  1310  XOR Queries of a Subarray
//APPRAOCH : WE NEED TO FIND XOR OF NUMBERS IN THE GIVEN RANGE 
// FOR THAT WE WILL COMPUTE FIRST XOR  OF NUMBERS UPTO THERE INDEX I LIKE EXAMPLE AT 0 TH INDEX IT CONTAINS XOR OF  ALL ELEMENTS FROM 0 TO THAT INDEX 
// THE QUESTION ASKED TO FIND XOR IN THAT RANGE SO WE WILL REMOVE THE REMAING ELEMNTS FR0M  TO THE GIVEN LOWER LIMIT-1 FROM THE XOR OF ELEMTS FROM 0 THE UPPER RANGE AS WE DO XOR SAME ELEMENTS WILL REMOVED WE EVENTUALLY GET XOR IN THE GIVEN RANGE
// TIME COMPLEXITY: O(N)
class Solution {
    
    public int[] xorQueries(int[] arr, int[][] queries) {
        int [] ans=new int[queries.length];
        int [] prefix=new int[arr.length];
        prefix[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            prefix[i]=prefix[i-1]^arr[i];
        }

        for(int i=0;i<queries.length;i++){
            int left=queries[i][0];
            int right=queries[i][1];
            ans[i]=prefix[right];
            if(left-1>-1){
                ans[i]=ans[i]^prefix[left-1];
            }


            

        
           
        }
        return ans;

        
    }
}