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
            int stuNum=sc.nextInt();
            int queryNum=sc.nextInt();
            int stu[]=new int[stuNum+1];
            sc.nextLine();
            for(int i=1;i<=stuNum;i++){
                stu[i]=sc.nextInt();
            }
            sc.nextLine();
            for(int i=0;i<queryNum;i++){
                String action=sc.next();
                int a=sc.nextInt();
                int b=sc.nextInt();
                char act=action.charAt(0);
                if(act=='U'){
                    stu[a]=b;
                }else if(act=='Q'){
                    System.out.println(maxArr(stu,a,b));
                }
            }
        }
    }
    public static int maxArr(int[] arr,int a,int b){
        if(a>b){
            int temp=a;
            a=b;
            b=temp;
        }
        int max=-1;
        for(int i=a;i<=b;i++){
            max=Math.max(max,arr[i]);
        }
        return max;
    }
}
