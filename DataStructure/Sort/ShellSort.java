package data_structure_offer.DataStructure.Sort;

public class ShellSort {
    public static void main(String[] args) {
        ShellSort sort=new ShellSort();
        int[]a={81,94,11,96,12,35,17,95,28,58,41,75,15};
        sort.sellsort(a);
        for(int i:a){
            System.out.println(i);
        }
    }
    public void sellsort(int[] array){
        int length=array.length;
        for(int interval = (int) Math.floor(length/2);interval>=1;interval=(int)Math.floor(interval/2)){
            for(int i=interval;i<length;i++){
                int j=i;
                int current=array[i];
                while(j-interval>=0&&current<array[j-interval]){//直接插入排序，只不过间隔变了
                    array[j]=array[j-interval];
                    j=j-interval;
                }
                array[j]=current;
            }
        }
    }
}
