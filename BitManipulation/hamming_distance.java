// leetcode problem 461 Hamming Distance
// appraoch : hamming distance is the no of bits at which both bit positions are diiferent to calclate first we do xor , 
// then the bits at which are both bits at that position is differnt will result 1 
// so after doing xor we count no of set bits after doing xor


class Solution {
    public int hammingDistance(int x, int y) {
        int mask= x^y;
        return Integer.bitCount(mask);
        
    }
}