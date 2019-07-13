import java.util.*;
import java.util.regex.Pattern;

public class main{
    public static void main(String[] args){
        boolean daysMatch= Pattern.matches(".*[a-z].*","asass");
        System.out.println(daysMatch);
        char a='s';
        char b=(char)(a+2);
        System.out.println(b);
//        Scanner sc=new Scanner(System.in);
//        while(sc.hasNext()){
//            String ques=sc.nextLine();
//            if(checkLength(ques)&&checkContent(ques)&&!hasSub(ques)){
//                System.out.println("OK");
//            }else{
//                System.out.println("NG");
//            }
//        }
    }
    public static boolean checkLength(String ques){
        return ques.length()>8;
    }
    public static boolean checkContent(String ques){
        int count=0;
        if(ques.matches(".*[A-Z].*")){
            count++;
        }
        if(ques.matches(".*[a-z].*")){
            count++;
        }
        if(ques.matches(".*[0-9].*")){
            count++;
        }
        if(ques.matches(".*[^A-Za-z0-9].*")){
            count++;
        }
        return count>=3?true:false;
    }
    public static boolean hasSub(String ques){
        for(int i=0;i<ques.length()-2;i++){
            if(ques.substring(i+3).contains(ques.substring(i,i+3))){
                return true;
            }
        }
        return false;
    }
}