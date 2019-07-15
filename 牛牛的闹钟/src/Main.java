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
            int clockNum=sc.nextInt();
            Set<ClockTime> set=new TreeSet<>(new Comparator<ClockTime>() {
                @Override
                public int compare(ClockTime o1, ClockTime o2) {
                    if(o1.hour==o2.hour){
                        return o1.minute>=o2.minute?-1:1;
                    }
                    return o1.hour>o2.hour?-1:1;
                }
            });
            sc.nextLine();
            for(int i=0;i<clockNum;i++){
                set.add(new ClockTime(sc.nextInt(),sc.nextInt()));
                sc.nextLine();
            }
            int goTime=sc.nextInt();
            sc.nextLine();
            int targetHour=sc.nextInt();
            int targetMinute=sc.nextInt();
            while(targetMinute<goTime){
                targetMinute+=60;
                targetHour--;
            }
            targetMinute-=goTime;
            for(ClockTime temp:set){
                if(temp.hour>targetHour){
                    continue;
                }
                if((temp.hour==targetHour&&temp.minute<=targetMinute)||(temp.hour<targetHour)){
                    System.out.println(temp.hour+" "+temp.minute);
                    break;
                }
            }
        }
    }
    static class ClockTime{
        int hour;
        int minute;
        public ClockTime(int hour,int minute){
            this.hour=hour;
            this.minute=minute;
        }
    }
}
