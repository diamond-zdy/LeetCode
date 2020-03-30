import java.util.*;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}
public class Balance {
    public boolean isBalance(TreeNode root) {
        if (root == null){
            return true;
        }
        int leftHigh = getTreehigh(root.left);
        int rightHigh = getTreehigh(root.right);
        if (Math.abs(leftHigh-rightHigh)>1){
            return false;
        }
        return isBalance(root.left) && isBalance(root.right);
    }

    private int getTreehigh(TreeNode root) {
        if (root == null){
            return 0;
        }
        return Math.max(getTreehigh(root.left),getTreehigh(root.right))+1;
    }
}
