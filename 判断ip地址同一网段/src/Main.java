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
//        int a=192;
//        int b=255;
//        int c=a&b;
//        System.out.println(Integer.toBinaryString(c));
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String s1=sc.next();
            String s2=sc.next();
            String s3=sc.next();
            String[] str1Ques=s1.split("\\.");
            String[] str2Ques=s2.split("\\.");
            String[] str3Ques=s3.split("\\.");
            String res1="";
            for(int i=0;i<str1Ques.length;i++){
                int temp1=Integer.valueOf(str1Ques[i]);
                int temp2=Integer.valueOf(str3Ques[i]);
                //int temp3=Integer.valueOf(str3Ques[i]);
                int temp3=temp1&temp2;
                res1+=String.valueOf(temp3)+".";
            }
            res1=res1.substring(0,res1.length()-1);
            String res2="";
            for(int i=0;i<str2Ques.length;i++){
                int temp1=Integer.valueOf(str2Ques[i]);
                int temp2=Integer.valueOf(str3Ques[i]);
                //int temp3=Integer.valueOf(str3Ques[i]);
                int temp3=temp1&temp2;
                res2+=String.valueOf(temp3)+".";
            }
            res2=res2.substring(0,res2.length()-1);
            if(res1.equals(res2)){
                System.out.println(1+" "+res1);
            }else{
                System.out.println(0+" "+res1);
            }
        }
    }
}
