package data_structure_offer.DataStructure;

public class AVLTreeTest {
    public static void main(String[] args) {
        AVLTree<Integer> tree=new AVLTree();
        int[]a={1,2,3,4,5,6,7,8,9,10};
        for(int i:a){
            tree.insert(i);
        }
        tree.preOrder();
        tree.inOrder();
    }
}
