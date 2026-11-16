// LEETCODE PROBLEM 448  Find All Numbers Disappeared in an Array
// APPROACH : USING HASHSET TO SEE WHAT ARE THE ELEMENTS WE PROCCESED 
// THEN WE ITERATE FORM 1 TO GIVEN ARRAY SIZE WE CHECK WHETEHR ANY ELEMENT NOT THERE THEN WE ADD INTO OUTPUT LST

// TIME COMPLEXITY: O(n);
// SPACE COMPLEXITY: O(n)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int x: nums){
            set.add(x);
        }
        List<Integer> lst=new ArrayList<>();
        for(int i=1;i<=nums.length;i++){
            if(!set.contains(i)){
                lst.add(i);

            }


        }
        return lst;
        
    }
}