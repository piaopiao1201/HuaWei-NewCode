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
            int s=sc.nextInt();
            int m=sc.nextInt();
            TreeSet<Node> set=new TreeSet<>();
            for(int i=0;i<s;i++){
                set.add(new Node(sc.nextInt(),i+1));
            }
            List<int[]> res=new ArrayList<>();
            for(int i=0;i<m;i++){
                Node temp1=set.pollFirst();
                Node temp2=set.pollLast();
                int[] tempRes={temp2.origin,temp1.origin};
                res.add(tempRes);
                temp2.val--;
                temp1.val++;
                set.add(temp1);
                set.add(temp2);
            }
            System.out.println(set.last().val-set.first().val+" "+m);
            for (int i=0;i<res.size();i++){
                System.out.print(res.get(i)[0]+" "+res.get(i)[1]);
                if(i<res.size()-1){
                    System.out.println();
                }
            }
        }
    }
    static class Node implements Comparable{
        Integer val;
        int origin;
        public Node(Integer val,int origin){
            this.val=val;
            this.origin=origin;
        }
        @Override
        public int compareTo(Object o) {
            Node temp=(Node)o;
            int res=this.val.compareTo(temp.val);
            if(res==0){
                return this.origin==temp.origin?0:-1;
            }else{
                return res;
            }
        }

        @Override
        public int hashCode() {
            return 1;
        }

        @Override
        public boolean equals(Object obj) {
            Node temp=(Node)obj;
            return this.val.equals(temp.val);
        }
    }
}
