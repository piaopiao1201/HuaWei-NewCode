import java.util.*;

public class main {
    public static void main(String[] args) {
        Map<Character,Integer> map=new TreeMap<Character,Integer>();
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            map.clear();
            String ques=sc.nextLine();
            for(int i=0;i<ques.length();i++){
                Character c=ques.charAt(i);
                if(map.containsKey(c)){
                    map.put(c,map.get(c)+1);
                }else{
                    map.put(c,1);
                }
            }
            List<Map.Entry<Character,Integer>> list=new ArrayList<Map.Entry<Character,Integer>>(map.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
                @Override
                public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                    return o1.getValue().compareTo(o2.getValue());
                }
            });
            int minCount=list.get(0).getValue();
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<ques.length();i++){
                Character c=ques.charAt(i);
                if(map.get(c)!=minCount){
                    sb.append(c);
                }
            }
            System.out.println(sb.toString());
        }
    }
}
