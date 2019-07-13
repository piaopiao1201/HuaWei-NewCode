import java.util.*;
public class main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        TreeMap<Integer,Integer> tm=new TreeMap<Integer,Integer>();

        while(sc.hasNext()){
            int times=sc.nextInt();
            sc.nextLine();
            for(int i=0;i<times;i++){
                String ques=sc.nextLine();
                String[] quesArr=ques.split(" ");
                int i1=Integer.valueOf(quesArr[0]);
                int i2=Integer.valueOf(quesArr[1]);
                if(tm.containsKey(i1)){
                    tm.put(i1,tm.get(i1)+i2);
                }else{
                    tm.put(i1,i2);
                }
            }
            Iterator<Integer> it = tm.keySet().iterator();
            while (it.hasNext()) {
                //it.next()得到的是key，tm.get(key)得到obj
                int key=it.next();
                System.out.println(key+" "+tm.get(key));
            }
            tm.clear();
        }
    }
}