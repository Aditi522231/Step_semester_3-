import java.util.*;

class question4 {
 public static void main(String[] a) {
  Scanner s=new Scanner(System.in);
  int n=s.nextInt(),m=s.nextInt();
  int[] x=new int[n],y=new int[m],r=new int[n+m];

  for(int i=0;i<n;i++) x[i]=s.nextInt();
  for(int i=0;i<m;i++) y[i]=s.nextInt();

  int i=0,j=0,k=0;
  while(i<n && j<m)
   r[k++]=(x[i]<y[j])?x[i++]:y[j++];

  while(i<n) r[k++]=x[i++];
  while(j<m) r[k++]=y[j++];

  for(int z:r) System.out.print(z+" ");
 }
}
