import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        try {
            FileInputStream fis=new FileInputStream("input.txt");
            System.setIn(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int num=sc.nextInt();
            long[] ques=new long[num];
            sc.nextLine();
            for(int i=0;i<num;i++){
                ques[i]=sc.nextLong();
            }
            Arrays.sort(ques);
            long num1=ques[ques.length-1]*ques[ques.length-2]*ques[ques.length-3];
            long num2=ques[0]*ques[1]*ques[ques.length-1];
            System.out.println(Math.max(num1,num2));
        }
    }
}
