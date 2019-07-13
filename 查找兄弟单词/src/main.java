import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class main {
    public static List<String> list;
    public static void main(String[] args) {
        try {
            FileInputStream fis=new FileInputStream("input.txt");
            System.setIn(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner sc=new Scanner(System.in);
        list=new ArrayList<String>();

        while(sc.hasNext()){
            list.clear();
            int num=sc.nextInt();
            for(int i=0;i<num;i++){
                list.add(sc.next());
            }
            list.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
            String ques=sc.next();
            int quesNo=sc.nextInt();
            List<String> res=find(ques);
            System.out.println(res.size());
            if(quesNo<=res.size()){
                System.out.println(res.get(quesNo-1));
            }

        }
    }

    public static List<String> find(String ques){
        Map<Character,Integer> map=new HashMap<Character,Integer>();
        List<String> res=new ArrayList<String>();
        for(Character c:ques.toCharArray()){
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);

            }else{
                map.put(c,1);
            }
        }
        for(String temp:list){
            if(temp.length()!=ques.length()){
                continue;
            }
            if(temp.equals(ques)){
                continue;
            }
            Map<Character,Integer> map2=new HashMap<>(map);
            for(Character c:temp.toCharArray()){
                if(map2.containsKey(c)){
                    map2.put(c,map2.get(c)-1);
                    if(map2.get(c)==0){
                        map2.remove(c);
                    }
                }else{
                    break;
                }
            }
            if(map2.isEmpty()){
                res.add(temp);
            }
        }
        return res;
    }
}
