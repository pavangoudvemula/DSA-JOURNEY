// LEETCODE PROBLEM 191. Number of 1 Bits
// APPROACH : AT EACH ITERATION WE REMOVE RIGHT MOST SET BIT AND INCREMENT COUNT TILL N BECOMES ZERO AS N BECOMES ZERO MEANS THERE IS NO SET BITS
// TIME COMPLEXITY: O(N);
// SPACE COMPLEXITY: O(1)
class Solution {
    public int hammingWeight(int n) {
        int count=0;
        while(n!=0){
            n=n&(n-1);
            count++;

        }
        return count;

        
    }
}