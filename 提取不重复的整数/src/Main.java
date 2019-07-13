import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int ques=sc.nextInt();
        LinkedHashSet<Integer> set=new LinkedHashSet<Integer>();
        while(ques>0){
            set.add(ques%10);
            ques/=10;
        }
        Iterator<Integer> it=set.iterator();
        int res=0;
        while(it.hasNext()){
            res=res*10+it.next();
        }
        System.out.println(res);
    }
}
