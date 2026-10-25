// D1. Magic Powder - 1 codeforce problem 670 D1 
// Approach : Bruteforce Approach (constraints are very small ) Other Approach:Binary Search on Answer

import java.util.*;
public class Main{
   
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int []a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int []b=new int[n];
        for(int i=0;i<n;i++){
            b[i]=sc.nextInt();
        }
        int i=0;
        int count=0;
        while(true){
            if(b[i] <a[i]){
                if(k>=(a[i]-b[i])){
                    k-=(a[i]-b[i]);
                    b[i]=0;
                }else{
                    break;
                }
            }
            else{
                b[i]-=a[i];
            }
            i++;
            if(i==n){
                count++;
                i=0;
            }
 
 
        }
        System.out.println(count);
        
 
 
        
          
 
    }
}