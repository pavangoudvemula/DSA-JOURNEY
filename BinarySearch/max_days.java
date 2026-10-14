


// LeetCode Problem 1482: Minimum Number of Days to Make m Bouquets

/*
PROBLEM UNDERSTANDING:
We are given an array bloomDay, where bloomDay[i] represents the day
on which the ith flower blooms.

We need to find the minimum number of days required to make m bouquets,
where each bouquet requires k adjacent flowers.

Each flower can be used in at most one bouquet.

If it is impossible to make the required bouquets, return -1.


THINKING:
First, check whether the number of available flowers is sufficient.

We need m * k flowers to make m bouquets, with k flowers per bouquet.
If bloomDay.length < m * k, making the required bouquets is impossible,
so return -1.

SEARCH SPACE:
The minimum possible answer is min(bloomDay), because no flower blooms
before its bloomDay.

The maximum possible answer is max(bloomDay), because by that day all
flowers have bloomed.

Therefore, the answer lies in the range:
[min(bloomDay), max(bloomDay)].


MONOTONICITY:
As the number of days increases, more flowers bloom.

If we can make m bouquets on a particular day, we can also make
m bouquets on any later day.

Therefore, the feasibility pattern is:

INVALID INVALID INVALID VALID VALID VALID

This monotonicity allows us to use binary search on the answer.


FEASIBILITY FUNCTION:
The can() function checks whether we can make at least m bouquets
by the candidate day.

We traverse the array and count consecutive flowers that have bloomed.

If bloomDay[i] <= candidate day, the flower has bloomed, so we
increment the consecutive-flower count.

Whenever the consecutive-flower count reaches k, we form one bouquet
and reset the count to zero because each flower can be used only once.

If a flower has not bloomed, we reset the consecutive-flower count
because the sequence of adjacent bloomed flowers is broken.

After traversing the array, if the number of bouquets formed is at
least m, the candidate day is feasible.


BINARY SEARCH:
If the candidate day is feasible, store it as the current answer
and search the left half for a smaller valid day.

Otherwise, search the right half because we need more days for
additional flowers to bloom.

The final answer is the minimum feasible day.


TIME COMPLEXITY:
Let n be the number of flowers and D be the difference between
the maximum and minimum bloom days.

Each feasibility check takes O(n) time.

Binary search takes O(log D) iterations.

Overall time complexity: O(n log D).


AUXILIARY SPACE COMPLEXITY:
O(1), because we use only a constant number of extra variables.
*/


class Solution {
    static boolean can(int [] arr,long d,long m,long k){
        int count=0;
        int flowers=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=d){
                flowers++;
                if(flowers==k){
                    count++;
                    flowers=0;
                }
                
            }
            else{
                flowers=0;

            }
        }
        return (count)>=(m);
    }
    public int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length<(long)m*k){
            return -1;
        }
       
       int mini=Integer.MAX_VALUE;
       int maxi=Integer.MIN_VALUE;
        long sum=0;
        for(int i=0;i<bloomDay.length;i++){
            sum+=bloomDay[i];
            mini=Math.min(mini,bloomDay[i]);
            maxi=Math.max(maxi,bloomDay[i]);
        }
         long left=mini;
        long right=maxi;
        int ans=-1;
        while(right>=left){
            long mid=left+(right-left)/2;
            if(can(bloomDay,mid,m,k)){
                ans=(int)mid;
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return ans;

        
    }
}