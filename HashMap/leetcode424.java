/*
 * Problem 424: Longest Repeating Character Replacement
 *
 * Approach: Sliding Window + Frequency Array
 *
 * 1. Use two pointers, left and right, to maintain a sliding window.
 * 2. Maintain a frequency array of size 26 to store the frequency
 *    of each uppercase character.
 * 3. Expand the window by moving right and update the character frequency.
 * 4. Maintain maxFreq, the maximum character frequency encountered so far.
 * 5. Calculate replacements required:
 *       windowLength - maxFreq
 * 6. If replacements required exceed k, shrink the window by moving
 *    left and decrease the frequency of the removed character.
 * 7. Update the maximum window length whenever the window is valid.
 * 8. Return the maximum window length.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1) - Frequency array of fixed size 26.
 */
class Solution {
    public int characterReplacement(String s, int k) {
        int [] freq=new int[26];
        int maxlength=0;
        int left=0;
        int right=0;
        int maxfreq=0;
        while(right<s.length()){
            freq[s.charAt(right)-'A']++;
            maxfreq=Math.max(maxfreq,freq[s.charAt(right)-'A']);
            while((right-left+1)-maxfreq>k){
                freq[s.charAt(left)-'A']--;
                left++;
                for(int i=0;i<26;i++){
                    maxfreq=Math.max(maxfreq,freq[i]);
                }



            }
            maxlength=Math.max(maxlength,(right-left)+1);
            right++;
        }
        return maxlength;

        

        
    }
}