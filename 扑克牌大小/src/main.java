
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.util.HashMap;
import java.util.Map;
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
            String ques=sc.nextLine();
            String[] paiArr=ques.split("-");
            String[] pai1=paiArr[0].split(" ");
            String[] pai2=paiArr[1].split(" ");
            switch (compare(pai1,pai2)){
                case 'L':
                    System.out.println(join(pai1));
                    break;
                case 'R':
                    System.out.println(join(pai2));
                    break;
                case 'E':
                    System.out.println("ERROR");
            }
        }
    }
    public static String join(String[] ques){
        String res="";
        for(int i=0;i<ques.length;i++){
            res+=ques[i];
            res+=" ";
        }
        return res.substring(0,res.length()-1);
    }
    public static char compare(String[] pai1,String[] pai2){
        Map<String,Integer> map=new HashMap<String,Integer>();
        for(int i=3;i<=10;i++){
            map.put(String.valueOf(i),i);
        }
        map.put("J",11);
        map.put("Q",12);
        map.put("K",13);
        map.put("A",14);
        map.put("2",15);
        map.put("joker",16);
        map.put("JOKER",17);
        //一方大小王直接获胜
        if(pai1.length==2){
            if(pai1[0].equals("joker")&&pai1[1].equals("JOKER")){
                return 'L';
            }
        }
        if(pai2.length==2){
            if(pai2[0].equals("joker")&&pai2[1].equals("JOKER")){
                return 'R';
            }
        }
        //一方炸弹一方不是炸弹
        if(pai1.length==4){
            if(pai2.length==4){
                return map.get(pai1[0])>map.get(pai2[0])?'L':'R';
            }
            return 'L';
        }
        if(pai2.length==4){
            return 'R';
        }
        if(pai1.length==1){
            if(pai2.length!=1){
                return 'E';
            }
            return map.get(pai1[0])>map.get(pai2[0])?'L':'R';
        }
        if(pai1.length==2){
            if(pai2.length!=2){
                return 'E';
            }
            return map.get(pai1[0])>map.get(pai2[0])?'L':'R';
        }
        if(pai1.length==3){
            if(pai2.length!=3){
                return 'E';
            }
            return map.get(pai1[0])>map.get(pai2[0])?'L':'R';
        }
        if(pai1.length==5){
            if(pai2.length!=5){
                return 'E';
            }
            return map.get(pai1[0])>map.get(pai2[0])?'L':'R';
        }
        return 'E';
    }
}
