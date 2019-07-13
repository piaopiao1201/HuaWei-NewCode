import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
        int caseNum=sc.nextInt();
        for (int i=0;i<caseNum;i++){
            int roadLength=sc.nextInt();
            sc.nextLine();
            String[] quesArr=sc.nextLine().split("");
            System.out.println(1);
        }

        int a=-3;
        String ques="01111111111111111111111111111111";
        int b=Integer.valueOf(ques,2);
        System.out.println(1);

    }
}
