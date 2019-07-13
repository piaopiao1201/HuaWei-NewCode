import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static int minLength=-1;
    public static void main(String[] args) {
        try {
            FileInputStream fis=new FileInputStream("input.txt");
            System.setIn(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int row=sc.nextInt();
            int column=sc.nextInt();
            sc.nextLine();
            int[][] graph=new int[row][column];
            for(int i=0;i<row;i++){
                for(int j=0;j<column;j++){
                    graph[i][j]=sc.nextInt();
                }
                if(i!=row-1){
                    sc.nextLine();
                }
            }

            boolean[][] flag=new boolean[row][column];
            List<zuobiao> tempRes= new ArrayList<zuobiao>();
            List<zuobiao> res= new ArrayList<zuobiao>();
            //flag[0][0]=true;
            List<Integer> min=new ArrayList<Integer>();
            min.add(-1);
            DFS(graph,flag,tempRes,res,0,0,row,column,min);
            for(int i=0;i<res.size();i++){
                System.out.print("("+res.get(i).x+","+res.get(i).y+")");
                if(i!=res.size()-1){
                    System.out.println();
                }
            }
        }

    }
    public static void DFS(int[][] graph,boolean[][] flag,List<zuobiao> tempRes,List<zuobiao> res,int x,int y,int row,int column,List<Integer> min){
//        if(allFlag){
//            return;
//        }
//        int x=index/column;
//        int y=index%column;
        if(x<0||y<0||x>=row||y>=column){
            return;
        }
        if(x*column+y>=row*column-1){
            tempRes.add(new zuobiao(x,y));
            if(min.get(0)==-1){
                res.addAll(tempRes);
                min.set(0,tempRes.size());
            }else{
                if(tempRes.size()<min.get(0)){
                    res.clear();
                    res.addAll(tempRes);
                    min.set(0,tempRes.size());
                }
            }
            tempRes.remove(tempRes.size()-1);
            return;
        }
        if(graph[x][y]==1||flag[x][y]){
            return ;
        }
        flag[x][y]=true;
        tempRes.add(new zuobiao(x,y));
//        if(x-1>=0){
//            flag[x-1][y]=true;
//            tempRes.add(new zuobiao(x-1,y));
//            DFS(graph,flag,tempRes,res,x-1,y,row,column);
//            tempRes.remove(tempRes.size()-1);
//            flag[x-1][y]=false;
//        }
        DFS(graph,flag,tempRes,res,x-1,y,row,column,min);
        DFS(graph,flag,tempRes,res,x+1,y,row,column,min);
        DFS(graph,flag,tempRes,res,x,y-1,row,column,min);
        DFS(graph,flag,tempRes,res,x,y+1,row,column,min);
        tempRes.remove(tempRes.size()-1);
        flag[x][y]=false;
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
