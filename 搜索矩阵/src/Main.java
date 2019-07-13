import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
            int num=sc.nextInt();
            sc.nextLine();
            List<char[]> map=new ArrayList<char[]>();
            int colNum=-1;
            for(int i=0;i<num;i++){
                String temp=sc.nextLine();
                colNum=temp.length();
                map.add(temp.toCharArray());
            }
            if(map.size()==0){
                System.out.println(0);
                continue;
            }
            if(map.size()==1){
                System.out.println(1);
                continue;
            }
            int[][] dp=new int[num][colNum];
            int res=0;
            for(int i=0;i<map.size()-1;i++){
                for(int j=0;j<colNum-1;j++){
                    if(map.get(i)[j]=='1'){
                        int temp=Math.min(dp[i][j],dp[i][j+1]);
                        dp[i+1][j+1]=Math.min(temp,dp[i+1][j])+1;
                    }else{
                        dp[i+1][j+1]=0;
                    }
                    res=Math.max(res,dp[i+1][j+1]);
                }
            }
            System.out.println(res*res);
        }
    }
}
