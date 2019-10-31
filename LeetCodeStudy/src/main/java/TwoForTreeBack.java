import java.util.ArrayList;
import java.util.List;

public class TwoForTreeBack {

    public static void main(String[] args) {

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        n1.left = n2;
        n1.right = n3;
        n2.right =n4;

        List<Integer> res =  new TwoForTreeBack().preorderTraversal(n1);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(  root , res);
        return res;
    }

    public void preOrder(TreeNode root ,List<Integer>  res){

        if(root == null){
            return;
        }
        System.out.println("first"+root.val);
        if(root.left!=null){
            preOrder(root.left,res);

        }
        System.out.println("mid"+root.val);
        if(root.right!=null){
            preOrder(root.right,res);
        }
        res.add(root.val);
        System.out.println(root.val);
    }
}
