import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
            String s1=sc.next();
            String s2=sc.next();
            int[] res=new int[s1.length()+s2.length()+1];
            s1=new StringBuilder(s1).reverse().toString();
            s2=new StringBuilder(s2).reverse().toString();
            for(int i=1;i<=s1.length();i++){
                for(int j=1;j<=s2.length();j++){
                    int a=s1.charAt(i-1)-'0';
                    int b=s2.charAt(j-1)-'0';
                    res[i+j-1]+=a*b;
                    res[i+j]+=res[i+j-1]/10;
                    res[i+j-1]%=10;
                }
            }
            StringBuilder sb=new StringBuilder();
            for(int i=s1.length()+s2.length();i>=1;i--){
                sb.append(res[i]);
            }
            String res2=sb.toString();
            for(int i=0;i<res2.length();i++){
                if(res2.charAt(i)!='0'){
                    System.out.println(res2.substring(i));
                    break;
                }
            }
        }
    }
}
