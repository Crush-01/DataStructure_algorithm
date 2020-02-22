package data_structure_offer.offer;

import java.util.Arrays;

/*输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
**例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
* 解决：一个不断缩短查找数组的范围，递归的过程
* */
public class ReConstuctBinaryTree {
    public static void main(String[] args) {
        ReConstuctBinaryTree constuct=new ReConstuctBinaryTree();
        int[]pre={1,2,4,7,3,5,6,8};
        int[]in={4,7,2,1,5,3,8,6};
        TreeNode root=constuct.reConstructBinaryTree(pre,in);
        System.out.println("前序");
        constuct.preTraverse(root);
        System.out.println("\n后序");
        constuct.postTraverse(root);
        System.out.println("\n中序");
        constuct.inTraverse(root);
    }

    private TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length==0)//数组的长度为0表示，没有左/右节点
            return null;
        int NodeVal=pre[0];
        if(pre.length==1)//表示左子树的最后一个节点
            return new TreeNode(NodeVal);
        TreeNode node=new TreeNode(NodeVal);  //根据中序遍历在前序遍历中，下一个为左节点，左子树的全部节点的下一个数表示右节点
        int index=0;
        for(int i=0;i<in.length;i++){
            if(NodeVal==in[i]){
                index=i;//当没有左节点的时候，index=0  Arrays.copyOfRange(pre,1,1)是空数组
                break;
            }
        }
        node.left=reConstructBinaryTree(Arrays.copyOfRange(pre,1,index+1),Arrays.copyOfRange(in,0,index));
        node.right=reConstructBinaryTree(Arrays.copyOfRange(pre,index+1,pre.length),Arrays.copyOfRange(in,index+1,in.length));
        return node;
    }
    public void preTraverse(TreeNode node){
        if(node!=null){
            System.out.print(node.val+"\t");
            preTraverse(node.left);
            preTraverse(node.right);
        }
    }
    public void inTraverse(TreeNode node){
        if(node!=null){
            inTraverse(node.left);
            System.out.print(node.val+"\t");
            inTraverse(node.right);
        }
    }
    public void postTraverse(TreeNode node){
        if(node!=null){
            postTraverse(node.left);
            postTraverse(node.right);
            System.out.print(node.val+"\t");
        }
    }

}
