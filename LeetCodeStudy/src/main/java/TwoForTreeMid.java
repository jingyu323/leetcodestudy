import java.util.ArrayList;
import java.util.List;

public class TwoForTreeMid {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(  root , res);
        return res;
    }

    public void preOrder(TreeNode root ,List<Integer>  res){

        if(root == null){
            return;
        }
        if(root.left!=null){
            preOrder(root.left,res);

        }
        res.add(root.val);
        if(root.right!=null){
            preOrder(root.right,res);
        }
    }
}
