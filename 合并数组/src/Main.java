import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
            String s1=sc.nextLine();
            String[] ques1=s1.split(",");
            List<Integer> list=new ArrayList<Integer>();
            for(String ss:ques1){
                list.add(Integer.valueOf(ss));
            }
            if(sc.hasNext()){
                String s2=sc.nextLine();
                String[] ques2=s2.split(",");
                if(!s2.equals("")){
                    for(String ss:ques2){
                        list.add(Integer.valueOf(ss));
                    }
                }
            }
            list.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1.compareTo(o2);
                }
            });
            String res="";
            for(Integer i:list){
                res+=String.valueOf(i)+",";
            }
            System.out.println(res.substring(0,res.length()-1));
        }
}
