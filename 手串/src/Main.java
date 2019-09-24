import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            FileInputStream fis=new FileInputStream("input.txt");
            System.setIn(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int m=sc.nextInt();
            int c=sc.nextInt();
            List<List<Integer>> res=new ArrayList<List<Integer>>();
            res.add(null);
            for(int i=0;i<c;i++){
                res.add(new ArrayList<>());
            }
            for(int i=0;i<n;i++){
                int num_i=sc.nextInt();
                for(int j=0;j<num_i;j++){
                    int tempInt=sc.nextInt();
                    res.get(tempInt).add(i+1);
                }
            }
            int count=0;
            for(int i=1;i<=c;i++){
                if(!check(res.get(i),m,n)){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
    public static boolean check(List<Integer> arr,int iter,int size){
        if(arr.size()==1){
            return true;
        }
        for(int i=0;i<arr.size();i++){
            if(i<arr.size()-1){
                if(arr.get(i+1)-arr.get(i)<=iter-1){
                    return false;
                }
            }else{
                if(arr.get(0)+size-arr.get(i)<=iter-1){
                    return false;
                }
            }
        }
        return true;
    }
}
