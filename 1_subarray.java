import java.util.*;
class j{
    static void fun(int start,int end,int[] a,int n,List<List<Integer>> res){
        if(end==n){
            return;
        }
        else if(start>end){
            fun(0,end+1,a,n,res);
        }
        else{
            List<Integer> ds=new ArrayList<>();
            for(int i=start;i<end;i++){
                ds.add(a[i]);
            }
            ds.add(a[end]);
            res.add(new ArrayList<>(ds));
            fun(start+1,end,a,n,res);
        }
    }
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        List<List<Integer>> res=new ArrayList<>();
        // List<Integer> ds=new ArrayList<>();
        fun(0,0,a,n,res);
        System.out.println(res);
    }
}
