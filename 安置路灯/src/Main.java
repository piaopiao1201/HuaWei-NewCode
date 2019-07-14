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
            int ans = 0;
            int tmp = 0;
            for (int j = 0; j < roadLength; j++) {
                if (quesArr[j].equals(".")) {
                    ans++;
                    j += 2;
                }
            }
            System.out.println(ans);
        }


    }
}
