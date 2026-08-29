import java.util.*;

class question1 {
 public static void main(String[] a) {
  Scanner s=new Scanner(System.in);
  int n=s.nextInt(), x=s.nextInt();
  int[] arr=new int[n];
  for(int i=0;i<n;i++) arr[i]=s.nextInt();

  for(int i=0;i<n;i++)
   for(int j=i+1;j<n;j++)
    if(arr[i]+arr[j]==x) {
     System.out.println(i+" "+j);
     return;
    }
 }
}