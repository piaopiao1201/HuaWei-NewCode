import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

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
            int startX=0,startY=0;
            int m=sc.nextInt();
            int n=sc.nextInt();
            char[][] mapTable=new char[m][n];
            sc.nextLine();
            for(int i=0;i<m;i++){
                String temp=sc.nextLine();
                for(int j=0;j<temp.length();j++){
                    char ques=temp.charAt(j);
                    if(ques=='2'){
                        startX=i;
                        startY=j;
                    }
                    mapTable[i][j]=ques;
                }
            }
            List<zuobiao> tempRes=new ArrayList<zuobiao>();
            List<Integer> minRes=new ArrayList<Integer>();

            minRes.add(Integer.MAX_VALUE);
            int[][] flag=new int[m][n];
            Set<Character> key=new HashSet<Character>();
            DFS(startX,startY,key,flag,mapTable,tempRes,minRes);
            System.out.println(minRes.get(0));
        }
    }
    public static void DFS(int curX, int curY, Set<Character> key, int[][] flag, char[][] map,List<zuobiao> tempRes,List<Integer> minRes){
        if(curX<0||curX>=map.length||curY<0||curY>=map[0].length){
            return;
        }
        if(map[curX][curY]=='0'||flag[curX][curY]==1){
            return;
        }
        if(map[curX][curY]>='A'&&map[curX][curY]<='Z'){
            char temp=(char)(map[curX][curY]+32);
            if(!key.contains(temp)){
                return;
            }
        }
        if(map[curX][curY]=='3'){
            minRes.set(0,Math.min(minRes.get(0),tempRes.size()));
            return;
        }
        if(map[curX][curY]>='a'&&map[curX][curY]<='z'){
            key.add(map[curX][curY]);
        }
        flag[curX][curY]=1;
        tempRes.add(new zuobiao(curX,curY));
        DFS(curX-1,curY,key,flag,map,tempRes,minRes);
        DFS(curX,curY-1,key,flag,map,tempRes,minRes);
        DFS(curX,curY+1,key,flag,map,tempRes,minRes);
        DFS(curX+1,curY,key,flag,map,tempRes,minRes);
        tempRes.remove(tempRes.size()-1);
        flag[curX][curY]=0;
        if(map[curX][curY]>='a'&&map[curX][curY]<='z'){
            key.remove(map[curX][curY]);
        }
    }
    static class zuobiao{
        int x;
        int y;
        public zuobiao(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
}
