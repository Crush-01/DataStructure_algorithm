package data_structure_offer.DataStructure.Sort;
//选择排序
public class SelectionSort {
    public static void main(String[] args) {
        int[] a={5,3,10,7,8,2};
        SelectionSort selectionSort=new SelectionSort();
        selectionSort.selectSort(a);
        for(int i:a){
            System.out.println(i);
        }
    }
    public void selectSort(int[] array){
        int minIndex=0,temp=0;
        int length=array.length;
        for(int i=0;i<length-1;i++){
            minIndex=i;
            for(int j=i+1;j<length;j++){
                if(array[j]<array[i]){
                    minIndex=j;
                }
            }
            temp=array[i];
            array[i]=array[minIndex];
            array[minIndex]=temp;
        }
    }
}
