// Queries about less or equal elements codeforces problem 600 B
// approach : Binary search(upper bound )
// Time Complexity: O(N*logN)
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int [] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int []b =new int[m];
        for(int i=0;i<m;i++){
            b[i]=sc.nextInt();
        }
        Arrays.sort(a);
        for(int i=0;i<m;i++){
            int left=0;
            int right=n-1;
            int index=a.length;
            while(right>=left){
                int mid=left+(right-left)/2;
                if(a[mid] > b[i]){
                    index=mid;
                    right=mid-1;
                }
                else{
                    left=mid+1;
                }
            }
            System.out.print(index+" ");
 
        }
 
    }
}