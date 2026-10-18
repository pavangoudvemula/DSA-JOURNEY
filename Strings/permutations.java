// LEETCODE PROBLEM: 567  Permutation in String
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int [] freq=new int[123];
        int [] nfreq=new int[123];
        int count=0;
        int flag=0;
        for(int i=0;i<s1.length();i++){
            freq[s1.charAt(i)]++;
            count++;
        
        }
        int left=0;
        int right=0;
        boolean valid=false;
        while(right<s2.length()){
            if(freq[s2.charAt(right)]>0 &&( freq[s2.charAt(right)] > nfreq[s2.charAt(right)] )){
                nfreq[s2.charAt(right)]++;
                flag++;
                right++;
                if(flag==count){
                    valid=true;
                    break;
                }


            }
            else {
                if(freq[s2.charAt(right)]>0){
                    while(freq[s2.charAt(right)] <= nfreq[s2.charAt(right)]){
                    nfreq[s2.charAt(left)]--;
                    left++;
                    flag--;

                }
                nfreq[s2.charAt(right)]++;
                right++;
                flag++;


                }
                else{

                    while(left<right){
                        nfreq[s2.charAt(left)]--;
                        left++;
                        flag--;
                    }
                    left++;
                    right=left;

                    
                }
                
                

            }
            
        }
        return valid;



        
    }
}