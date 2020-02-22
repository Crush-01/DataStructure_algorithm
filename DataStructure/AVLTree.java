package data_structure_offer.DataStructure;

public class AVLTree<T extends Comparable<T>> {
    AVLTreeNode<T> root=null; //根节点
    //AVL树节点 内部类
    class AVLTreeNode<T extends Comparable<T>>{
        T key;//关键字
        int height;//该节点的高度
        AVLTreeNode<T> left;
        AVLTreeNode<T> right;
        public AVLTreeNode(){ }
        public AVLTreeNode(T key,AVLTreeNode<T> left,AVLTreeNode<T> right){
            this.key=key;
            this.left=left;
            this.right=right;
            this.height=0;
        }
    }
    //构造函数
    public AVLTree(){ }
    //获取树的高度
    private int height(AVLTreeNode<T> tree){
        if(tree!=null)
            return tree.height;
        return 0;
    }
    public int height(){
        return height(root);
    }

    //比较两个数的大小
    public int max(int a,int b){
        return a>b?a:b;
    }
    /*
    * 前序遍历
    * */
    private void preOrder(AVLTreeNode<T> node){
        if(node!=null){
            System.out.println(node.key);
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    public void preOrder(){
        preOrder(root);
    }
    /*
    * 中序遍历
    * */
    private void inOrder(AVLTreeNode<T> node){
        if(node!=null){
            inOrder(node.left);
            System.out.println(node.key);
            inOrder(node.right);
        }
    }
    public void inOrder(){
        inOrder(root);
    }
    /*
    * 后序遍历
    * */
    private void postOrder(AVLTreeNode<T> node){
        if(node!=null){
            inOrder(node.left);
            inOrder(node.right);
            System.out.println(node.key);
        }
    }
    public void postOrder(){
        postOrder(root);
    }
    /*
    * LL型 新结点插入到了根结点的左孩子的左子树上导致了不平衡
    * 需要 右单旋转
    * */
    private AVLTreeNode<T> LL_Rotation(AVLTreeNode<T> node){
        AVLTreeNode<T> rotate=node.left;  //node为不平衡的根节点，n为旋转中心的节点
        node.left=rotate.right;
        rotate.right=node;
        node.height=max(height(node.left),height(node.right))+1; //node升高了一个位置
        rotate.height=max(height(rotate.left),node.height)+1;
        return rotate;
    }

    /*
    * RR型 （单向左旋转）
    * */
    private AVLTreeNode<T> RR_Rotation(AVLTreeNode<T> node){
        AVLTreeNode<T> rotate=node.right;
        node.right=rotate.left;
        rotate.left=node;

        node.height=max(height(node.right),height(node.left))+1;
        rotate.height=max(height(rotate.right),node.height);
        return rotate;
    }

    /*
    * RL型 （右左旋转）
    * */
    private AVLTreeNode<T> RL_Rotation(AVLTreeNode<T> node){
        node.right=LL_Rotation(node.right);
        return RR_Rotation(node);
    }

    /*
    * LR型 （左右旋转）
    * */
    private AVLTreeNode<T> LR_Rotation(AVLTreeNode<T> node){
        node.left=RR_Rotation(node.left);
        return LL_Rotation(node);
    }


    /*
    * 将节点插入AVL树，并返回根节点
    * */
    private AVLTreeNode<T> insert(AVLTreeNode<T> node,T key){
        if(node==null){
            node=new AVLTreeNode(key,null,null);
            if(node==null){
                System.out.println("ERROR:创建AVL树失败");
                return null;
            }
        }else{
            int cmp=key.compareTo(node.key);
            if(cmp<0){  //插入左子树
                node.left=insert(node.left,key);
                //插入节点后，若AVL树失去平衡，则进行调整
                if(height(node.left)-height(node.right)==2){//LL or LR
                    if(key.compareTo(node.left.key)<0){//LL
                        node=LL_Rotation(node);
                    }else{
                        node=LR_Rotation(node);
                    }
                }
            }else if(cmp>0){
                node.right=insert(node.right,key);
                if(height(node.right)-height(node.left)==2){ //RR or RL
                    if(key.compareTo(node.key)>0)
                        node=RR_Rotation(node);
                    else
                        node=RL_Rotation(node);
                }
            }else{
                System.out.println("添加失败，不允许添加重复节点");
            }
        }
        node.height=max(height(node.left),height(node.right))+1;
//        System.out.println("添加"+key);
        return node;
    }
    public void  insert(T key){
        root=insert(root,key);
    }
}
