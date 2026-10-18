// LEETCODE PROBLEM: 49 Group Anagrams
class Solution {
    static String build(String s){
        int [] freq=new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<26;i++){
            while(freq[i]>0){
                sb.append((char)(97+i));
                freq[i]--;
            }



        }
        String k=sb.toString();
        return k;
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String temp=build(strs[i]);
           
            if(map.containsKey(temp)){
               
                (map.get(temp)).add(strs[i]);
                
            }
            else{
                ArrayList<String>  lst=new ArrayList<>();
                lst.add(strs[i]);
                map.put(temp,lst);
                
            }

            

            
        }
        ArrayList<List<String>> res=new ArrayList<>();
        for(List<String> sres: map.values()){
            res.add(sres);
            
        }
        return res;

        
    }
}