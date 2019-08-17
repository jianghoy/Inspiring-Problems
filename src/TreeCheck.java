import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TreeCheck {
    public boolean treeCheck(int[][] relationships, int n) {
        if (n < 0) {
            return false;
        }
        // for no node or one node return true
        if ((relationships == null || relationships.length == 0) && (n == 0 || n == 1)) {
            return true;
        }
        int[] ancestor = new int[n];
        Arrays.fill(ancestor, -1);

        Map<Integer, TreeNode> nodeMap = new HashMap<>();

        for (int[] relation : relationships) {
            TreeNode parent = nodeMap.getOrDefault(relation[0], new TreeNode(relation[0]));
            TreeNode child = nodeMap.getOrDefault(relation[1], new TreeNode(relation[1]));

            // local relationship building
            if (parent.left != null && parent.right != null) {
                return false;
            }
            if (parent.right == null) {
                parent.right = child;
            } else {
                parent.left = child;
            }

            if (child.parent != null) {
                return false;
            }
            child.parent = parent;

            // update ancestor: Union Find like
            if (!updateAncestor(ancestor, relation[0], relation[1])) {
                return false;
            }

            nodeMap.put(relation[0], parent);
            nodeMap.put(relation[1], child);
        }
        return checkOneAncestor(ancestor);


    }

    private boolean updateAncestor(int[] ancestor, int parent, int child) {

        // find root; set ancestor to root
        if (ancestor[parent] == -1) {
            ancestor[child] = parent;
        //same ancestor -> child is somehow in the tree
        } else if (ancestor[parent] == ancestor[child]) {
            return false;
        } else {
            // update recursively
            updateAncestor(ancestor, ancestor[parent], parent);
            ancestor[child] = ancestor[parent];
        }
        return ancestor[child] != child;
    }

    private boolean checkOneAncestor(int[] ancestor) {
        int root = -1;
        int negativeOneCount = 0;
        for (int x : ancestor) {
            if (x == -1) {
                negativeOneCount++;
            } else if (root == -1) {
                root = x;
            } else if (root != x) {
                return false;
            }

        }
        return negativeOneCount == 1;
    }
}

class TreeNode {
    int val;
    TreeNode parent;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
