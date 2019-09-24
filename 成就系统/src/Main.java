import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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
            boolean[] flag=new boolean[n+1];
            Arrays.fill(flag,false);
            List<List<Integer>> preset=new ArrayList<List<Integer>>();
            preset.add(null);
            for(int i=0;i<n;i++){
                int k=sc.nextInt();
                List<Integer> temp=new ArrayList<>();
                for(int j=0;j<k;j++){
                    temp.add(sc.nextInt());
                }
                preset.add(temp);
            }

            for(int i=1;i<=n;i++){
                List<Integer> res=new ArrayList<>();
                res.add(0);
                find(flag,preset,res,i);
                if(i<n){
                    System.out.print(res.get(0)+" ");
                }else{
                    System.out.print(res.get(0));
                    System.out.println();
                }

            }

        }
    }
    public static void find(boolean[] flag,List<List<Integer>> preset,List<Integer> res,int i){
        if(flag[i]){
            return;
        }
        for(int j=0;j<preset.get(i).size();j++){
            find(flag,preset,res,preset.get(i).get(j));
        }
        res.set(0,res.get(0)+1);
        flag[i]=true;
    }
}
