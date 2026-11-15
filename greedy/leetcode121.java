/*   Approach: Single Traversal (Greedy)

1. Traverse the array from left to right, considering each day as a possible selling day.
2. Maintain a variable `minPrice` to store the minimum stock price encountered so far.
3. For each day, calculate the potential profit by subtracting `minPrice` from the current price.
4. Update `maxProfit` whenever a higher profit is found.
5. Update minPrice whenever a lower stock price is encountered.
6. Return maxProfit.

Key Observation:
Instead of checking every possible buying and selling pair, maintain the minimum buying price seen so far. This avoids repeatedly searching previous days.

Complexity Analysis:
- Time Complexity: O(N)  Only one traversal of the array.
- Space Complexity: O(1)  Only two variables are used.

Learning:
Optimizing brute force by maintaining useful information during traversal instead of recalculating it repeatedly.
 
*/
class Solution {
    public int maxProfit(int[] prices) {
        int mini=prices[0];
        int profit=0;
        for(int i=1;i<prices.length;i++){
            profit=Math.max(profit,prices[i]-mini);
            mini=Math.min(mini,prices[i]);
            
        }
        return profit;




        
    }
}