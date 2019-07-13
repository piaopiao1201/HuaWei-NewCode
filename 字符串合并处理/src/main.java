import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
//        String res=convert('7');
//        System.out.println(1);
        try {
            FileInputStream fis=new FileInputStream("input.txt");
            System.setIn(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String ques1=sc.next();
            String ques2=sc.next();
            String ques=ques1+ques2;
            List<Character> oddList=new ArrayList<Character>();
            List<Character> evenList=new ArrayList<Character>();
            for(int i=0;i<ques.length();i++){
                if(i%2==0){
                    evenList.add(ques.charAt(i));
                }else{
                    oddList.add(ques.charAt(i));
                }
            }
            oddList.sort(new Comparator<Character>() {
                @Override
                public int compare(Character o1, Character o2) {
                    if(o1==o2){
                        return 0;
                    }
                    return o1>o2?1:-1;
                }
            });
            evenList.sort(new Comparator<Character>() {
                @Override
                public int compare(Character o1, Character o2) {
                    if(o1==o2){
                        return 0;
                    }
                    return o1>o2?1:-1;
                }
            });
            StringBuilder sb=new StringBuilder();
            int i=0;
            while (i<oddList.size()&&i<evenList.size()){
                sb.append(evenList.get(i));
                sb.append(oddList.get(i));
                i++;
            }
            int tempI=i;
            while(tempI<oddList.size()){
                sb.append(oddList.get(i));
                tempI++;
            }
            while(i<evenList.size()){
                sb.append(evenList.get(i));
                i++;
            }
            System.out.println(ProcessString(sb.toString()));
        }
    }
    public static String ProcessString(String ques){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<ques.length();i++){
            sb.append(convert(ques.charAt(i)));
        }
        return sb.toString();
    }
    public static String convert(char s){
        int temp=0;
        if(s>='0'&&s<='9'){
            temp=s-'0';
        }else if(s>='a'&&s<='f'){
            temp=10+(s-'a');
        }else if(s>='A'&&s<='F'){
            temp=10+(s-'A');
        }else{
            String res=String.valueOf(s);
            return res;
        }
        String binary=Integer.toBinaryString(temp);
        while(binary.length()<4){
            binary='0'+binary;
        }
        StringBuilder sb=new StringBuilder(binary);
        String res=sb.reverse().toString();
        Integer res2=Integer.valueOf(res,2);
        return Integer.toHexString(res2).toUpperCase();
    }
}
