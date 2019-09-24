import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        try {
            FileInputStream fis=new FileInputStream("input.txt");
            System.setIn(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int[] a=new int[n];
            for(int i=0;i<n;i++){
                if(i==0){
                    a[i]=sc.nextInt();
                }else{
                    a[i]=a[i-1]+sc.nextInt();
                }
            }
            int m=sc.nextInt();
            for(int i=0;i<m;i++){
                int ques=sc.nextInt();
                int start=0,end=n-1;
                while(start<=end){
                    int mid=(start+end)/2;
                    if(ques>a[mid]){
                        start=mid+1;
                        continue;
                    }
                    if(ques<=a[mid]){
                        if(mid==0){
                            System.out.println(1);
                            break;
                        }else{
                            if(ques==a[mid-1]){
                                System.out.println(mid);
                            }else if(ques<a[mid-1]){
                                end=mid-1;
                            }else{
                                System.out.println(mid+1);
                            }
                        }
                    }
                }
            }
        }
    }
}