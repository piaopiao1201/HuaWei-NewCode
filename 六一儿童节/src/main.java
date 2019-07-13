import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class main {
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
            flagSet.clear();
            hashMap.clear();
            int childNum=sc.nextInt();
            sc.nextLine();
            int[] childArr=new int[childNum];
            for(int i=0;i<childNum;i++){
                childArr[i]=sc.nextInt();
            }
            sc.nextLine();
            int choloNum=sc.nextInt();
            sc.nextLine();
            int[] cholo=new int[choloNum];
            for(int i=0;i<cholo.length;i++){
                cholo[i]=sc.nextInt();
            }
            for(int i=0;i<cholo.length;i++){
                flagSet.clear();
                find(cholo[i],childArr);
            }
            System.out.println(1);
        }
    }
    public static boolean find(int left,int[] childArr){
        for(int i=0;i<childArr.length;i++){
            if(childArr[i]<=left&&!flagSet.contains(i)){
                flagSet.add(i);
                if(!hashMap.containsKey(i)||find(hashMap.get(i),childArr)){
                    hashMap.put(i,left);
                    return true;
                }
            }
        }
        return false;
    }
}
