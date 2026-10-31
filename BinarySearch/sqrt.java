// LEETCODE PROBLEM 69. Sqrt(x)
// APPROACH : SINCE WE PROBLEM ASKS NOT TO  USE ANY EXPONENTIAL OPERATOR OR BUILT IN FUNCTION 
// WE CAN USE BINARY SEACH ON ANSWER LOWEST POSSIBLE ANSER WILL BE 0, 
// MAX POSSIBLE ANSWER WILL BE N WE CHECK CANDIDATE IF CANDIDATE SQUARE <= X IT MAY BE THE ANSWER BUT WE NEED NEAREST INTEGER WHICH CAN BE THE ANSWER SO MOVE TO RIGHT HALF ,
//  IF SQUARE OF MID> X THAT MEANS IT CANT BE THE SQRT OF X SO WE NEED CHECK IN LEFT HALF
// TIME COMPLEXITY: O(logN)
class Solution {
    public int mySqrt(int x) {
        
       int left=0;
       int right=x;
       int ans=0;
       while(right>=left){
        int mid=left+(right-left)/2;
        if((long)mid*mid<=x){
            ans=mid;
            left=mid+1;
        }
        else{
            right=mid-1;
        }
       }
       return ans;
        
    }
}

