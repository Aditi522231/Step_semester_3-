import java.util.*;

class question2 {
 public static void main(String[] a) {
  Scanner s=new Scanner(System.in);
  int n=s.nextInt();
  int[] p=new int[n];
  for(int i=0;i<n;i++) p[i]=s.nextInt();

  int min=p[0], profit=0;
  for(int i=1;i<n;i++) {
   if(p[i]<min) min=p[i];
   if(p[i]-min>profit) profit=p[i]-min;
  }
  System.out.println(profit);
 }
}