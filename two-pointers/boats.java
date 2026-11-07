// LEETCODE PROBLEM  881. Boats to Save People

// APPROACH : FIRST WE SORT THE PEOPLES BASE ON THEIR WIEGHTS THEN WE USE OPPPOSITE DIRECTION TWO POINTER
// HERE LEFT POINTER WILL POINT TO SMALLEST WEIGHT AND RIGHT POINTER POINTS TO LARGEST WEIGHT AS THE BOAT CAN HAVE AT MOST TWO PERSONS AND THEIR SUM OF WEIGHTS IS IN THE LIMIT ONLY
// SO WE CHECK WHETEHER CAN THE LEFT CAN BE PAIRED WITH RIGHT IF YES WE INCREMENT BOATS COUNT AND MOVE BOTH POINTERS, IF NOT THAT MEANS THE MAXIMUM WIEGHT PERSON CANNOT BE PAIRED WITH ANY OTHER PERSON BECAUSE WE PAIRED WITH AVAILABLE SAMLLEST WEIGHT AND NOT SATISFIED CONDITION 
// SO THAT PERSON NEED THE ONE BOAT HIMSELF  WE MOVE THE RIGHT POINTER
// THAT MEANS AT EVERY ITERATION WE COUNT BOAT UNTILL NO ONE LEFT

// TIME COMPLEXITY: O(N)

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left=0;
        int right=people.length-1;
        int boat=0;
        while(right>=left){
              boat++;
            if(people[right]+people[left] <=limit){
              
                left++;
                right--;
            }
            else{
                
                right--;
            }
        }
        
        return boat;
        
    }
}