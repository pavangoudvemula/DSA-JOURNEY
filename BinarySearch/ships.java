// Leetcode: PROBLEM  1011 Capacity To Ship Packages Within D Days
/* THINKING : 

The problem asks us to minimize the ship's capacity.

We can use a feasibility function, can(w), to check whether
a given capacity can ship all packages within the specified
number of days.

The feasibility condition is monotonic:

* If a capacity is insufficient, smaller capacities are also insufficient.
* If a capacity works, larger capacities will also work.

Therefore, we can use Binary Search on Answer to find the
minimum feasible capacity.

SEARCH SPACE:
left  = maximum package weight
right = sum of all package weights
*/

// TIME COMPLEXITY: O(n * log S) 
// n = number of packages 
//  S = sum of all package weights 
//  AUXILIARY SPACE: O(1)


class Solution {
    static boolean can(int w,int []arr,int d){
        int sum=0;
         int calc_days=1;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            
           if(sum>w){
            
            calc_days++;
            sum=arr[i];
           }

           
        }
       
        return calc_days<=d;


    }
    public int shipWithinDays(int[] weights, int days) {
      int maxi=Integer.MIN_VALUE;
      int sum=0;
      for(int i=0;i<weights.length;i++){
       
        maxi=Math.max(maxi,weights[i]);
        sum+=weights[i];
      }
      int left=maxi;
      int right=sum;
      int capacity=0;
      
      while(right>=left){
        int mid=left+(right-left)/2;
        
        if(can(mid,weights,days)){
            capacity=mid;
            right=mid-1;
            
        }
        else{
            left=mid+1;
        }
      }

        return capacity;
    }
}