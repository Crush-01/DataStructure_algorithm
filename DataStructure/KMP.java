package data_structure_offer.DataStructure;

public class KMP {
    public static void main(String[] args) {
        KMP kmp=new KMP();
//        char[] modelStr={'a','b','c','d','a','b','c','a'};
//        char[] modelStr={'a','a','b','a','a','b','a','a','a'};
//        int[] next=kmp.getNextArray(modelStr);
//        for(int i:next){
//            System.out.println(i);
//        }
        char[] OriginStr="abcde".toCharArray();
        char[] ModelStr="de".toCharArray();
        int a=kmp.KMPMatch(OriginStr,ModelStr);
        if(a>-1){
            System.out.println("匹配成功，子串在主串的位置是："+a);
        }
    }
    public int KMPMatch(char[] OriginStr,char[] ModelStr){
        int i=0,j=0;
        int[] next=getNextArray(ModelStr);
        while(i<ModelStr.length&&j<OriginStr.length){
            if(i==-1||ModelStr[i]==OriginStr[j]){ //i==-1 是第一次匹配失败的情况
                i++;
                j++;
            }else{
                i=next[i];
            }
        }//i=ModelStr.length结束循环
        if(i==ModelStr.length){
            return j-i;    //表示模式串全部匹配
        }
        return -1;
    }
    public int[] getNextArray(char[] modelStr){ //求next[]
        int[] next=new int[modelStr.length+1];
        next[0]=-1;
        next[1]=0;
        int k=0;
        for(int j=1;j<modelStr.length;j++){
            k=next[j];
            while(k>=0){
                if (modelStr[k] == modelStr[j]) {//如果匹配，k在下一次for循环就等于最后一次存入next数组的值（k+1）
                    next[j+1] = k+ 1;              //也就是k=k+1;
                    break;
                } else {
                    k=next[k]; //如果匹配失败，k就等于前一个字符对应的next数组的值
                }
            }
        }
        return next;
    }
}
