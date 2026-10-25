// D2. Magic Powder - 2
// Approach : Binary search on answer 
// Time complexity: O(n*logn)

import java.util.*;
public class Main{
    static boolean can(long cookies,int [] a,int []b,int k){
        
        for(int i=0;i<a.length;i++){
           long req=((long)a[i]*cookies);
           if(b[i]<req){
            long addi=req-b[i];
            if(k<addi){
                return false;
            }
            k-=(addi);
 
 
 
            }
 
 
        }
        return true;
        
        }
 
        
 
 
 
 
 
        
       
       
    
   
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int []a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int []b=new int[n];
        int mini=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            b[i]=sc.nextInt();
            mini=Math.min(mini,b[i]);
        }
        long left=0;
        long right=mini+k;
      long  ans=0;
        while(right>=left){
            long mid=left+(right-left)/2;
            if(can(mid,a,b,k)){
                ans=mid;
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        System.out.println(ans);
        
 
 
        
          
 
    }
 
}