import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
            int turnNum=sc.nextInt();
            sc.nextLine();
            String ques=sc.nextLine();
            Map<Integer,Character> map=new HashMap<>();
            map.put(0,'N');
            map.put(1,'E');
            map.put(2,'S');
            map.put(3,'W');
            int start=0;
            for(int i=0;i<ques.length();i++){
                if(ques.charAt(i)=='L'){
                    start=(start-1+4)%4;
                }else{
                    start=(start+1+4)%4;
                }
            }
            System.out.println(map.get(start));
        }
    }
}
