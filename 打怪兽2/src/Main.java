import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

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
            //int[][] map=new int[100][100];
            List<int[]> map=new ArrayList<int[]>();
            int row=0;
            int guaiNum=0;
            List<Integer> guaiArr=new ArrayList<Integer>();
            while(sc.hasNext()){
                String temp=sc.nextLine();
                String[] ques=temp.split(" ");
                int[] ques2=new int[ques.length];
                for(int i=0;i<ques.length;i++){
                    int temp2=Integer.valueOf(ques[i]);
                    if(temp2>=2){
                        guaiNum++;
                        guaiArr.add(temp2);
                    }
                    ques2[i]=temp2;
                }

                map.add(ques2);
            }
            guaiArr.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    if(o1==o2){
                        return 0;
                    }
                    return o1>o2?1:-1;
                }
            });
            List<zuobiao> tempRes=new ArrayList<zuobiao>();
            List<Integer> minRes=new ArrayList<Integer>();
            minRes.add(Integer.MAX_VALUE);
            List<Integer> guaiIndex=new ArrayList<Integer>();
            guaiIndex.add(0);
            int[][][] flag=new int[map.size()][map.size()][1000000];
            //int[] keyFlag=new int[map.size()];
            DFS(0,0,map,guaiIndex,guaiArr,flag,tempRes,minRes);
            if(minRes.get(0)!=Integer.MAX_VALUE){
                System.out.println(minRes.get(0));
            }else{
                System.out.println(-1);
            }
        }
    }
    public static void DFS(int curX,int curY,List<int[]> map,List<Integer> guaiIndex,List<Integer> guaiArr,int[][][] flag,List<zuobiao> tempRes,List<Integer> minRes){
        if(guaiIndex.get(0)==guaiArr.size()){
            minRes.set(0,Math.min(minRes.get(0),tempRes.size()-1));
            return;
        }
        if(curX<0||curX>=map.size()||curY<0||curY>=map.size()){
            return;
        }
        if(map.get(curX)[curY]==0){
            return;
        }
        if(flag[curX][curY][0]==1){
            boolean haha=false;
            for (int i=0;i<guaiArr.size();i++){
                if(flag[curX][curY][guaiArr.get(i)]==1){
                    haha=true;
                    flag[curX][curY][guaiArr.get(i)]=0;
                    break;
                }
            }
            if(!haha){
                return;
            }
        }
        boolean isHuan=false;
        int yuan=0;
        if(map.get(curX)[curY]==guaiArr.get(guaiIndex.get(0))){
            isHuan=true;
            yuan=map.get(curX)[curY];
            flag[curX][curY][map.get(curX)[curY]]=1;
            guaiIndex.set(0,guaiIndex.get(0)+1);
            map.get(curX)[curY]=1;
        }
        flag[curX][curY][0]=1;
        tempRes.add(new zuobiao(curX,curY));
        DFS(curX+1,curY,map,guaiIndex,guaiArr,flag,tempRes,minRes);
        DFS(curX,curY+1,map,guaiIndex,guaiArr,flag,tempRes,minRes);
        DFS(curX-1,curY,map,guaiIndex,guaiArr,flag,tempRes,minRes);
        DFS(curX,curY-1,map,guaiIndex,guaiArr,flag,tempRes,minRes);
        tempRes.remove(tempRes.size()-1);
        flag[curX][curY][0]=0;
        if(isHuan){
            guaiIndex.set(0,guaiIndex.get(0)-1);
            map.get(curX)[curY]=yuan;
        }
    }
    static class zuobiao{
        public int x;
        public int y;
        public zuobiao(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
}
