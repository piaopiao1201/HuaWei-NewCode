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
            int n=sc.nextInt();
            Map<Integer, List<Integer>> map=new HashMap<>();
            for(int i=0;i<n;i++){
                int temp=sc.nextInt();
                if(map.containsKey(temp)){
                    map.get(temp).add(i+1);
                }else{
                    map.put(temp,new ArrayList<>());
                    map.get(temp).add(i+1);
                }
            }
            int q=sc.nextInt();
            for(int i=0;i<q;i++){
                int l=sc.nextInt();
                int r=sc.nextInt();
                int k=sc.nextInt();
                int sum=0;
                if(!map.containsKey(k)){
                    System.out.println(sum);
                    continue;
                }
                List<Integer> resTemp=map.get(k);

                for(int j=0;j<resTemp.size();j++){
                    if(resTemp.get(j)>=l&&resTemp.get(j)<=r){
                        sum++;
                    }else if(resTemp.get(j)>r){
                        break;
                    }
                }
                System.out.println(sum);
            }
        }
    }

}
