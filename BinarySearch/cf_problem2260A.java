// A. Monocarp's Contest  codeforce problem 2260 A
// approach: brute force approach (alternate Approach : binary search)
// Time complexity : O(t*n)


import java.util.*;
 
public class Main{
 
    
 
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++){
            int n=sc.nextInt();
            int[] arr=new int[n];
            int count=0;
            for(int j=0;j<n;j++){
                arr[j]=sc.nextInt();
                if(arr[j]==0){
                    count++;
                }
 
            }
            if(count<2){
                System.out.println(-1);
            }
            else{
                int op=0;
                if(arr[0]!=0){
                    op++;
 
                }
                if(arr[arr.length-1]!=0){
                    op++;
                }
                System.out.println(op);
            
            }
 
        }
        
        }
 
        
        
 
 
        
 
        
 
        
    
 
 
       
        
 
    
 
 
        
        
    }