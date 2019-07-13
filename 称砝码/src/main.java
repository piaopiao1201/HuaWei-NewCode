import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class main {
    public static void main(String[] args) {
        try {
            FileInputStream fis=new FileInputStream("input.txt");
            System.setIn(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int num=sc.nextInt();
            Set<Integer> set=new HashSet<Integer>();
            sc.nextLine();
            int[] weight=new int[num];
            int[] count=new int[num];
            for(int i=0;i<num;i++){
                int temp=sc.nextInt();
                weight[i]=temp;
            }
            sc.nextLine();
            for(int i=0;i<num;i++){
                int temp=sc.nextInt();
                count[i]=temp;
            }
            List<Integer> list=new ArrayList<Integer>();
            for(int i=0;i<num;i++){
                for(int j=0;j<count[i];j++){
                    list.add(weight[i]);
                }
            }
            boolean[] flag=new boolean[list.size()];
            DFS(flag,list,set,0,0);
            System.out.println(set.size());
        }
    }
    public static void DFS(boolean[] flag,List<Integer> list,Set<Integer> res,int sum,int index){
        res.add(sum);
        if(index>=list.size()){
            return;
        }
        DFS(flag,list,res,sum+list.get(index),index+1);
        DFS(flag,list,res,sum,index+1);
    }
}
