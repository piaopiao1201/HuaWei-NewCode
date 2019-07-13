import java.util.*;
public class main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
            String ques=sc.nextLine();
            char[] quesArr=ques.toCharArray();
            for(int i=1;i<quesArr.length;i++){
                if(quesArr[i]<'A'||quesArr[i]>'z'||(quesArr[i]>'Z'&&quesArr[i]<'a')){
                    continue;
                }
                char rawData=quesArr[i];
                char temp=quesArr[i];
                if(temp>='a'&&temp<='z'){
                    temp-=32;
                }
                int lastIndex=i;
                int j;
                for(j=i-1;j>=0;j--){
                    if(quesArr[j]<'A'||quesArr[j]>'z'||(quesArr[j]>'Z'&&quesArr[j]<'a')){
                        continue;
                    }

                    char now=quesArr[j];
                    if(now>='a'&&now<='z'){
                        now-=32;
                    }
                    if(temp<now){
                        quesArr[lastIndex]=quesArr[j];
                        lastIndex=j;
//                        if(j==0){
//                            quesArr[j]=rawData;
//                            continue;
//                        }
                    }else{
                        quesArr[lastIndex]=rawData;
                        break;
                    }
                }
                if(j==-1){
                    quesArr[lastIndex]=rawData;
                }
            }
        String res=new String(quesArr);
        System.out.println(res);
    }
}
