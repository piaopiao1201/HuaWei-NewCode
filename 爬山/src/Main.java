import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
            String ques=sc.nextLine();
            long max=1;
            for(int i=ques.length()-1;i>=0;i--){
                max*=ques.charAt(i)-'0';
            }
            for(int i=ques.length()-2;i>=0;i--){
                if(ques.charAt(i)=='0'||(i!=0&&ques.charAt(i)=='1')){
                    continue;
                }
                long temp=1;
                temp*= Math.pow(9,ques.length()-1-i);
                if(i!=0){
                    temp*=ques.charAt(i)-'1';
                }
                for(int j=i-1;j>=0;j--){
                    temp*=ques.charAt(j)-'0';
                }
                max=Math.max(max,temp);
            }
            System.out.println(max);
        }
    }
}
