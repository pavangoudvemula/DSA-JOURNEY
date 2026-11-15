class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int count1=0,count2=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);

        }
        int k=map.size();
        int left=0;
        int right=0;
        HashMap<Integer,Integer> map1=new HashMap<>();

        while(right<nums.length){
            map1.put(nums[right],map1.getOrDefault(nums[right],0)+1);
            if(map1.size()<=k){
                count1+=(right-left+1);
                right++;
            }
            else{
                while(map1.size()>k){
                    int val=map1.get(nums[left]);
                    if(val==1){
                        map1.remove(nums[left]);
                    }
                    else{
                        map1.put(nums[left],val-1);
                    }
                    left++;
                }
                count1+=(right-left+1);
                right++;
            }
            
            
        }
        left=0;
        right=0;
        map1.clear();
        while(right<nums.length){
            map1.put(nums[right],map1.getOrDefault(nums[right],0)+1);
            if(map1.size()<=k-1){
                count2+=(right-left+1);
                right++;
            }
            else{
                while(map1.size()>=k){
                    int val=map1.get(nums[left]);
                    if(val==1){
                        map1.remove(nums[left]);
                    }
                    else{
                        map1.put(nums[left],val-1);
                    }
                    left++;
                }
                count2+=(right-left+1);
                right++;
            }

        }
        return count1-count2;        
    }
}