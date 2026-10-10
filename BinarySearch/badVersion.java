//  Leetcode 278 First Bad Version
//  Thinking: first find a bad version if it is not found means that means all left versions are ggod versions only so we nned to check right part, when you got a bad version , it may be the answer so  store it in a variable  and check left part to find first bad version 
/*  since a bad version occured that means all other versions after that are bad versions , 
    since we need first bad version we need to check in only the left part continue till loop condition staisify */
// Time Complexity: O(log(n))
// space complexity: O(1)

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int index=n;
        int left=1;
        int right=n;
        while(right>=left){
            int mid=left+(right-left)/2;
            if(isBadVersion(mid)){
                index=mid;
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return index;
        
    }
}