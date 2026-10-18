// LEETCODE PROBLEM: 205 Group Anagrams

class Solution {
    public boolean isIsomorphic(String s, String t) {

        HashMap<Character,Character> map=new HashMap<>();
        boolean valid =true;
     
        for(int i=0;i<s.length();i++){
           
                if(map.containsKey((s.charAt(i)))){
                    char ch=map.get((s.charAt(i)));
                   
                    if(ch!=t.charAt(i)){
                        valid=false;
                        break;
                    }
                    
                }
                else {
                    if(map.containsValue(t.charAt(i))){
                        valid=false;
                        break;
                    }
                    map.put(s.charAt(i),t.charAt(i));
                }
            
           
        }
        return valid;
        
    }
}
