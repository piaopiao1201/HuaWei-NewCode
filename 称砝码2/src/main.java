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
            int res=fama(num,weight,count);
            System.out.println(res);
        }
    }
    public static int fama(int num,int[] weight,int[] count){
        Set<Integer> set=new HashSet<Integer>();
        set.add(0);
        for (int i=0;i<num;i++){
            List<Integer> list=new ArrayList<Integer>(set);
            for(int j=0;j<=count[i];j++){
                for(int k=0;k<list.size();k++){
                    set.add(list.get(k)+j*weight[i]);
                }
            }
        }
        return set.size();
    }
}
