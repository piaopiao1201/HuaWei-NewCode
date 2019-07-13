import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class main {
    public static int count=0;

    public static void main(String[] args) {
        List<Integer> res2=new ArrayList<Integer>();
        res2.add(0);
        nQueens(2,res2);
        System.out.println(res2.get(0));
    }
    //canplace方法
    public static void nQueens(int n,List<Integer> res) {
        // write code here
        int[] result=new int[n];
        Arrays.fill(result,-1);
        nQueen(0,result,n,res);
        //return count;
    }

    public static void nQueen(int i,int[] result,int n,List<Integer> res){
        for(int j=0;j<n;j++){
            if(canplace(result,i,j)){
                result[i]=j;
                if(i==n-1){
                    //count++;
                    res.set(0,res.get(0)+1);
                    break;
                }
                nQueen(i+1,result,n,res);
            }
        }
    }
    public static boolean canplace(int[] result,int i,int j){
        for(int z=0;z<i;z++){
            if(result[z]==j||(i-z)==Math.abs(j-result[z])){
                return false;
            }
        }
        return true;
    }
}
