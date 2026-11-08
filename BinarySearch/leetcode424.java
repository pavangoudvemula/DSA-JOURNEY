// LEETCODE PROBLEM 424 SEARCH IN 2D MATRIX

/*  APPROACH : FIRST WE WILL FIND THE ROW WHERE THE TARGET MAY EXIST SO IF TARGET IS GREATE THAN PARTICULAR ROW ,
THAT MEANS THE TRGET MAY CONTAIN BUT WE NEED TO CHECK THE OTHER ROWS AS WELL WE STORE THE ANSWER AND CHECK FOR ANY OTHER ROWS IN WHICH  TARGET > ROW
 SO WE WILL TAKE THE LAST ROW WHICH SATISFY THAT CONDITION  IF ROW NO PRESENT WE RETURN FALSE  
ELSE THEN WE CHECK WHETEHR ELEMENT PRESENT IN THAT ROW USING BINARY SEARCH 
*/

// TIME COMPLEXITY: O(log(m*n))
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left=0;
        int right=matrix.length-1;
        int row=-1;
        while(right>=left){
            int mid=left+(right-left)/2;
            if( target> matrix[mid][0] ){
                row=mid;
                left=mid+1;
            }
            else if(target<matrix[mid][0]){
                right=mid-1;
            }
            else{
                return true;
            }
        }
        if(row==-1){
            return false;
        }
        left=0;
        right=matrix[0].length-1;
        while(right>=left){
            int mid=left+(right-left)/2;
            if(matrix[row][mid] >target){
                right=mid-1;
            }
            else if(matrix[row][mid]<target){
                left=mid+1;

            }
            else{
                return true;
            }
        }
        return false;


        
    }
}