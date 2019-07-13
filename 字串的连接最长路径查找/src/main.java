import java.util.*;

public class main {
    public static void main(String[] args) {
        method1();
    }
    public static void method1(){
        Scanner sc =new Scanner(System.in);
        List<String> list=new ArrayList<String>();
        list.add("axds");
        list.add("ayds");
        list.add("dyds");
        list.add("cyds");
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        for(String s:list){
            System.out.println(s);
        }
    }
}
