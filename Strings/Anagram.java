// LEETCODE PROBLEM: 242 Valid Anagram
class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> map=new HashMap<>();
        for (int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                int temp=map.get(s.charAt(i));
                map.put(s.charAt(i),temp+1);
            }
            else{
                map.put(s.charAt(i),1);
            }
        }

        for(int i=0;i<t.length();i++){
            if(map.containsKey(t.charAt(i))){
                int temp=map.get(t.charAt(i));
                if(temp==1){
                    map.remove(t.charAt(i));

                }
                else{
                    map.put(t.charAt(i),temp-1);

                }
            }
            else{
                return false;
            }
        }


        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                return false;
            }
        }
        return true;
        
    }
}