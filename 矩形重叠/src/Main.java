import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
            int rectangleNum=sc.nextInt();
            sc.nextLine();
            List<Integer> x1=new ArrayList<>();
            List<Integer> y1=new ArrayList<>();
            for(int i=0;i<rectangleNum;i++){
                x1.add(sc.nextInt());
            }
            sc.nextLine();
            for(int i=0;i<rectangleNum;i++){
                y1.add(sc.nextInt());
            }
            sc.nextLine();
            List<Integer> x2=new ArrayList<>();
            List<Integer> y2=new ArrayList<>();
            for(int i=0;i<rectangleNum;i++){
                x2.add(sc.nextInt());
            }
            sc.nextLine();
            for(int i=0;i<rectangleNum;i++){
                y2.add(sc.nextInt());
            }
            List<Integer> xSet=new ArrayList<>();
            xSet.addAll(x1);
            xSet.addAll(x2);
            List<Integer> ySet=new ArrayList<>();
            ySet.addAll(y1);
            ySet.addAll(y2);
            int maxRes=0;
            for(Integer x:xSet){
                for(Integer y:ySet){
                    int tempSum=0;
                    for(int i=0;i<rectangleNum;i++){
                        if(x>=x1.get(i)&&x<x2.get(i)&&y>=y1.get(i)&&y<y2.get(i)){
                            tempSum++;
                        }
                    }
                    maxRes=Math.max(tempSum,maxRes);
                }
            }
            System.out.println(maxRes);
        }

    }
}
