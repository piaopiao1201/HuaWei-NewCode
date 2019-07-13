import java.util.Scanner;

public class main {
    public static void main(String[] args){
        String ques="";
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            ques=sc.nextLine();
            double times=Math.ceil((double)ques.length()/8);
            for(int i=0;i<times;i++){
                StringBuilder sb=new StringBuilder();
                sb.append(ques.substring(i*8,Math.min((i+1)*8,ques.length())));
                while(sb.length()<8){
                    sb.append('0');
                }
                System.out.println(sb.toString());
            }
        }
    }
}
