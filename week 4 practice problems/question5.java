import java.util.*;

class question5 {
 public static void main(String[] a) {
  Scanner s=new Scanner(System.in);
  int n=s.nextInt();
  int[] x=new int[n];

  for(int i=0;i<n;i++) x[i]=s.nextInt();

  int k=s.nextInt();
  k=k%n;

  int[] r=new int[n];
  for(int i=0;i<n;i++)
   r[(i+k)%n]=x[i];

  for(int z:r) System.out.print(z+" ");
 }
}
