//  Interesting drink  code forces problem 706 B
// Approach : Binary Search (efficiently eliminating half and searching in that half )
//  Time Complexity: O(N*logN)
import java.util.*;
public class test {
    
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int q=sc.nextInt();
        Arrays.sort(arr);
        while(q-->0){
            int p=sc.nextInt();
            int left=0;
            int right=arr.length-1;
            int ans=0;
            while(right>=left){
                int mid=left+(right-left)/2;
                if(arr[mid]<=p){
                    ans=mid+1;
                    left=mid+1;
                }
                else {
                    right=mid-1;
                }
            }
            System.out.println(ans);
 
        }
        
        
 
        }
 
 
        
 
 
 
    }