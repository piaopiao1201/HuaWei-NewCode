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
            int jobNum=sc.nextInt();
            int personNum=sc.nextInt();
            List<bean> list=new ArrayList<>();

            for(int i=0;i<jobNum;i++){
                list.add(new bean(sc.nextInt(),sc.nextInt()));
            }
            List<Integer> quesArr=new ArrayList<>();
            for (int i=0;i<personNum;i++){
                int ques=sc.nextInt();
                quesArr.add(ques);
                list.add(new bean(ques,0));
            }
            list.sort(new Comparator<bean>() {
                @Override
                public int compare(bean o1, bean o2) {
                    if(o1.capable==o2.capable){
                        return o1.payback>o2.payback?-1:1;
                    }
                    return o1.capable<o2.capable?-1:1;
                }
            });
            Map<Integer,Integer> resMap=new HashMap<>();
            int maxPayBack=0;
            for(int i=0;i<list.size();i++){
                if(list.get(i).payback!=0){
                    maxPayBack=Math.max(maxPayBack,list.get(i).payback);
                }else{
                    resMap.put(list.get(i).capable,maxPayBack);
                }
            }
            for(int i=0;i<quesArr.size();i++){
                System.out.println(resMap.get(quesArr.get(i)));
            }
        }
    }
    static class bean{
        int capable;
        int payback;
        public bean(int capable,int payback){
            this.capable=capable;
            this.payback=payback;
        }
    }
}
