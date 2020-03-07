package data_structure_offer.DataStructure.Sort;

public class QuickSort {
    public static void main(String[] args) {
        QuickSort quickSort=new QuickSort();
        int[]a={49,38,65,97,76,13,27};
        quickSort.sort(a,0,a.length-1);
        for(int i:a){
            System.out.println(i);
        }

    }
    public void sort(int[] array,int left,int right){
        if(left>right){
            return;
        }
        int base=array[left];
        int i=left,j=right;
        while(i!=j){
            // 顺序很重要，先从右边开始往左找，直到找到比base值小的数
            while(i<j&&array[j]>=base){
                j--;
            }
            // 再从左往右边找，直到找到比base值大的数
            while(i<j&&array[i]<=base){
                i++;
            }
            // 上面的循环结束表示找到了位置或者(i>=j)了，交换两个数在数组中的位置
            System.out.println(i+"/"+j);
            if(i<j){
                int temp=array[i];
                array[i]=array[j];
                array[j]=temp;
            }
        }
        //i==j 将基准数放到中间的位置（基准数归位）
        array[left]=array[i];
        array[i]=base;
        for(int s:array){
            System.out.print("--"+s);
        }
        System.out.println();
        sort(array,left,i-1);
        sort(array,i+1,right);
    }
}
