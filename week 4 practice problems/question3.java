public import java.util;

class question3 {
 public static void main(String[] a) {
  Scanner s=new Scanner(System.in);
  int n=s.nextInt();
  int[] arr=new int[n];
  for(int i=0;i<n;i++) arr[i]=s.nextInt();

  boolean d=false;
  for(int i=0;i<n;i++)
   for(int j=i+1;j<n;j++)
    if(arr[i]==arr[j]) d=true;

  System.out.println(d);
 }
} 
    
}
