import java.util.*;
public class main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String ques=sc.nextLine();
            int maxLen=0;
            int len=0;
            List<String> maxList=new ArrayList<String>();
            String tempRes="";
            for(int i=0;i<ques.length();i++){
                if(ques.charAt(i)>='0'&&ques.charAt(i)<='9'){
                    tempRes+=ques.charAt(i);
                    len++;
                    if(i==ques.length()-1){
                        if(len>maxLen){
                            maxList.clear();
                            maxList.add(tempRes);
                            maxLen=len;
                            len=0;
                            tempRes="";
                        }else if(len==maxLen){
                            if(len!=0){
                                len=0;
                                maxList.add(tempRes);
                                tempRes="";
                            }
                        }
                    }
                }else{
                    if(len>maxLen){
                        maxList.clear();
                        maxList.add(tempRes);
                        maxLen=len;
                        len=0;
                        tempRes="";
                    }else if(len==maxLen){
                        if(len!=0){
                            len=0;
                            maxList.add(tempRes);
                            tempRes="";
                        }
                    }else{
                        len=0;
                        tempRes="";
                    }
                }
            }
            if(maxList.size()==1){
                System.out.println(maxList.get(0)+","+maxLen);
            }else if(maxList.size()==0){
                System.out.println("");
            }else{
                String res="";
                for(String temp:maxList){
                    res+=(temp+",");
                }
                System.out.println(res+maxLen);
            }
        }
    }
}