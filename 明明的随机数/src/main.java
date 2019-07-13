import java.util.*;

public class main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int num=sc.nextInt();
        TreeSet<Integer> treeSet=new TreeSet<Integer>();
        for(int i=0;i<num;i++){
            treeSet.add(sc.nextInt());
        }
        Iterator<Integer> it=treeSet.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
