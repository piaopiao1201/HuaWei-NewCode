import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class main {
    public static void main(String[] args) {
        int N=10;
        Map<Integer,Double> startMap=new LinkedHashMap<Integer, Double>();
        double[][] resTable=new double[N+1][6*N+1];
        List<Pair<Integer,Double>> res=new ArrayList<Pair<Integer, Double>>();
        for(int i=1;i<=6;i++){
            resTable[1][i]=(double)1/6;
        }


        for(int i=2;i<=N;i++){
            for(int j=i;j<=i*6;j++){
                for(int k=1;k<=6;k++){
                    if(j>k){
                        resTable[i][j]+=resTable[i-1][j-k];
                    }
                }
                resTable[i][j]/=6;
            }
        }
        for(int i=N;i<=6*N;i++){
            res.add(new Pair<>(i,resTable[N][i]));

        }
        for(int i=0;i<res.size();i++){
            System.out.println(res.get(i).getKey()+":"+res.get(i).getValue());
        }

    }
    public static double retain(double ques){
        return Math.floor(ques*100000)/100000;
    }
}
