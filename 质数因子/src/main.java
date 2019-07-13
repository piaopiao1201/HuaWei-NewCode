import java.util.*;
public class main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            long ques=sc.nextLong();
            System.out.println(getResult(ques));
        }
    }
    public static String getResult(long data){
        String str="";
        long times=(long)Math.sqrt(data);
        for(int i=2;i<=data;i++){
            while(data%i==0){
                data/=i;
                str+=i;
                str+=' ';
            }
            if(data==1){
                break;
            }
        }
        return str;
    }
}