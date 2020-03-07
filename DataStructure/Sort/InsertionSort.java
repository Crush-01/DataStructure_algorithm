package data_structure_offer.DataStructure.Sort;
//插入排序
public class InsertionSort {
    public static void main(String[] args) {
        int[] a={4,10,8,21,15,7,2};
        InsertionSort insertionSort=new InsertionSort();
        insertionSort.sort(a);
        for(int i:a){
            System.out.println(i);
        }
    }
    public void sort(int[] array){
        int length=array.length;
        int preIndex,current;
        for(int i=1;i<length;i++){
            preIndex=i-1;
            current=array[i];
            while(preIndex>=0&&array[preIndex]>current){
                array[preIndex+1]=array[preIndex];
                preIndex--;
            }
            array[preIndex+1]=current;
        }
    }
}
