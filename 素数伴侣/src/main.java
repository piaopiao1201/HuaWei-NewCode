import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class main {
    public static List<Integer> oddList=new ArrayList<Integer>();
    public static List<Integer> evenList=new ArrayList<Integer>();
    public static Set<Integer> flagSet=new HashSet<Integer>();
    public static Map<Integer,Integer> hashMap=new HashMap<Integer,Integer>();
    public static void main(String[] args) {
        try {
            FileInputStream fis=new FileInputStream("input.txt");
            System.setIn(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            oddList.clear();
            evenList.clear();
            hashMap.clear();
            int num=sc.nextInt();
            for(int i=0;i<num;i++){
                int temp=sc.nextInt();
                if(temp%2==0){
                    evenList.add(temp);
                }else{
                    oddList.add(temp);
                }
            }
            for(int i=0;i<oddList.size();i++){
                flagSet.clear();
                find(oddList.get(i));
            }
            System.out.println(hashMap.size());
        }
    }
    public static boolean find(int left){
        for(int i=0;i<evenList.size();i++){
            if(judge(evenList.get(i)+left)&&!flagSet.contains(evenList.get(i))){
                flagSet.add(evenList.get(i));
                if(!hashMap.containsKey(evenList.get(i))||find(hashMap.get(evenList.get(i)))){
                    hashMap.put(evenList.get(i),left);
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean judge(int num){
        for(int i=2;i<=num/2;i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
}
