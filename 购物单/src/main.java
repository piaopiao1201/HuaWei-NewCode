import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class main {
    public static void main(String[] args) throws FileNotFoundException {
        //物品的价值数组
        int[] v=new int[61];
        //物品的重要程度
        int[] w=new int[61];
        //物品从属数组
        int[] q=new int[61];
        //dp[i][n]数组 表示在选择前i个物品总价小于等于n时最大的价值
        int[][] dp=new int[61][32001];
        FileInputStream fs=new FileInputStream("input.txt");
        System.setIn(fs);
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int allMoney=sc.nextInt();
            int thingNum=sc.nextInt();
            sc.nextLine();
            for(int i=1;i<=thingNum;i++){
                int price=sc.nextInt();
                int importance=sc.nextInt();
                int congshu=sc.nextInt();
                v[i]=price;
                w[i]=price*importance;
                q[i]=congshu;
            }
            //dp规划
            for(int i=1;i<=thingNum;i++){
                for(int j=v[i];j<=allMoney;j++){
                    if(q[i]==0){
                        //主件
                        dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-v[i]]+w[i]);
//                        if(v[i]<=j){
//                            dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-v[i]]+w[i]);
//                        }else{
//
//                        }
                    }else{
                        if(v[i]+v[q[i]]<=j){
                            dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-v[i]]+w[i]);
                        }else{
                            dp[i][j]=dp[i-1][j];
                        }
                    }

                }
            }
            System.out.println(dp[thingNum][allMoney]);
        }
    }
    public static void method1() throws FileNotFoundException {
        FileInputStream fs=new FileInputStream("input.txt");
        System.setIn(fs);
        Scanner sc=new Scanner(System.in);
        Set<thing> mySet=new TreeSet<thing>(new Comparator<thing>() {
            @Override
            public int compare(thing o1, thing o2) {
                if(o1.fujian==o2.xuhao){
                    return 1;
                }else{
                    return o1.rate>o2.rate?1:-1;
                }

            }
        });
        while(sc.hasNext()){
            mySet.clear();
            int allMoney=sc.nextInt();
            int thingNum=sc.nextInt();
            sc.nextLine();
            for(int i=1;i<=thingNum;i++){
                int price=sc.nextInt();
                int importance=sc.nextInt();
                int congshu=sc.nextInt();
                thing obj=new thing(price,importance,i,congshu);
                mySet.add(obj);
            }
            Iterator<thing> it=mySet.iterator();
            int res=0;
            while(it.hasNext()){
                thing temp=it.next();
                if(allMoney>=temp.price){
                    allMoney-=temp.price;
                    res+=temp.price*temp.importance;
                }else{
                    break;
                }
            }
            System.out.println(res);
        }
    }
}
