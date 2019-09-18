import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        try {
            FileInputStream fis=new FileInputStream("input.txt");
            System.setIn(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int m=sc.nextInt();
            int sum=0;
            for(int i=0;i<2*m;i++){
                if((i/m)%2==0){
                    sum-=(i+1);
                }else{
                    sum+=(i+1);
                }
            }
            System.out.println(sum*(n/(2*m)));
        }

    }
}