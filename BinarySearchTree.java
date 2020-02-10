package data_structure_offer;
//二分查找树
public class BinarySearchTree {
    int data;
    BinarySearchTree left;
    BinarySearchTree right;
    BinarySearchTree(int data){
        this.data=data;
    }
//    测试代码
    public static void main(String[] args) {
        int[] a={5,9,1,7,3,4};
        BinarySearchTree node=new BinarySearchTree(a[0]);
        for(int i=1;i<a.length;i++){
            node.insert(node,a[i]);
        }
        node.in(node);
    }
    public void insert(BinarySearchTree root,int data){
        if(root!=null){
            if(root.data<data){
                if(root.right==null){
                    root.right=new BinarySearchTree(data);
                }else{
                    insert(root.right,data);
                }
            }else if(root.data>data){
                if(root.left==null){
                    root.left=new BinarySearchTree(data);
                }else{
                    insert(root.left,data);
                }
            }
        }

    }

//    中序遍历
    public void in(BinarySearchTree root){
        if(root!=null){
            in(root.left);
            System.out.println(root.data);
            in(root.right);
        }
    }
}
