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
        while(sc.hasNext()){
            int n=sc.nextInt();
            int k=sc.nextInt();
            if(k==0){
                long res=(long)n*n;
                System.out.println(res);
                continue;
            }
            long sum=0;
            /*
                用i j表示两个均不大于n的数
                1、当i<j时 8 9,8 10,9 10
             */
            for(int m=k;m<n;m++){
                sum+=n-m;
            }

            //2、当i>j时
            for(int m=k+1;m<=n-k;m++){
                int start=1;
                while(start*m+k<=n){
                    int temp=start*m+k;
                    if(n<(start+1)*m){
                        sum+=n-temp+1;
                    }else{
                        sum+=(start+1)*m-temp;
                    }
                    start++;
                }
            }
            System.out.println(sum);
        }
    }
}
