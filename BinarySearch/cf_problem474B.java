// CODEFORCES PROBLEM  474 B B. Worms
// APPROACH : BINARY SEARCH (lower bound)
// TIME COMPLEXITY: O(N*logN)


import java.util.*;
public class test {
    
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []arr=new int[n];
         int []p=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        
        }
        p[0]=arr[0];
        for(int i=1;i<n;i++){
            p[i]=p[i-1]+arr[i];
        }
        int m=sc.nextInt();
      
 
        while(m-->0){
            int a=sc.nextInt();
            int left=0;
            int right=arr.length-1;
            int ans=arr.length-1;
            while(right>=left){
                int mid=left+(right-left)/2;
                if(p[mid]>=a){
                    ans=mid;
                   right=mid-1;
                }
                else {
                   left=mid+1;
                } 
            }
            System.out.println(ans+1);
 
        }
        
        
 
        }
 
 
        
 
 
 
    }