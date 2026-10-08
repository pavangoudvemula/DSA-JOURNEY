// LeetCode 704 - Binary Search
// Difficulty: Easy
// Topic: Binary Search
//
// Time Complexity: O(log n)
// Space Complexity: O(1)


class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (right >= left) {
            int mid = (left + right) / 2;

            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}