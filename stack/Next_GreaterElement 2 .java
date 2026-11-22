//Problem: LeetCode 503 - Next Greater Element II

//Pattern:Monotonic Stack + Circular Array

//Approach:
// - Traverse the array twice using a loop from `2*n-1` to `0`.
// - Use `i % n` to simulate circular indexing.
// - Maintain a stack of potential next greater elements.
// - Pop elements smaller than or equal to the current element.
// - Calculate answers only during the second traversal.
// - Push the current element.

// **Key Observation:
// Circular arrays can be handled by simulating two traversals using modulo indexing.

// Time Complexity: O(N)

// Space Complexity: O(N)

// Learning: A monotonic stack can efficiently solve Next Greater Element problems, including circular arrays.

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int []ans=new int[nums.length];
        Deque<Integer> stack=new ArrayDeque<>();
        for(int i=2*nums.length-1;i>=0;i--){
            int index=i%nums.length;
            while(!stack.isEmpty() && stack.peek() <=nums[index]){
                stack.pop();
            }
            if(i<nums.length){
                if(stack.isEmpty()){
                    ans[index]=-1;
                }
                else{
                    ans[index]=stack.peek();
                }
            }
            stack.push(nums[index]);
            


        }
        return ans;
        
    }
}